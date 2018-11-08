package basics.dp;

public class SpecialKeys {

	public static int MAX_KEYS_TO_PRESS= 75;

	public static void main(String[] args) {

		System.out.println(getMaxCharProduced(7));

	}

	public static int getMaxCharProduced(int keysToPress){
		if(keysToPress>MAX_KEYS_TO_PRESS || keysToPress < 1)
			return -1;
		else {
			int arr[] =	getMaxCharProducedArray();
			return arr[keysToPress-1];
		}
	}


	public static int[] getMaxCharProducedArray(){

		int arr[] = new int[75];
		arr[0]=1;
		arr[1]=2;
		arr[2]=3;
		arr[3]=4;
		arr[4]=5;
		arr[5]=6;

		for(int i=6; i<MAX_KEYS_TO_PRESS-1;i++){
			arr[i] = 2*(arr[i-3]);
		}
		return arr;
	}
}
