Gary has a board of size NxM. Each cell in the board is a coloured dot. There exist only 26 colours denoted by uppercase Latin characters (i.e. A,B,...,Z). Now Gary is getting bore and wants to play a game. The key of this game is to find a cycle that contain dots of same colour. Formally, we call a sequence of dots d1, d2, ..., dk a cycle if and only if it meets the following condition:

1. These k dots are different: if i ≠ j then di is different from dj.
2. k is at least 4.
3. All dots belong to the same colour.
4. For all 1 ≤ i ≤ k - 1: di and di + 1 are adjacent. Also, dk and d1 should also be adjacent. Cells x and y are called adjacent if they share an edge.

Since Gary is colour blind, he wants your help. Your task is to determine if there exists a cycle on the board.
Assume input to be 0-indexed based.
Input Format :

Line 1 : Two integers N and M, the number of rows and columns of the board
Next N lines : a string consisting of M characters, expressing colors of dots in each line. Each character is an uppercase Latin letter.

Output Format :

Return 1 if there is a cycle else return 0

Constraints :
2 ≤ N, M ≤ 50
Sample Input :

3 4
AAAA
ABCA
AAAA

Sample Output :

1

SOLUTION-
import java.util.*;
class solution {
	
	int solve(String[] board , int n, int m)
	{
		// Write your code here.
        char [][] graph = new char[n][m];
        boolean [][] visited = new boolean[n][m];
        LinkedList <String> path = new LinkedList<String>();
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                graph[i][j] =board[i].charAt(j);
            }
        }
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                char c = graph[i][j];
                path= new <String>LinkedList();
                String t = ""+(char)(i)+(char)(j);
                path.add(t);
                visited[i][j] =true;
                boolean ans = findLoop(graph,visited,path,c);
                
                if(ans == true)
                    return 1;
            }
        }
        //System.out.println();
        return 0;

	}
    public static boolean isStart(int i, int j, String start)
    {
        int row = start.charAt(0);
        int col = start.charAt(1);
        
        //left
        if(i==row && j-1 == col)
            return true;
        //right
        if(i == row && j+1 == col)
			return true;
        //up
        if(i-1==row && j== col)
            return true;
        //down
        if(i+1==row && j==col)
            return true;
        
        return false;
        
            
    }
    public static boolean findLoop(char [][]graph, boolean [][]visited,LinkedList <String>path,char c)
    {
        int n = graph.length;
        int m = graph[0].length;
        int list_size = path.size();
        boolean ans;
        String t = path.getLast();
        int row = t.charAt(0);
    	int col = t.charAt(1);
        String start = path.get(0);
        if(list_size>=4 && isStart(row,col,start)== true)
            return true;
        //System.out.print(row+" "+col+" "+c);
        int [] side = new int[8];
        side[0] = row+1;
        side[1] =col;
        side[2] = row-1;
        side[3] = col;
        side[4] = row;
        side[5] = col+1;
        side[6] = row;
        side[7] = col-1;
            
            for(int i=0;i<8;i=i+2)
            {
                if(side[i]<0 || side[i+1] < 0 || side[i]>=n || side[i+1] >=m)
            		continue;
                int cur_row = side[i];
                int cur_col = side[i+1];
            	
                if(visited[cur_row][cur_col] == false && graph[cur_row][cur_col] == c)
                {
                    visited[cur_row][cur_col]=true;
                    String temp = ""+(char)(cur_row)+(char)(cur_col);
                    
                	path.add(temp);
                	ans = findLoop(graph,visited,path,c);
                	if(ans == true )
                    	return true;
                
                	else
                	{
                    	path.remove(temp);
                    	visited[cur_row][cur_col]=false;
                	}
                
            	}
            }
            
            return false;
    }
}
