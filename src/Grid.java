import java.util.Arrays;

public class Grid {
    protected static int gridSize = 5;
    //protected static int[][] world = new int[gridSize][gridSize];

    public static int[][] initWorld(int size) {
        int[][] world = new int[size][size];
        for(int i=0; i<size; i++) {
            Arrays.fill(world[i], 0);
        }
        return world;
    }

    public static String arrayToString(int[] arr) {
        String str = "";
        for(int i=0; i<arr.length; i++) {
            if(arr[i]==1) {
                str += "O";
            }
            else {
                str += "-";
            }
        }
        return str;
    }

    public static void main(String args[]) {
        int[][] world = initWorld(gridSize);
        int[][] nextDayWorld = initWorld(gridSize);

        int daysOfLife = 3;

        //add live cells
        world[1][2] = 1;
        world[1][3] = 1;
        world[2][2] = 1;
        world[3][2] = 1;
        world[4][1] = 1;
        world[4][2] = 1;

        for(int i=0; i<gridSize; i++) {
            System.out.println(arrayToString(world[i]));
        }
        System.out.println("_____");

        for(int d=0; d<daysOfLife; d++) {

            for (int i = 0; i < gridSize; i++) {
                for (int j = 0; j < gridSize; j++) {
                    nextDayWorld[i][j] = Cell.cellTheNextDay(world, i, j);
                }
            }
            world = nextDayWorld;

            for(int i=0; i<gridSize; i++) {
                System.out.println(arrayToString(world[i]));
            }
            System.out.println("_____");

        }


    }


}
