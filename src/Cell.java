import java.util.ArrayList;
import java.util.List;

public class Cell {

    public static boolean deadCell() {
        return false;
    }

    public static boolean liveCell() {
        return true;
    }

    public static List<Integer> getCellNeighboursArray(int[][] grid, int i, int y) {
        List<Integer> neighbours = new ArrayList<Integer>();
        int lastIndex = grid.length-1;
        for(int a = i-1; a<=i+1; a++) {
            for(int b = y-1; b<=y+1; b++) {
                if(a<0||b<0||a>lastIndex||b>lastIndex||(a==i&&b==y)) {
                    continue;
                }
                neighbours.add(grid[a][b]);
            }
        }
        return neighbours;
    }

    public static int getCountOfLiveNeighbours(List<Integer> list) {
        int count = 0;
        for(int i=0; i<list.size(); i++) {
            if(list.get(i) ==1) {
                count++;
            }
        }
        return count;
    }

    public static int cellTheNextDay(int[][] grid, int x, int y) {
        int liveNeighbours = getCountOfLiveNeighbours(getCellNeighboursArray(grid, x, y));
        if(grid[x][y]==1) {
            if (liveNeighbours < 2 || liveNeighbours > 3) {
                return 0;
            }
            else if(liveNeighbours==2 || liveNeighbours==3) {
                return 1;
            }
        }
        else {
            if (liveNeighbours == 3) {
                return 1;
            }
        }
        return 0;
    }
}
