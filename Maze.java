package mazeSolver;

class Maze {


	// 0 = wall, 1 = unexplored space, 3 = explored space.  At end 3 = explored but not on final path, 7 = on final path
	int[][] grid = { 
			{ 1, 1, 1, 0, 1, 1, 1 }, 
			{ 1, 0, 1, 1, 1, 0, 1 }, 
			{ 1, 1, 1, 0, 1, 0, 1 }, 
			{ 0, 0, 0, 1, 0, 1, 1 },
			{ 0, 0, 1, 1, 1, 1, 0 },
			{ 0, 0, 1, 0, 0, 1, 0 },
			{ 0, 0, 1, 1, 1, 1, 1 }
	};

	public void printMaze() {
		for (int row = 0; row < grid.length; row++) {
			for (int column = 0; column < grid[row].length; column++)
				System.out.print(grid[row][column]);
			System.out.println();
		}
		System.out.println();
	}



	public void showWhyInvalid(int row, int column) {
		if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length) 
			System.out.println(row + ", " + column + " is off the grid\n");
		else {
			System.out.print("square at " + row + ", " + column + " is ");

			if (grid[row][column] == 0)
				System.out.print("a wall\n\n");
			if (grid[row][column] == 3)
				System.out.print("already explored\n\n");
		}		
	}


	public boolean isValid(int row, int column) {

		boolean result = false;

		// check if cell is in the bounds of the matrix
		if (row >= 0 && row < grid.length && column >= 0 && column < grid[0].length)

			// check if cell is not blocked and not previously tried
			if (grid[row][column] == 1)
				result = true;

		return result;

	}

	public void setCell(int row, int col, int value) {
		grid[row][col] = value;		
	}

	public int getNumRows() {return grid.length;}
	public int getNumCols() {return grid[0].length;}


}
