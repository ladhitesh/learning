package org.learning.freelancer.P9998354;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Stack;

public class MazeSolver {
	
	private static Stack<Node> solution = new Stack<Node>();
	private static Node[][] maze;
	
	private static Node[][] getMaze() throws Exception{
		//read input
		File input = new File("input.txt");
		FileReader inputReader = new FileReader(input);
		BufferedReader inputBufferedReader = new BufferedReader(inputReader);
		String line = null;
		line = inputBufferedReader.readLine();
		String[] rowsCols = line.split(" ");
		
		//initialize maze with rows and columns
		maze = new Node[Integer.parseInt(rowsCols[0])][Integer.parseInt(rowsCols[1])];
		
		String[] cols;
		
		//read maze data
		for (int i = 0; i < maze.length; i++) {
			line = inputBufferedReader.readLine();
			cols = line.split(" ");
			for (int j = 0; j < cols.length; j++) {
				maze[i][j] = (cols[j].equalsIgnoreCase("X")?new Node(i,j,true):new Node(i,j,false));
			}
		
		}
		
		//close readers
		inputBufferedReader.close();
		inputReader.close();
		return maze;
	}
	
	
	public static void main(String[] args) throws Exception {
		System.out.println("Solving maze");
		
		Node[][] maze = getMaze();
		solveMaze(maze);
		String fileoutput = "";
		if(!solution.isEmpty()) {
			fileoutput = "Solution:"+solution;
			System.out.println(fileoutput);
		}
		else
		{
			fileoutput = "Solution: No Solution possible";
			System.out.println(fileoutput);
		}
		
		File output = new File("output.txt");
		FileWriter outputwriter = new FileWriter(output);
		outputwriter.write(fileoutput);
		outputwriter.close();
		System.out.println("Maze solved");
	}
	
	public static void solveMaze(Node[][] maze){
		
		Node start = maze [maze.length - 1 ][maze[0].length - 1];
		
		int currentX = start.getX();
		int currentY = start.getY();
		
		while(true){
			
			//visitNode 
			if(!(maze[currentX][currentY]).isVisited()){
				solution.push(maze[currentX][currentY]);
				(maze[currentX][currentY]).setVisited(true);
			}
			
			//isMazedSolved
			if(currentX ==0 && currentY == 0){
					break;
			}
			
			//move left
			if(canMove(currentX,currentY-1)){
				currentY = currentY-1;
				continue;
			}
			
			//move top
			if(canMove(currentX-1,currentY)){
				currentX = currentX-1;
				continue;
			}
			
			//move down
			if(canMove(currentX+1,currentY)){
				currentX = currentX+1;
				continue;
			}
			
			//move right
			if(canMove(currentX,currentY+1)){
				currentY = currentY+1;
				continue;
			}
			
			//backtrack
			Node currentNode = backtrack();
			if(currentNode == null){
				solution.clear();
				break;
			}
			currentX = currentNode.getX();
			currentY = currentNode.getY();
			

		}
		
	}
	
	
	private static boolean canMove(int x, int y){
		//edge condition
		if(x<0 || x >= maze.length) return false;
		if(y<0 || y >= maze.length) return false;
		//already visited
		if(maze[x][y].isVisited()) return false;
		//wall
		if(maze[x][y].isWall()) return false;
		
		return true;
	}
	
	private static Node backtrack(){
		if (solution.isEmpty()) return null;
		//discard current position. we need to back track
		solution.pop();
		if (solution.isEmpty()) return null;
		//get previous position details from stack
		Node currentNode = solution.peek();
		return currentNode;
	}

	
	
	public static class Node {
		private boolean isWall = false;
		private int x,y;
		private boolean visited = false;
		
		Node(int x, int y, boolean wall){
			this.isWall = wall;
			this.x = x;
			this.y = y;		
			
		}
		
		public boolean isWall(){
			return isWall;
		}
		
		public int getX(){
			return x;
		}
		
		public int getY(){
			return y;
		}
		
		public void setVisited(boolean visited){
			this.visited = visited;
		}
		
		public boolean isVisited(){
			return this.visited;
		}
		
		@Override
		public String toString() {
			return "{" + getX() + "," + getY() + "}";
		}
		
	}

}
