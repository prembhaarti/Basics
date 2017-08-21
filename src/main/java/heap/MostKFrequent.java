package heap;

import java.util.*;

public class MostKFrequent {

    PriorityQueue<Data> minHeap = new PriorityQueue<>(Comparator.comparing(Data::getFreq));
    Map<Integer, Data> dataFreqMap = new HashMap<>();

    public static void main(String[] args) {

        int arr[] = {1,2,1,3,4,5,4};
        MostKFrequent mkf= new MostKFrequent();
        List<Integer> result=mkf.getMostKFrequent(arr, 5);
        System.out.println(result);
    }

    public List<Integer> getMostKFrequent(int[] arr, int k) {
        for(int i=0;i<arr.length;i++) {
            Data data=dataFreqMap.get(arr[i]);
            if (data == null) {
                Data newData= new Data(arr[i],1);
                dataFreqMap.put(arr[i],newData);
                if(minHeap.size()<k){
                    minHeap.offer(newData);
                }
            }
            else {
                if(data.getFreq()+1>minHeap.peek().getFreq()){
                    data.setFreq(data.getFreq()+1);
                    if (!minHeap.contains(data)) {
                        minHeap.poll();
                        minHeap.offer(data);
                    }
                    dataFreqMap.put(arr[i],data);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (Data data : minHeap) {
            result.add(data.getData());
        }
        return result;
    }

}

class Data{
    private int data;
    private int freq;

    public Data(int data, int freq) {
        this.data = data;
        this.freq = freq;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Data data1 = (Data) o;

        return data == data1.data;
    }

    @Override
    public int hashCode() {
        return data;
    }
}