package lld.cabManagement.manager;

import lld.cabManagement.entities.Cab;

public interface StateManager {

    public boolean changeCabState(Cab cab, String state);


}
