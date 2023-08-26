package com.leyvadev.coordcontrol.service;

import com.leyvadev.coordcontrol.client.GoogleMapsRest;
import com.leyvadev.coordcontrol.dto.LoadCords;
import com.leyvadev.coordcontrol.dto.Result;
import com.leyvadev.coordcontrol.dto.Root;
import com.leyvadev.coordcontrol.model.PointOfInterest;
import com.leyvadev.coordcontrol.repository.PointOfInterestRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
@ApplicationScoped
public class CoorControlImpl implements CoordControl {
    @Inject
    private PointOfInterestRepository pointOfInterestRepository;
    @Inject
    @RestClient
    private GoogleMapsRest googleMapsRest;
    @ConfigProperty(name = "google.maps.api.key")
    private String googleMapsApiKey;
    @Override
    @Transactional
    public PointOfInterest storePointOfInterest(LoadCords loadCords) {
        if (loadCords.getLat().isBlank() || loadCords.getLng().isBlank()){
            throw new IllegalArgumentException("Latitud y longitud no pueden estar vacias");
        }
        convertirLatitudLongitud(loadCords);
        Root geocodeResult = googleMapsRest.getByCords(loadCords.getLat() + "," + loadCords.getLng(), googleMapsApiKey);
        PointOfInterest pointOfInterest = new PointOfInterest();
        pointOfInterest.setLat(BigDecimal.valueOf(Double.parseDouble(loadCords.getLat())));
        pointOfInterest.setLng(BigDecimal.valueOf(Double.parseDouble(loadCords.getLng())));
        pointOfInterest.setAddress(geocodeResult.getResults().get(0).getFormattedAddress());
        pointOfInterest.setAddressComponents(geocodeResult.getResults().get(0).getAddressComponents());
        pointOfInterest.setOptionalAddress(geocodeResult.getResults());
        pointOfInterestRepository.persist(pointOfInterest);
        return pointOfInterest;
    }

    @Override
    public List<PointOfInterest> getPointsOfInterest() {
        return pointOfInterestRepository.listAll();
    }

    @Override
    public void deletePointOfInterest(UUID id) {
        pointOfInterestRepository.deleteById(id);
    }

    private void convertirLatitudLongitud(LoadCords loadCords){
        loadCords.setLat(convertirCoordenada(loadCords.getLat()));
        loadCords.setLng(convertirCoordenada(loadCords.getLng()));
    }

    private String convertirCoordenada(String coordenada){
        if(!coordenada.contains(".")){
            if (coordenada.contains("-")){
                coordenada = coordenada.substring(0,3) + "." + coordenada.substring(3);
            } else {
                coordenada = coordenada.substring(0,2) + "." + coordenada.substring(2);
            }
        }
        return coordenada;
    }
}
