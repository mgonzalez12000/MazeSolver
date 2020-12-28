package mazeSolver;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSSolverStrategy implements MazeSolverStrategy {

	//Create static class first for row, column, and parent
	private static class Node {
		//private data fields
		private int row;
		private int column;
		@SuppressWarnings("unused")
		private Node node;

		//Constructor
		public Node(int row, int column) {
			this.row = row;
			this.column = column;
		}

		public int getRow() {
			return row;
		}

		public int getColumn() {
			return column;
		}

		public void setParent(Node node) {
			this.node = node;
		}

		@SuppressWarnings("unused")
		public Node (Node node) {
			this.row = node.getRow();
			this.column = node.getColumn();
		}

	}

	//Begin algorithm
	private Maze maze;

	public BFSSolverStrategy(Maze maze) {this.maze = maze;}

	@Override
	public boolean solve(int row, int column) {
		boolean done = false;
		//Create a Queue for unvisited nodes
		Queue<Node> unVisited = new LinkedList<Node>();
		//Create a List for visited nodes
		List<Node> visited = new LinkedList<Node>();

		//Put the starting node at the back of the Queue
		Node nodes = new Node(row, column);
		unVisited.add(nodes);

		/* While the Queue is not empty:
		 * Take the front of the item and add it to the visited node
		 * Create a list of that nodes neighbors nodes. Add those which have not already been visited to the back of the queue.
		 */

		while (!unVisited.isEmpty()) {
			Node existingNodes = unVisited.remove();
			visited.add(existingNodes);
			maze.setCell(row, column, 3);
			maze.printMaze();

			//Implement like the other two type of solutions as discussed 
			if (existingNodes.getRow() == maze.getNumRows() - 1 && existingNodes.getColumn() == maze.getNumCols() - 1) {
				done = true;
			}
			else {
				if (maze.isValid(existingNodes.getRow() + 1, existingNodes.getColumn())) {
					Node node = new Node(existingNodes.getRow() + 1, existingNodes.getColumn());
					maze.setCell(node.getRow(), node.getColumn(), 3);
					node.setParent(existingNodes);
					unVisited.add(node);
					done = true;
				}
				if (maze.isValid(existingNodes.getRow(), existingNodes.getColumn() + 1)) {
					Node node = new Node(existingNodes.getRow(), existingNodes.getColumn() + 1);
					maze.setCell(node.getRow(), node.getColumn(), 3);
					node.setParent(existingNodes);
					unVisited.add(node);
					done =true;
				}
				if (maze.isValid(existingNodes.getRow() - 1, existingNodes.getColumn())) {
					Node node = new Node(existingNodes.getRow() - 1, existingNodes.getColumn());
					maze.setCell(node.getRow(), node.getColumn(), 3);
					node.setParent(existingNodes);
					unVisited.add(node);
					done = true;
				}
				if (maze.isValid(existingNodes.getRow(), existingNodes.getColumn() - 1)) {
					Node node = new Node(existingNodes.getRow(), existingNodes.getColumn() - 1);
					maze.setCell(node.getRow(), node.getColumn(), 3);
					node.setParent(existingNodes);
					unVisited.add(node);
					done = true;
				}
			}
			if (done) {
				maze.setCell(row, column, 7);
			}
			else {
				maze.showWhyInvalid(row, column);
			}
		}
		return done;
	}
}
