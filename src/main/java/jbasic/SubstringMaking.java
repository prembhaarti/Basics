package jbasic;

import org.joda.time.DateTime;

public class SubstringMaking {

	public static void main(String[] args) {
//		DateTime dateTime = new DateTime(System.currentTimeMillis());
//		System.out.println(dateTime);

		String word = "xyzasdfsf";
		System.out.println(word.substring(0, Math.min(word.length(),6)));

	}


}
