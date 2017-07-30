package stringop;

/**
 * given string -> abcabcabc    (abc)
 * can given string made of its substring by repeating
 *
 * find max length of prefix-suffix length
 *
 * string length % (stringLen-maxPrefixSuffixLen) ==0 ->true:false
 *
 * abcabcabc->9
 * 9%(9-6) = 9%3 => 0
 *
 */
public class StringFormationFromSubString {

  public static void main(String[] args) {
    //String mainString="abcabcabc";
    String mainString="abcabcabc";
    System.out.println(canStringMadeFromSubString(mainString));
  }

  public static boolean canStringMadeFromSubString(String str){
    int prefixSuffixSameLen=PrefixSuffixSameLength.maxPrefixSuffixSameLen(str.toCharArray());
    System.out.println(prefixSuffixSameLen);
    return str.length()%(str.length()-prefixSuffixSameLen)==0;
  }
}