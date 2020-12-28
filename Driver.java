package mazeSolver;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {

		System.out.println("Please choose and input a type of solution:");
		System.out.println("1) RecursiveDFSSolverStrategy; 2) RecursiveAltDFSSolverStrategy; 3) BFSSolverStrategy; 0) Exit");

		//Create scanner object
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int userInput = sc.nextInt();

		//Instantiate Maze
		Maze maze = new Maze();
		MazeSolverStrategy solution1 = new RecursiveDFSSolverStrategy(maze);
		MazeSolverStrategy solution2 = new RecursiveAltDFSSolverStrategy(maze);
		MazeSolverStrategy solution3 = new BFSSolverStrategy(maze);

		//User input actions
		if(userInput == 1) {
			if(solution1.solve(0, 0)) {
				System.out.println("Maze has been solved");
			}
			else {
				System.out.println("No solution was found");
			}
			maze.printMaze();
		}

		else if(userInput == 2) {
			if(solution2.solve(0, 0)) {
				System.out.println("Maze has been solved");
			}
			else {
				System.out.println("No solution was found");
			}
			maze.printMaze();
		}

		else if(userInput ==3) {
			if(solution3.solve(0, 0)) {
				System.out.println("Maze has been solved");
			}
			else {
				System.out.println("No solution was found");
			}
			maze.printMaze();
		}
		
		else if (userInput ==0) {
			System.exit(0);
		}
	}
}
