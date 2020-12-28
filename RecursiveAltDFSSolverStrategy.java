package mazeSolver;

//Create a different implementation that is just like MazeSolver, but tries the neighbors out in a different order (this should be easy).  Name it RecursiveAltDFSSolverStrategy

public class RecursiveAltDFSSolverStrategy implements MazeSolverStrategy {
	private Maze maze;

	public RecursiveAltDFSSolverStrategy(Maze maze) {this.maze = maze;}

	public boolean solve(int row, int column) {
		boolean done = false;
		if (maze.isValid(row, column)) {
			System.out.println("curr = " + row + ", " + column);			
			maze.setCell(row, column, 3); // cell has been tried
			maze.printMaze();
			if (row == maze.getNumRows() - 1 && column == maze.getNumCols() - 1)
				done = true; // maze is solved
			else {
				done = solve(row - 1, column); // up
				if (!done)
					done = solve(row, column - 1); // left
				if (!done)
					done = solve(row + 1, column); // down
				if (!done)
					done = solve(row, column + 1); // right
			}

			if (done) // part of the final path
				maze.setCell(row, column, 7);
		}
		else maze.showWhyInvalid(row, column);

		return done;

	}
}
