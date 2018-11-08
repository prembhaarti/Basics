package basics.array;

public class MinNoOfMovesToMaximize {


    public static void main(String[] args) {
        int[] arr={1,2,3};
        maximize(arr,2);
        System.out.println(getNum(arr));

    }

    public int result(int[] arr, int moves){
        if(moves<1){
            return getNum(arr);
        }
        maximize(arr,moves);
        return getNum(arr);
    }

    public static void swap(int[] arr,int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static int getNum(int[] arr){
        int sum=0;
        for(int i=arr.length-1,j=0;i>=0;i--,j++){
            if(j==0){
                sum=arr[i];continue;
            }
            sum+=Math.pow(10,j)*arr[i];
        }
        return sum;
    }


    public static void maximize(int[] arr, int swapsAllowed)
    {
        if (arr == null)
        {
            return;
        }

        int start = 0;
        int swapsLeft = swapsAllowed;
        int lastIndex = swapsLeft + start < arr.length - 1 ? swapsLeft + start : arr.length - 1;
        int maxIndex = start;

        while (swapsLeft > 0 &&
                start < arr.length)
        {
            for (int i = start + 1; i <= lastIndex; i++)
            {
                if (arr[i] > arr[maxIndex])
                {
                    maxIndex = i;
                }
            }

            if (maxIndex > start)
            {
                for (int i = maxIndex; i >= start + 1; i--)
                {
                    swap( arr, i,i-1);
                }
            }

            swapsLeft = swapsLeft - (maxIndex - start);
            start++;
            lastIndex = swapsLeft + start < arr.length - 1 ? swapsLeft + start : arr.length - 1;
            maxIndex = start;
        }
    }


}
