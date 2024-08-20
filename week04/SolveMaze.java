
public class SolveMaze{

	/*• Solving a maze 
		– Each time we have to decide to go left/right, up or down
		– Can I go from “S” to “E” without passing through any * characters ?
	  • Take one step at a time 
		– Need to prevent cycles
		– Remember cells visited 
		– Number of cells gets smaller 
		– Bad choices will “die”	*/


	public static boolean isMazeSolveable(char[][] maze){
		int startX, startY;
		startX = -1;
		startY = -1;

		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if (maze[i][j] == 'S'){
					startX = i;
					startY = j;
				}
			}
		}

		// if we cannot find the start point, return false;
		if (startX == -1)	return false;
		return exploreMaze(maze, startX, startY);
	}

	public static boolean exploreMaze(char[][] maze, int x, int y){

		// if go out the boundary;
		if( x<1 || x>8 || y<1 || y>8)	return false;

		if(maze[x][y] == '*')	return false;
		if(maze[x][y] == 'E')	return true;

		// set the route char to '*' as obstacle;
		maze[x][y] = '*';

		// Otherwise, keep exploring by trying each possible next decision from this point.  
		// If any of the options allow us to solve the maze, then return true.
		// We don't have to worry about going off the grid or through a wall - 
  		// we can trust our recursive call to handle those possibilities correctly.
		if( exploreMaze( maze, x+1, y) )	return true;
		if( exploreMaze( maze, x-1, y) )	return true;
		if( exploreMaze( maze, x, y+1) )	return true;
		if( exploreMaze( maze, x, y-1) )	return true;


		// None of the options worked, so we can't solve the maze using this path.
		return false;
	}



	public static void main(String[] args) {
		char[][] maze = {{'*','*','*','*','*',' ',' ',' '},
						{'*',' ',' ',' ','*',' ',' ',' '},
						{'*','S','*','*','*',' ',' ',' '},
						{'*',' ',' ',' ','*','*','*','*'},
						{'*',' ','*',' ',' ',' ',' ','*'},
						{'*',' ',' ',' ','*',' ',' ','*'},
						{'*','*','*','*','*',' ','E','*'},
						{' ',' ',' ',' ','*','*','*','*'}};

		if (isMazeSolveable(maze))
			System.out.println("this maze is solveable. ");				

	}
}