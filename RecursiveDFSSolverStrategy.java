package mazeSolver;

//Make MazeSolver implement the interface, and rename it RecursiveDFSSolverStrategy.
public class RecursiveDFSSolverStrategy implements MazeSolverStrategy{

	private Maze maze;

	public RecursiveDFSSolverStrategy(Maze maze) {this.maze = maze;}

	public boolean solve(int row, int column) {
		boolean done = false;
		if (maze.isValid(row, column)) {
			System.out.println("curr = " + row + ", " + column);			
			maze.setCell(row, column, 3); // cell has been tried
			maze.printMaze();
			if (row == maze.getNumRows() - 1 && column == maze.getNumCols() - 1)
				done = true; // maze is solved
			else {
				done = solve(row + 1, column); // down
				if (!done)
					done = solve(row, column + 1); // right
				if (!done)
					done = solve(row - 1, column); // up
				if (!done)
					done = solve(row, column - 1); // left
			}

			if (done) // part of the final path
				maze.setCell(row, column, 7);
		}
		else maze.showWhyInvalid(row, column);

		return done;

	}

}
