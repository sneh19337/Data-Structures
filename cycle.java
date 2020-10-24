Given a graph with N vertices (numbered from 1 to N) and Two Lists (U,V) of size M where (U[i],V[i]) and (V[i],U[i]) are connected by an edge , then count the distinct 3-cycles in the graph. A 3-cycle PQR is a cycle in which (P,Q), (Q,R) and (R,P) are connected an edge.
Input Format :

Line 1 : Two integers N and M
Line 2 : List u of size of M
Line 3 : List v of size of M

Return Format :

The count the number of 3-cycles in the given Graph

Constraints :
1<=N<=100
1<=M<=(N*(N-1))/2
1<=u[i],v[i]<=N
Sample Input:

3 3
1 2 3
2 3 1

Sample Output:

1

SOLUTION-
import java.util.Scanner;

public class runner {
	public static int[]u=new int [5005];
	public static int[]v=new int [5005];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,m;
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		for(int i=0;i<m;i++)
		{
			u[i]=scan.nextInt();
		}
		for(int i=0;i<m;i++)
		{
			v[i]=scan.nextInt();
		}
		System.out.println(new solution().solve(n,m,u,v));
	}
}
public class solution {
    public int solve(int n,int m,int u[],int v[]) {
        //write your code here
        int [][] graph = new int[n][n];
        for(int i=0;i<m;i++)
        {
            
            int row = u[i]-1;
            int col = v[i]-1;
            graph[row][col]=1;
            graph[col][row]=1;
        }
        int count=0;
    	for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                
                if(graph[i][j]==1)
                {
                    for(int k=0;k<n;k++)
                	{
                    	if(graph[j][k]==1&&graph[k][i]==1)
                            count++;
                	}
                }
                
            }
        }
        //System.out.println(count);
        return count/6;
        
    }
}