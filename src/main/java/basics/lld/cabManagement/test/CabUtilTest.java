package basics.lld.cabManagement.test;

import basics.lld.cabManagement.constants.CabState;
import basics.lld.cabManagement.constants.Strategy;
import basics.lld.cabManagement.dao.dao.impl.CabDaoImpl;
import basics.lld.cabManagement.entities.Cab;
import basics.lld.cabManagement.manager.manager.impl.BookingManagerImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CabUtilTest {

    public static void main(String[] args) {
        CabUtilTest test= new CabUtilTest();
        CabDaoImpl cabDao= new CabDaoImpl();
        BookingManagerImpl bookingManager= new BookingManagerImpl();
        List<Cab> cabs= test.getCabs();

        cabDao.loadCabs(cabs);
        for(int i=0;i<5;i++) {
            Cab cab = bookingManager.bookCab("DELHI", "GOA", Strategy.MOST_IDEAL);
            if (cab != null) {
                System.out.println("Booked cab:" + cab);
            } else {
                System.out.println("Cabs can't be booked");
            }

            if(null!=cab){
                bookingManager.endTrip(cab);
                System.out.println("Trip ended for cab:"+cab);
            }
            else {

            }
            if(null!=cab) {
                bookingManager.changeCabCity(cab, "MUMBAI");
            }
        }

        for(int i=0;i<5;i++) {

            Cab cab = bookingManager.bookCab("GOA", "MUMBAI", Strategy.MOST_IDEAL);
            System.out.println(cab);
        }
    }



    /**
     * int cabId, String sourceCity, CabState state, int tripsCovered, Date lastIdleTime
     * @return
     */
    public List<Cab> getCabs(){
        int id=0;
        Cab cab1= new Cab(++id,"DELHI", CabState.IDLE,0,new Date(System.currentTimeMillis()));
        Cab cab2= new Cab(++id,"DELHI", CabState.IDLE,0,new Date(System.currentTimeMillis()));
        Cab cab3= new Cab(++id,"DELHI", CabState.IDLE,0,new Date(System.currentTimeMillis()));
        Cab cab4= new Cab(++id,"MUMBAI", CabState.IDLE,0,new Date(System.currentTimeMillis()));
        Cab cab5= new Cab(++id,"MUMBAI", CabState.IDLE,0,new Date(System.currentTimeMillis()));
        Cab cab6= new Cab(++id,"MUMBAI", CabState.IDLE,0,new Date(System.currentTimeMillis()));
        Cab cab7= new Cab(++id,"GOA", CabState.IDLE,0,new Date(System.currentTimeMillis()));
        Cab cab8= new Cab(++id,"GOA", CabState.IDLE,0,new Date(System.currentTimeMillis()));
        Cab cab9= new Cab(++id,"PATNA", CabState.IDLE,0,new Date(System.currentTimeMillis()));
        Cab cab10= new Cab(++id,"PATNA", CabState.IDLE,0,new Date(System.currentTimeMillis()));
        List<Cab> cabs=new ArrayList<>();
        cabs.add(cab1);
        cabs.add(cab2);
        cabs.add(cab3);
        cabs.add(cab4);
        cabs.add(cab5);
        cabs.add(cab6);
        cabs.add(cab7);
        cabs.add(cab8);
        cabs.add(cab9);
        cabs.add(cab10);
        return cabs;
    }
}
