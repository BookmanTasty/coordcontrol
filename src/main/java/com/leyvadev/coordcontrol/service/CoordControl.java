package com.leyvadev.coordcontrol.service;

import com.leyvadev.coordcontrol.dto.LoadCords;
import com.leyvadev.coordcontrol.model.PointOfInterest;

import java.util.List;
import java.util.UUID;

public interface CoordControl {
    PointOfInterest storePointOfInterest(LoadCords loadCords);
    List<PointOfInterest> getPointsOfInterest();
    void deletePointOfInterest(UUID id);
}
