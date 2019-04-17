package basics.stringop;

import java.util.HashSet;
import java.util.Set;

public class FindLargestWord {


	private static boolean isSubSequence(char[] str1, char[] str2)
	{
		int m = str1.length, n = str2.length;

		int j = 0; // For index of str1 (or subsequence

		// Traverse str2 and str1, and compare current
		// character of str2 with first unmatched char
		// of str1, if matched then move ahead in str1
		for (int i=0; i<n&&j<m; i++)
			if (str1[j] == str2[i])
				j++;

		// If all characters of str1 were found in str2
		return (j==m);
	}

	// Returns the longest string in dictionary which is a
	// subsequence of str.
	public static String findLongestString(Set<String> dict, String str)
	{
		String result = "";
		int length = 0;

		// Traverse through all words of dictionary
		for (String word : dict)
		{
			// If current word is subsequence of str and is largest
			// such word so far.
			if (length < word.length() && isSubSequence(word.toCharArray(), str.toCharArray()))
			{
				result = word;
				length = word.length();
			}
		}

		// Return longest string
		return result;
	}

	public static void main(String[] args) {
		Set<String> words = new HashSet<>();
		words.add("cart");
		words.add("flipkart");
		words.add("flip");
		words.add("lip");
		words.add("part");
		System.out.println(findLongestString(words, "lkfcdlipkdaart"));
		System.out.println(findLongestString(words, "dkarlfip"));


	}
}
