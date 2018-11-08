package basics.stringop;

import java.util.Scanner;

public class KStreamNonRepeating {
  public static void main(String[] args) {
    int[] stream = new int[256];
    int[] nonRepeating = new int[256];
    int i = 0;
    Scanner sc = new Scanner(System.in);
    while (true) {
      char s = sc.next().charAt(0);
      int index = getIndex(nonRepeating, s);
      stream[s] = stream[s] + 1;
      if (stream[s] == 1) {
        if (i - 1 >= 0 && nonRepeating[i - 1] == 0)
          i--;
        nonRepeating[i] = s;
        i++;
      } else if (stream[s] > 1 && index != -1 && nonRepeating[index] == s) {
        nonRepeating[index] = 0;
        for (int j = index; j < 255 && nonRepeating[j] != 0; j++) {
          nonRepeating[j] = nonRepeating[j + 1];
        }
      }
      char c = (char) nonRepeating[0];

      if (nonRepeating[0] == 0)
        System.out.println(-1);
      else
        System.out.println(c);
    }
  }

  private static int getIndex(int[] nonRepeating, char s) {
    for (int i = 0; i < nonRepeating.length; i++) {
      if (nonRepeating[i] == s)
        return i;
    }
    return -1;
  }
}
