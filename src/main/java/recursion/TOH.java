package recursion;

public class TOH {

	public static void main(String[] args) {
		solve(3, "A", "B", "C");
	}

	/**
	 * if there's only one circle
	 * then A -> C
	 *
	 * Think of two plates stacked in A tower
	 * Step 1: A -> B (smaller from to middle)
	 *              A -> C (larger from to last)
	 *         B -> C (finally smaller to last)
	 *
	 */
	public static void solve(int n, String from, String middle, String to){
		if(n==1){
			System.out.println("Move "+from + " to "+to);
			return;
		}
		solve(n-1, from, to, middle);
		System.out.println("Move "+from+ " to "+ to);

		solve(n-1, middle, from, to);
	}
}
