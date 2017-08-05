package stringop;

/*
Given a string S of brackets, the task is to find an index k which decides the number of
opening brackets is equal to the number of closing brackets.
String must be consists of only opening and closing brackets i.e. ‘(‘ and ‘)’.
An equal point is an index such that the number of opening brackets before it is equal to
the number of closing brackets from and after.
 */
public class EqualPoint {
  public static void main(String[] args) {
    String s = "(())))(";
    int index = findIndex(s);
    System.out.print(index);
    /*int len = s.length();
    char[] arr = s.toCharArray();
    int[] open = new int[s.length()];
    int[] close = new int[s.length()];
    for (int i = 0,count =0; i < s.length(); i++) {
      if (arr[i] == '(')
        count++;
      open[i] = count;
    }

    for (int i = s.length()-1,count =0; i >=0; i--) {
      if (arr[i] == ')')
        count++;
      close[i] = count;
    }

    if (open[s.length()-1] == 0)
      System.out.print(s.length());
    if (close[0] == 0)
      System.out.print(1);

    for (int i = 0; i < s.length(); i++) {
      if (open[i] == close[i]){
        System.out.println(i);
        break;
      }

    }*/

  }



  static int findIndex(String str)
  {
    int len = str.length();
    int open[] = new int[len+1];
    int close[] = new int[len+1];
    int index = -1;

    open[0] = 0;
    close[len] = 0;
    if (str.charAt(0)=='(')
      open[1] = 1;
    if (str.charAt(len-1) == ')')
      close[len-1] = 1;

    // Store the number of opening brackets
    // at each index
    for (int i = 1; i < len; i++)
    {
      if ( str.charAt(i) == '(' )
        open[i+1] = open[i] + 1;
      else
        open[i+1] = open[i];
    }

    // Store the number of closing brackets
    // at each index
    for (int i = len-2; i >= 0; i--)
    {
      if ( str.charAt(i) == ')' )
        close[i] = close[i+1] + 1;
      else
        close[i] = close[i+1];
    }

    // check if there is no opening or closing
    // brackets
    if (open[len] == 0)
      return len;
    if (close[0] == 0)
      return 0;

    // check if there is any index at which
    // both brackets are equal
    for (int i=0; i<=len; i++)
      if (open[i] == close[i])
        index = i;

    return index;
  }
}
