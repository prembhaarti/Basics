package basics.backtraking;

public class OpenKnightTour {
	private static int[][] chessBoard= new int[8][8];
	private static int[] knightX= {-1,1-2,-2,-1,1,2,2};
	private static int[] knightY= {2,2,-1,1,-2,-2,-1,1};
	private static boolean[][] visited= new boolean[8][8];


	//take where knights can move
	//check safe place to land
	//iterate through all board, start from first try dfs
	//once visted mark it
	//if visited break
	//on each sending send visited+1
	//break if visited == 64

	public static void main(String[] args) {
		for(int row=0;row<chessBoard.length; row++){
			for(int column=0; column<chessBoard[0].length; column++){
				visited[row][column] = true;
				System.out.println(row+":"+column);
				dfs(1, row, column);
				visited[row][column] = false;
			}
		}
	}

	private static boolean dfs(int count, int row, int column){
		if(count==64) {
			display();
			return true;
		}
		for(int i=0;i<knightX.length;i++){
			int newRow= row+knightY[i];
			int newCol= column+knightX[i];
			if(isSafe(newRow, newCol)){
				chessBoard[newRow][newCol]=count+1;
				visited[newRow][newCol] = true;
				if(!dfs(count+1, newRow, newCol)){
					visited[newRow][newCol] = false;
					chessBoard[newRow][newCol]=count;
				}
			}
		}
		return false;
	}


	private static boolean isSafe(int row, int column){
		return !(row<0 || column<0 || row>chessBoard.length-1 || column>chessBoard[0].length-1 || visited[row][column]);
	}

	private static void display(){
		for(int row=0;row<chessBoard.length-1; row++){
			for(int column=0; column<chessBoard[0].length-1; column++){
				System.out.println(chessBoard[row][column]);
			}
		}
	}



}
