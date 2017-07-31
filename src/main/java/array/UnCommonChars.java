package array;

public class UnCommonChars {

    public static void main(String[] args) {
        String word1= "abcdef";
        String word2= "bdfggab";
        uncommon(word1.toCharArray(),word2.toCharArray());
    }

    public static void uncommon(char[] word1, char[] word2){
        int[] arr= new int[256];

        for(char ch:word1){
            arr[ch]=1;
        }
        for(char ch:word2){
            if(arr[ch]==0){
                arr[ch]=2;
            }
            if(arr[ch]==1){
                arr[ch]=-1;
            }
        }

        for(int i=0;i<256;i++){
            if(arr[i]==1 || arr[i]==2){
                System.out.println((char)i);
            }
        }

    }
}