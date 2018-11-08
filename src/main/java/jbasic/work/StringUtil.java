package jbasic.work;

public class StringUtil {
	public static void main(String[] args) {

		String a = "abcdef";

		if(a.length()>5){
			System.out.println(a.substring(0,5));
			String b = a.substring(0,5);
			System.out.println(b);
		}
	}
}
