import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class testGOF {

    @Test
    public void deadCellIsDead() {
        assertFalse(Cell.deadCell());
    }

    @Test
    public void liveCellIsLive() {
        assertTrue(Cell.liveCell());
    }

    @Test
    public void isInitializedWorlHasOnlyLiveOrDeadCells() {
        int count = 0;
        int tempWorldSize = 5;
        int[][] tempWorld = Grid.initWorld(tempWorldSize);

        for(int x = 0; x < tempWorldSize; x++) {
            for(int y = 0; y < tempWorldSize; y++) {
                if(tempWorld[x][y]==1||tempWorld[x][y]==0) {
                    count++;
                }
            }
        }

        assertEquals(count, Grid.gridSize*Grid.gridSize);
    }

    @Test
    public void countOfNeighboursForFirstCell() {
        int[][] temp = {{0,1,1},{0,0,0},{0,0,1}};
        int count = Cell.getCellNeighboursArray(temp,0, 0).size();
        assertEquals(count, 3);
    }

    @Test
    public void countOfNeighboursForLastCell() {
        int[][] temp = {{0,1,1},{0,0,0},{0,0,1}};
        int count = Cell.getCellNeighboursArray(temp,temp.length-1, temp.length-1).size();
        assertEquals(count, 3);
    }

    @Test
    public void countOfNeighboursForCellOfTopLineNotInCorner() {
        int[][] temp = {{0,1,1},{0,0,0},{0,0,1}};
        int count = Cell.getCellNeighboursArray(temp,0, 1).size();
        assertEquals(count, 5);
    }

    @Test
    public void countOfNeighboursForCellInTheMiddle() {
        int[][] temp = {{0,1,1},{0,0,0},{0,0,1}};
        int count = Cell.getCellNeighboursArray(temp,1, 1).size();
        assertEquals(count, 8);
    }

    @Test
    public void countOfLiveNeighbours() {
        int[][] temp = {{0,1,1},{0,0,0},{0,0,1}};
        int tempCount = Cell.getCountOfLiveNeighbours(Cell.getCellNeighboursArray(temp, 1, 1));

        assertEquals(tempCount, 3);
    }

    @Test
    public void liveCellWithFewerThanTwoLiveNeighbousrDies() {
        int[][] temp = {{1,1,1},{0,0,0},{0,0,1}};
        int cellInstance = 1;

        cellInstance = Cell.cellTheNextDay(temp,0,0);

        assertEquals(cellInstance, 0);
    }

    @Test
    public void liveCellWithMoreThanThreeLiveNeighbousrDies() {
        int[][] temp = {{0,1,1},{0,1,1},{0,0,1}};
        int cellInstance = 1;

        cellInstance = Cell.cellTheNextDay(temp,1,1);

        assertEquals(cellInstance, 0);
    }
    @Test
    public void liveCellWithTwoOrThreeLiveNeighbousrLives() {
        int[][] temp = {{1,1,1},{1,0,1},{0,0,1}};
        int cellInstance = 1;

        cellInstance = Cell.cellTheNextDay(temp,1,0);

        assertEquals(cellInstance, 1);
    }

    @Test
    public void deadCellWithThreeLiveNeighbousrLives() {
        int[][] temp = {{0,0,0},{0,1,1},{0,0,1}};
        int cellInstance = 1;

        cellInstance = Cell.cellTheNextDay(temp,2,1);

        assertEquals(cellInstance, 1);
    }

    @Test
    public void deadCellWithAllDeadNeighbousrDead() {
        int[][] temp = {{0,0,0},{0,0,0},{0,0,0}};
        int cellInstance = 1;

        cellInstance = Cell.cellTheNextDay(temp,1,1);

        assertEquals(cellInstance, 0);
    }
}
