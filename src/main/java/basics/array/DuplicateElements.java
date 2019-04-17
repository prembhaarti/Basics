package basics.array;

public class DuplicateElements {

	public static void main(String[] args) {
		int[] array= {0,1,2,3,3,4,5,6,7,8};
//
		int temp =array[0];

		for(int i=1; i< array.length ; i++){
			temp = temp^array[i];
		}

		System.out.println(temp);

	}
}
