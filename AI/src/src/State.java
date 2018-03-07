package src;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;


public class State {

    public static final Map<Integer, List<Integer>> boundaries = new HashMap<>();
    private int pegCount = 0;

    static {
        boundaries.put(0, Arrays.asList(2, 3));
        boundaries.put(1, Arrays.asList(1, 5));
        boundaries.put(2, Arrays.asList(0, 7));
        boundaries.put(3, Arrays.asList(0, 7));
        boundaries.put(4, Arrays.asList(0, 7));
        boundaries.put(5, Arrays.asList(1, 5));
        boundaries.put(6, Arrays.asList(2, 3));

    };

    private Peg[][] grid;


    public State() {
        this.pegCount = pegCount;
    }

    public int getPegCount() {
        return pegCount;
    }

    public void setPegCount(int pegCount) {
        this.pegCount = pegCount;
    }

    public State(Map<String, Peg> gridPegs) {
        grid = new Peg[7][7];

        if (gridPegs != null) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid.length; j++) {
                    String key = "" + i + j;
                    if (isGridWithinBound(i, j)) {
                        grid[i][j] = gridPegs.get(key);
                        if(grid[i][j] != null){
                            pegCount++;
                        }
                    }
                }
            }
        }
    }


    public State(Peg[][] gridP) {
        grid = new Peg[7][7];

        if (gridP != null) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid.length; j++) {
                    String key = "" + i + j;
                    if (isGridWithinBound(i, j)) {
                        grid[i][j] = gridP[i][j];
                        if(grid[i][j] != null){
                            pegCount++;
                        }
                    }
                }
            }
        }
    }

    public Peg[][] getGrid() {
        return grid;
    }

    public void setGrid(Peg[][] grid) {
        this.grid = grid;
    }

    public Peg[][] getCloneGrid () {
        Peg[][] newGrid = new Peg[7][7];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (isGridWithinBound(i, j) && grid[i][j] != null) {
                    newGrid[i][j] = new Peg(i,j);
                }
            }
        }

        return newGrid;
    }


    public boolean isGridWithinBound(int i, int j) {

        if (((i == 0 || i == 1 || i == 5 || i == 6) && (j == 0 || j == 6)) || ((i == 0 || i == 6) && (j == 1 || j == 5))) {
            return false;

        } else {
            return true;
        }
    }

    public boolean isInitialPositionEmpty(int i, int j) {
        if (i == 2 && j == 3) {
            return false;
        } else {
            return true;
        }
    }

    private void printPegs(Peg peg) {
            if (peg == null) {
                System.out.print("0");
            }else{
                System.out.print("1");
        }
    }

    private void printLine(int index) {
        int num = index;
        int numberOfSpaces = 0;
        if (num == 0) {
            num = 6;
            numberOfSpaces = 4;
        } else if (num == 1) {
            num = 10;
            numberOfSpaces = 2;
        } else if (num == 5) {
            num = 14;
            numberOfSpaces = 2;
        } else if (num == 6) {
            num = 10;
            numberOfSpaces = 2;
        } else
            num = 14;

        if (index != 5)
            printSpaces(numberOfSpaces);

        printDashes(num);

        if (index == 6) {
            numberOfSpaces = 4;
            num = 6;
        }
        printSpaces(numberOfSpaces);
    }

    private void printDashes(int num) {
        for (int i = 0; i < num; i++)
            System.out.print("-");
        System.out.println();
    }

    public void printSpaces(int numberOfSpaces) {
        if (numberOfSpaces != 0)
            System.out.print(String.format("%" + numberOfSpaces + "s", ""));
    }
    public void print() {
        int count;
        for (int i = 0; i < grid.length; i++) {
            count = 0;
            for (int j = 0; j < grid.length; j++) {
                if (isGridWithinBound(i, j)) {
                    if (count == 0) {
                        printLine(i);
                        count++;
                    }

                    System.out.print("|");
                    printPegs(grid[i][j]);
                    if (((i == 0 || i == 7) && j == 5) || ((i == 1 || i == 6) && j == 6) || j == 7)
                        System.out.print("|");

                } else if (i == 6 && j == 6) {
                    System.out.println();
                    printSpaces(4);
                    printDashes(6);
                }

            }
            System.out.print("\n");
        }
    }
    public String toString() {
        String s = "";
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid.length; j++) {
                    if (isGridWithinBound(i, j) && grid[i][j] != null) {
                        s += "1";
                    } else if (isGridWithinBound(i, j) && grid[i][j] == null){
                        s += "0";
                    } else{

                    }
                }
            }
        return s.trim();
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        else if (obj == null || obj.getClass() != this.getClass())
            return false;

        State state = (State) obj;

        return (this.pegCount == state.pegCount) && (Arrays.deepEquals(grid, state.grid));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + pegCount;
        result = prime * result + Arrays.deepHashCode(grid);

        return result;
    }


    public static void main(String[] args) {

    }
}