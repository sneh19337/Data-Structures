Given an undirected graph G(V, E) and two vertices v1 and v2(as integers), find and print the path from v1 to v2 (if exists). Print nothing if there is no path between v1 and v2.
Find the path using BFS and print the shortest path available.
V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.
E is the number of edges present in graph G.
Print the path in reverse order. That is, print v2 first, then intermediate vertices and v1 at last.
Note : Save the input graph in Adjacency Matrix.
Input Format :

Line 1: Two Integers V and E (separated by space)
Next E lines : Two integers a and b, denoting that there exists an edge between vertex a and vertex b (separated by space)
Line (E+2) : Two integers v1 and v2 (separated by space)

Output Format :

Path from v1 to v2 in reverse order (separated by space)

Constraints :
2 <= V <= 1000
1 <= E <= 1000
0 <= v1, v2 <= V-1
Sample Input 1 :

4 4
0 1
0 3
1 2
2 3
1 3

Sample Output 1 :

3 0 1

Sample Input 2 :

6 3
5 3
0 1
3 4
0 3

SOLUTION-
import java.util.*;

public class Solution {

	 public static void getpath(int edges[][],int start,int end,boolean visited[],HashMap<Integer, Integer> map){
        Queue<Integer> q = new LinkedList<>();
        q.add(start); 
        int n=edges.length;
        int e=0;
        while(q.size()!=0)
        {
            int nekal=q.remove();
            visited[nekal]=true;
            //
            for(int i=0;i<n;i++)
            {
                if(edges[nekal][i]==1&&!visited[i])
                {
                    map.put(i,nekal);
                    visited[i]=true;
                    q.add(i);
                    if(i==end)
                    {
                      e=1;    
                    }
                    if(e==1)
                    {
                        break;
                    }
                }
              if(e==1)
              {
                break;
              } 
            }
        }
         if(e==1)
         {
             int last=map.get(end);
             System.out.print(end+" ");
             while(last!=end)
             {
                 System.out.print(last+" ");
                 if(map.get(last)!=null)
                 last=map.get(last);
                 else {
                     break;
                 }
             }            
          }  
     }
    public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
        // total number of edges e
		int e = s.nextInt();
        int edges[][]=new int[n][n];
        for(int i=0;i<e;i++){
		// fv=first vertice
		// start=second vertice
            int fv=s.nextInt();
            int sv=s.nextInt();
            edges[fv][sv]=1;
            edges[sv][fv]=1;
        }
        int start=s.nextInt();
        int end=s.nextInt();    
         HashMap<Integer, Integer> max = new HashMap<>();
        boolean visited[]= new boolean[edges[0].length];
        getpath(edges,start,end,visited,max);
    }
}