An island is a small piece of land surrounded by water . A group of islands is said to be connected if we can reach from any given island to any other island in the same group . Given N islands (numbered from 1 to N) and two lists of size M (u and v) denoting island u[i] is connected to island v[i] and vice versa . Can you count the number of connected groups of islands.
Constraints :
1<=N<=100
1<=M<=(N*(N-1))/2
1<=u[i],v[i]<=N
Input Format :

Line 1 : Two integers N and M
Line 2 : List u of size of M
Line 3 : List v of size of M

Output Return Format :

The count the number of connected groups of islands

Sample Input :

2 1
1
2

Sample Output :

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
        boolean [] visited = new boolean[n];
        for(int i=0;i<m;i++)
        {
            int t1 = u[i]-1;
            int t2 = v[i]-1;
            graph[t1][t2] =1;
            graph[t2][t1]=1;
    	}
        int ans =0;
        for(int i=0;i<n;i++)
        {
            if(visited[i]==false)
            {
                getComponent(graph,visited,i);
                ans++;
            }
        }
        return ans;
    }
    public static void getComponent(int [][]graph, boolean []visited, int start)
    {
        int n = visited.length;
        ArrayList <Integer>q = new ArrayList<Integer>();
        q.add(start);
        visited[start]=true;
        while(q.isEmpty()==false)
        {
            int t = q.remove(0);
            for(int i =0;i<n;i++)
            {
                if(graph[t][i] == 1 && visited[i] ==false)
                {
                    visited[i]=true;
                    q.add(i);
                }
            }
            
        }
    }
}