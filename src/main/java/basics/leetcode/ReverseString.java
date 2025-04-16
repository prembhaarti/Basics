package basics.leetcode;

/**
 * Created by Edward on 28/07/2017.
 */
public class ReverseString {
    /**
     * 344. Reverse String
     * Write a function that takes a string as input and returns the string reversed.

     Example:
     Given s = "hello", return "olleh".

     time : O(n);
     space : O(n);
     * @param s
     * @return
     */

    public static void main(String[] args) {
        String str = "hello";
        reverseString(str.toCharArray());
        System.out.println(str);
    }
    public static void reverseString(char[] s) {
        if (s == null || s.length == 0) return;
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }
}
