package basics.stringop;


public class DivisorString {
    public String gcdOfString(String str1, String str2){
        if(!(str1+str2).equals(str2+str1)){
            return "";
        }
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private int gcd(int a, int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }

    public static void main(String[] args) {
        DivisorString ds = new DivisorString();
        System.out.println(ds.gcdOfString("ABCABC", "ABC"));
        System.out.println(ds.gcdOfString("ABABAB", "ABAB"));
        System.out.println(ds.gcdOfString("LEET", "CODE"));

    }
}
