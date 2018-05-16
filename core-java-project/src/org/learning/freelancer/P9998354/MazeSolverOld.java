package org.learning.freelancer.P9998354;

import java.util.Stack;

public class MazeSolverOld {
	
	private static Stack<Node> solution = new Stack<Node>();
	
	private static Node[][] getTestMaze(){
		Node[][] maze = new Node[7][7];
		
		maze [0][0] = new Node(0,0,false);
		maze [0][1] = new Node(0,1,false);
		maze [0][2] = new Node(0,2,false);
		maze [0][3] = new Node(0,3,false);
		maze [0][4] = new Node(0,4,false);
		maze [0][5] = new Node(0,5,true);
		maze [0][6] = new Node(0,6,false);
		
		maze [1][0] = new Node(1,0,true);
		maze [1][1] = new Node(1,1,true);
		maze [1][2] = new Node(1,2,true);
		maze [1][3] = new Node(1,3,false);
		maze [1][4] = new Node(1,4,false);
		maze [1][5] = new Node(1,5,false);
		maze [1][6] = new Node(1,6,true);
		
		maze [2][0] = new Node(2,0,true);
		maze [2][1] = new Node(2,1,false);
		maze [2][2] = new Node(2,2,true);
		maze [2][3] = new Node(2,3,false);
		maze [2][4] = new Node(2,4,true);
		maze [2][5] = new Node(2,5,true);
		maze [2][6] = new Node(2,6,true);
		
		maze [3][0] = new Node(3,0,true);
		maze [3][1] = new Node(3,1,false);
		maze [3][2] = new Node(3,2,true);
		maze [3][3] = new Node(3,3,false);
		maze [3][4] = new Node(3,4,false);
		maze [3][5] = new Node(3,5,true);
		maze [3][6] = new Node(3,6,false);
		
		maze [4][0] = new Node(4,0,true);
		maze [4][1] = new Node(4,1,false);
		maze [4][2] = new Node(4,2,true);
		maze [4][3] = new Node(4,3,true);
		maze [4][4] = new Node(4,4,false);
		maze [4][5] = new Node(4,5,false);
		maze [4][6] = new Node(4,6,true);
		
		maze [5][0] = new Node(5,0,false);
		maze [5][1] = new Node(5,1,false);
		maze [5][2] = new Node(5,2,false);
		maze [5][3] = new Node(5,3,false);
		maze [5][4] = new Node(5,4,false);
		maze [5][5] = new Node(5,5,false);
		maze [5][6] = new Node(5,6,false);
		
		maze [6][0] = new Node(6,0,true);
		maze [6][1] = new Node(6,1,true);
		maze [6][2] = new Node(6,2,false);
		maze [6][3] = new Node(6,3,true);
		maze [6][4] = new Node(6,4,true);
		maze [6][5] = new Node(6,5,true);
		maze [6][6] = new Node(6,6,false);
		
		return maze;
	}
	
	public static void main(String[] args) {
		System.out.println("Solving maze");
		
		Node[][] maze = getTestMaze();
		solveMaze(maze);
		if(!solution.isEmpty())
			System.out.println("Solution:"+solution);
		else
			System.out.println("Solution: No Solution possible");
		System.out.println("Maze solved");
	}
	
	public static void solveMaze(Node[][] maze){
		
		Node start = maze [maze.length - 1 ][maze[0].length - 1];
		
		int currentX = start.getX();
		int currentY = start.getY();
		
		boolean nosolution = false;
		
		while(true){
			
			//visitNode //check circular using contains and return false
			if(!(maze[currentX][currentY]).isVisited()){
				solution.push(maze[currentX][currentY]);
				(maze[currentX][currentY]).setVisited(true);
			}
			//isMazedSolved
			if(currentX ==0 && currentY == 0){
					break;
			}
			
			//getNextMove
			
			//canMoveLeft canMoveUp canMoveDown canMoveRight backTrack
			if(currentY == 0 || maze[currentX][currentY-1].isVisited() || (maze[currentX][currentY-1].isWall() )){
			
				if(currentX > 0 && (maze[currentX-1][currentY].isVisited() || maze[currentX-1][currentY].isWall())){
					if(currentY < maze[0].length-1 &&  maze[currentX][currentY+1].isWall()){
						//move down
						currentX = currentX + 1;
						solution.pop();
					}
					else{
						//move right
						currentY = currentY + 1;
						solution.pop();
						if(currentY > maze[0].length-1){
							nosolution = true;
							break;
						}
					}
				}
				else {
					//move up
					currentX = currentX - 1;
					if(currentX < 0){
						nosolution = true;
						break;
					}
					
				}
				
			}
			else{
				//move left
				currentY = currentY - 1;
			}
		}
		
		if(nosolution)
			solution.clear();
		
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
