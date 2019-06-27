package basics.array;

public class ReachDestination {


		static int reachTarget(int target)
		{
			// Handling negatives by symmetry
			target = Math.abs(target);

			// Keep moving while sum is smaller
			// or difference is odd.
			int sum = 0, step = 0;

			while (sum < target || (sum - target) % 2
					!= 0) {
				step++;
				sum += step;
//				System.out.println("Step: "+step);
//				System.out.println("Sum: "+sum);
			}
			return step;
		}

		// Driver code
		public static void main(String args[])
		{
//			int target = 15;
			for(int i = 10; i<1000 ; i++) {

				System.out.println(reachTarget(i));
			}
		}

}
