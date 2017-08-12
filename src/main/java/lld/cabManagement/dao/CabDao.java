package lld.cabManagement.dao;

import lld.cabManagement.entities.Cab;

import java.util.List;

public interface CabDao {


    public boolean addCab(String sourceCity,Cab cab);

    public boolean loadCabs(List<Cab> cabs);
/*
    public Cab getLeastTripCab();
    public Cab getMostIdleCabs();
*/

}
