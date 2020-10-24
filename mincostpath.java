Given an integer matrix of size m*n, you need to find out the value of minimum cost to reach from the cell (0, 0) to (m-1, n-1).
From a cell (i, j), you can move in three directions : (i+1, j), (i, j+1) and (i+1, j+1).
Cost of a path is defined as the sum of values of each cell through which path passes.
Input Format :

Line 1 : Two integers, m and n
Next m lines : n integers of each row (separated by space)

Output Format :

Minimum cost

Constraints :
1 <= m, n <= 20
Sample Input 1 :

3 4
3 4 1 2
2 1 8 9
4 7 8 1

Sample Output 1 :

13

SOLUTION-
import java.util.Scanner;
public class Runner {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int m = s.nextInt();
		int n = s.nextInt();
		int input[][] = new int[m][n];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				input[i][j] = s.nextInt();
			}
		}
		System.out.println(Solution.minCostPath(input));
	}
}
public class Solution {
    
	public static int minCostPath(int input[][]) {
		   return minCostPath(input,0,0);
    }
    public static int minCostPath(int input[][],int i,int j) {
        int m=input.length;
        int n=input[0].length;
        
        if(i==m-1 && j==n-1)
            return input[i][j];
        
        if(i>=m || j>=n)
            return Integer.MAX_VALUE;
        
        
        int x=minCostPath( input, i, j+1);
        int y=minCostPath( input, i+1, j);
        int z=minCostPath( input, i+1, j+1);
        
        return input[i][j]+Math.min(z,Math.min(x,y));


	}
}