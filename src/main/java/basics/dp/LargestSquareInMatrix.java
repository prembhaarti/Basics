package basics.dp;

import basics.util.CodeUtil;

public class LargestSquareInMatrix {

	static int[][] matrix= {
			{1,1,0,1},
			{1,1,1,1},
			{1,1,1,1},
			{1,1,1,1}
	};

	public static void main(String[] args) {
		System.out.println(maxSquareLength(matrix));
	}

	/**
	 * @param matrix
	 * @return
	 * 1 | 1 | 0 | 1 |
	 * 1 | 2 | 1 | 1 |
	 * 0 | 1 | 2 | 2 |
	 * 1 | 1 | 2 | 3 |
	 */
	public static int maxSquareLength(int[][] matrix){
		int maxLength=0;
		int[] checkRow= {0, -1, -1};
		int[] checkCol= {-1, -1, 0};

		if(matrix!=null){
			for(int j=0;j< matrix.length; j++){
				for(int i=0; i<matrix[0].length; i++){
					if(matrix[j][i]==1){
						boolean isValid=true;
						int min =Integer.MAX_VALUE;
						for(int k=0; k<checkRow.length; k++){
							isValid = isValid && isValid(j+checkRow[k], i+checkCol[k], matrix);
							if(isValid){
								min = Math.min(matrix[j+checkRow[k]][i+checkCol[k]], min);
							}
						}
						if(isValid){
							matrix[j][i]=min+1;
						}
						maxLength = Math.max(maxLength, matrix[j][i]);
					}
				}
			}
		}
		CodeUtil.display2dMatrix(matrix);
		return maxLength;
	}

	private static boolean isValid(int row, int col, int[][] matrix){
		return row>=0 &&
				col>=0 &&
				row<matrix.length &&
				col<matrix[0].length &&
				matrix[row][col]>0;
	}
}
