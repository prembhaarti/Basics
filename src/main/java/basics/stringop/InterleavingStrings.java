package basics.stringop;

public class InterleavingStrings {

  public static void main(String[] args) {
    char[] m = "ab".toCharArray();
    char[] n = "cd".toCharArray();
    char[] str = new char[m.length + n.length];

    printInterleaving(m, n, str, m.length, n.length, 0);
  }

  private static void printInterleaving(char[] m, char[] n, char[] str, int mLength, int nLength, int i) {
    if (mLength == 0 && nLength == 0)
      System.out.println(str);

    if (mLength != 0) {
      str[i] = m[m.length-mLength];
      printInterleaving(m,n,str,mLength-1,nLength,i+1);
    }
    if (nLength!=0){
      str[i]=n[n.length-nLength];
      printInterleaving(m,n,str,mLength,nLength-1,i+1);
    }
  }
}