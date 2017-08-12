package lld.cabManagement.manager;

import lld.cabManagement.entities.Cab;

import java.util.Comparator;

public interface AvailabilityManager {

    Cab getAvailability(String citySource);
    Cab getAvailabilityByCriteria(String citySource, Comparator<Cab> comparator);



}
