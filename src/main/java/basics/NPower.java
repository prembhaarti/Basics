package basics;

public class NPower {

	/**
	 * input : element, and power
	 * return calculated power
	 * @param args
	 */
	public static void main(String[] args) {
		for(int i=0;i<37;i++)
		System.out.println("Power :"+i+":"+NPower.getPower(2, i));
	}
	
	public static int getPower(int base,int power){
		if(power ==0) return 1;
		else if(power==1) return base;
		else{
			if(power%2==0){
				int temp= getPower(base,power/2);
				return temp*temp;
			}
			else{
				int temp=getPower(base,power/2);
				return base*temp*temp;
			}
		}
	}
}
