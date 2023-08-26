package com.leyvadev.coordcontrol.repository;

import com.leyvadev.coordcontrol.model.PointOfInterest;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.UUID;

@ApplicationScoped
public class PointOfInterestRepository implements PanacheRepositoryBase<PointOfInterest, UUID> {
}
