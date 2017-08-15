package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
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

    Queue<Position> queue = new LinkedList<>();
    public void shortestPath(Position source, Position destination){
        queue.add(source);
        Set<Position> visited = new HashSet<>();

        while (!queue.isEmpty()){
            Position position=queue.remove();
            if(position.equals(destination)){
                System.out.println(position.step);
                break;
            }
            visited.add(position);
            for(int i=0;i<row.length;i++) {
                Position newPos=new Position(position.row+row[i],position.col+col[i],position.step+1);
                if(isInsideAndNotVisited(newPos,visited)){
                    queue.add(newPos);
                }
            }
        }
    }

    public boolean isInsideAndNotVisited(Position source, Set<Position> visited) {
        return source.row<chessBoard.length && source.row>=0 &&
           source.col<chessBoard[0].length && source.col>=0
                && !isVisited(source,visited);
    }

    private boolean isVisited(Position source, Set<Position> visited) {
        return visited.contains(source);
    }

    public static void main(String[] args) {
        KnightMove km = new KnightMove();
        km.shortestPath(new Position(0,0,0),new Position(7,7,0));
    }
}
class Position{
        public int row;
        public int col;
        public int step;
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

    public Position(int row, int col,int step) {
        this.row = row;
        this.col = col;
        this.step=step;
    }
}