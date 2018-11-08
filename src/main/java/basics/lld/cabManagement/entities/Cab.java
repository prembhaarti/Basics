
package basics.lld.cabManagement.entities;

import basics.lld.cabManagement.constants.CabState;

import java.util.Date;

public class Cab {

    private int cabId;
    private String sourceCity;
    private String destinationCity;
    private CabState state;
    private int tripsCovered;
    private Date lastBookedTime;
    private Date lastIdleTime;

    public Cab(int cabId, String sourceCity, CabState state, int tripsCovered, Date lastIdleTime) {
        this.cabId = cabId;
        this.sourceCity = sourceCity;
        this.state = state;
        this.tripsCovered = tripsCovered;
        this.lastIdleTime=lastIdleTime;
    }

    public int getCabId() {
        return cabId;
    }

    public void setCabId(int cabId) {
        this.cabId = cabId;
    }

    public String getSourceCity() {
        return sourceCity;
    }

    public void setSourceCity(String sourceCity) {
        this.sourceCity = sourceCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public CabState getState() {
        return state;
    }

    public void setState(CabState state) {
        this.state = state;
    }

    public int getTripsCovered() {
        return tripsCovered;
    }

    public void setTripsCovered(int tripsCovered) {
        this.tripsCovered = tripsCovered;
    }

    public Date getLastBookedTime() {
        return lastBookedTime;
    }

    public void setLastBookedTime(Date lastBookedTime) {
        this.lastBookedTime = lastBookedTime;
    }

    public Date getLastIdleTime() {
        return lastIdleTime;
    }

    public void setLastIdleTime(Date lastIdleTime) {
        this.lastIdleTime = lastIdleTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cab cab = (Cab) o;
        return cabId == cab.cabId;
    }

    @Override
    public int hashCode() {
        return cabId;
    }

    @Override
    public String toString() {
        return "Cab{" +
                "cabId=" + cabId +
                ", sourceCity='" + sourceCity + '\'' +
                ", destinationCity='" + destinationCity + '\'' +
                ", state=" + state +
                ", tripsCovered=" + tripsCovered +
                ", lastBookedTime=" + lastBookedTime +
                ", lastIdleTime=" + lastIdleTime +
                '}';
    }
}