package graph;

import java.util.HashSet;
import java.util.Set;

/**
 * given a starting position and destination position of a knight in the chessboard.
 * ie. start {1,1} and destination {4,5}
 *
 * Minimum distance required to reach from source to destination.
 *
 * get 8 possible positions from one position a knight can go
 * up-left,up-right,down-left,down-right,left-up,left-down,right-up,right-down
 *
 * create a minDist =>MAX
 * do dfs and keep checking if it's minDist on reaching destination.
 */
public class KnightMove {
    int[] row = {2, 2, -2, -2, 1, -1, 1, -1};
    int[] col = {1, -1, 1, -1, -2, -2, 2, 2};

    int[][] chessBoard= new int[8][8];
    int minDis=Integer.MAX_VALUE;

    public void shortestPath(Position source,Position destination,Set<Position> visited,int steps){
        for(int k=0;k<row.length;k++) {
            Position newPos= new Position(source.row+row[k],source.col+col[k]);
            if(!isInsideAndNotVisited(newPos,visited)){
                continue;
            }
            if(newPos.equals(destination)){
                minDis=Math.min(steps+1,minDis);
                return;
            }
            else{
                visited.add(source);
                shortestPath(newPos,destination,visited,steps+1);
            }
        }
    }

    public boolean isInsideAndNotVisited(Position source, Set<Position> visited) {
        return source.row<chessBoard.length && source.row>=0 &&
           source.col<chessBoard[0].length && source.col>=0 &&
                !isVisited(source,visited);
    }

    private boolean isVisited(Position source, Set<Position> visited) {
        return visited.contains(source);
    }

    public static void main(String[] args) {
        KnightMove km = new KnightMove();
        km.shortestPath(new Position(1,1),new Position(4,5),new HashSet<Position>(),0);
        System.out.println(km.minDis);
    }
}
class Position{
        public int row;
        public int col;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (row != position.row) return false;
        return col == position.col;
    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + col;
        return result;
    }

    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
}