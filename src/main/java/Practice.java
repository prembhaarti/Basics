public class Practice {

	public static void main(String[] args) {
		permutation("ABC".toCharArray(),0);
	}

	public static void permutation(char[] word, int base){
		for(int i=base; i< word.length;i++) {
			if (base == word.length - 1) {
				System.out.println(word);
				return;
			}
			swap(word, i,base);
			permutation(word, base + 1);
			swap(word, i, base);
		}
	}

	public static void swap(char[] word, int i, int j){
		char temp = word[i];
		word[i]=word[j];
		word[j]=temp;
	}


}
