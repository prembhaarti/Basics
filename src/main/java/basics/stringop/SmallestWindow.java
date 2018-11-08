package basics.stringop;

/*
Smallest window in a string containing all the characters of another string
 */
public class SmallestWindow {
  public static void main(String[] args) {
    char[] s = "timetopractice".toCharArray();
    char[] pat = "toc".toCharArray();
    if (pat.length > s.length)
      System.out.println(-1);

    int[] hash_str = new int[256];
    int[] hash_pat = new int[256];
    int count = 0;
    int start = 0;
    int i = 0;
    int start_index = -1;
    int win_size = Integer.MAX_VALUE;

    for (char c : pat) {
      hash_pat[c]++;
    }

    for (char c : s) {
      hash_str[c]++;
      i++;
      if (hash_pat[c] != 0 && hash_str[c] <= hash_pat[c]) {
        count++;

        if (count == pat.length) {
          while (hash_pat[s[start]] == 0 ||
              hash_str[s[start]] > hash_pat[s[start]]) {
            if (hash_str[s[start]] > hash_pat[s[start]])
              hash_str[s[start]]--;
            start++;
          }  
          int len = i-start;
          if (len<win_size){
            win_size = len;
            start_index = start;
          }

        }
      }
    }

    if (start_index == -1){
      System.out.println("no window exists");
    }else {
      System.out.println(win_size);
      System.out.println(start_index);
    }
  }

}
