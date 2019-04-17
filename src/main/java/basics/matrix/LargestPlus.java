package basics.matrix;

public class LargestPlus {

	static int[][] grid = {
			{0,0,0,1,0,0,0},
			{0,0,0,1,1,0,0},
			{0,0,0,1,1,1,0},
			{1,1,1,1,1,1,1},
			{0,0,0,1,1,1,0},
			{0,0,0,1,1,0,0},
			{0,0,0,1,0,0,0}
	};

	static class PlusCount{
		public int up;
		public int down;
		public int left;
		public int right;
	}



	public static void main(String[] args) {
		PlusCount[][] count = new PlusCount[grid.length][grid.length];
		int maxCount = Integer.MIN_VALUE;
		for(int j=0; j< grid.length; j++){
			for( int i=0; i<grid[0].length; i++){
				PlusCount plusCount = new PlusCount();
				count[j][i]=plusCount;
				if(isValid(i,j, grid[i][j])){
					maxCount=1;
					if(i >0 && j>0){
						plusCount.left= count[j][i-1].left==0 ? 1 : count[j][i-1].left+1;
						plusCount.up= count[j-1][i].up==0 ? 1 : count[j-1][i].up+1;
					}
				}
			}
		}

		for(int j=grid.length-1; j>=0; j--){
			for( int i=grid[0].length-1; i>=0;i--){
				if(isValid(i,j, grid[i][j])){
					PlusCount plusCount = count[j][i];
					if(i <grid[0].length-1 && j<grid.length -1){
						plusCount.right= count[j][i+1].right==0 ? 1 : count[j][i+1].right + 1;
						plusCount.down= count[j+1][i].down==0 ? 1 : count[j+1][i].down + 1;
						int minVertical = Math.min(plusCount.up,plusCount.down);
						int minHorizontal = Math.min(plusCount.left,plusCount.right);
						maxCount = Math.max(Math.min(minHorizontal,minVertical), maxCount);
					}
				}
			}
		}

		if(maxCount<2) {
			System.out.println(maxCount);
		}
		else {
			System.out.println(maxCount* 2 + 1);
		}
	}

	public static boolean isValid(int j, int i, int value){
		if(j>grid.length || j<0 || i>grid[0].length || i<0 || value==0){
			return false;
		}
		return true;
	}



}
