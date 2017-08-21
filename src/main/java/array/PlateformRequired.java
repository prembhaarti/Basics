package array;

import java.util.ArrayList;
import java.util.List;

public class PlateformRequired {

    public static void main(String[] args) {
        PlateformRequired pr= new PlateformRequired();
        System.out.println(pr.plateFormRequired(pr.getTrain()));
    }

    public int plateFormRequired(List<Train> trains){
        int[] arr = new int[24];
        for (Train train : trains) {
            for(int i=train.startTime;i<train.endTime;i++) {
                arr[i]+=1;
            }
        }
        int plateFormRequired=0;
        for(int i=0;i<arr.length;i++) {
            plateFormRequired = Math.max(arr[i], plateFormRequired);
        }
        return plateFormRequired;
    }

    public List<Train> getTrain() {
        List<Train> trains = new ArrayList<>();
        trains.add(new Train(1, 3));
        trains.add(new Train(2, 6));
        trains.add(new Train(4, 7));
        trains.add(new Train(5, 8));
        trains.add(new Train(7, 9));
        return trains;
    }
}

class Train{
    public int startTime;
    public int endTime;

    public Train(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}