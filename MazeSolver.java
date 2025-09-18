class Cell {
    public enum CellType {
        /*
        * open-> good to go
        * wall-> you can't go
        * start-> starting point
        * finish-> exist point
        */
        OPEN, WALL, START, FINISH
    }

    private CellType type;
    private boolean visited = false;

    public Cell(CellType type) {
        this.type = type;
    }

    public CellType getType() {
        return type;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}

public class MazeSolver {
    private Cell[][] maze;

    public MazeSolver(Cell[][] maze) {
        this.maze = maze;
    }
    public boolean findPath(int row, int col) {
        if(row < 0 || col < 0 || row >= maze.length || col >= maze.length){
            return false;
        }
        Cell currentCell = maze[row][col];// the position of the current cell, which row & column in the grid
        if (currentCell.isVisited() || currentCell.getType() == Cell.CellType.WALL){
            return false;
        }

        if(currentCell.getType() == Cell.CellType.FINISH){
            return true;
        }

        currentCell.setVisited(true);//after visit the cell, set it as visited

        if (findPath(row - 1, col) || // go to up
                findPath(row + 1, col) || // go to down
                findPath(row, col - 1) || // go to left
                findPath(row, col + 1)) { // go to right
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Cell[][] mazeLayout = {
                {new Cell(Cell.CellType.START), new Cell(Cell.CellType.OPEN), new Cell(Cell.CellType.WALL)},
                {new Cell(Cell.CellType.WALL), new Cell(Cell.CellType.OPEN), new Cell(Cell.CellType.OPEN)},
                {new Cell(Cell.CellType.OPEN), new Cell(Cell.CellType.OPEN), new Cell(Cell.CellType.FINISH)}
        };

        // It's good practice to find the start coordinates programmatically,
        // but for this example, we'll assume it's at (0, 0).
        int startRow = 0;
        int startCol = 0;//(0, 0)

        MazeSolver solver = new MazeSolver(mazeLayout);
        if (solver.findPath(startRow, startCol)) {
            System.out.println("Path found!");
        } else {
            System.out.println("No path exists.");
        }
    }
}