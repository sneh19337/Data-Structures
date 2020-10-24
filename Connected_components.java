Given an undirected graph G(V,E), find and print all the connected components of the given graph G.
V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.
E is the number of edges present in graph G.
You need to take input in main and create a function which should return all the connected components. And then print them in the main, not inside function.
Print different components in new line. And each component should be printed in increasing order (separated by space). Order of different components doesn't matter.
Input Format :

Line 1: Two Integers V and E (separated by space)
Next 'E' lines, each have two space-separated integers, 'a' and 'b', denoting that there exists an edge between Vertex 'a' and Vertex 'b'.

Output Format :

Different components in new line

Constraints :
2 <= V <= 1000
1 <= E <= 1000
Sample Input 1:

4 2
0 1
2 3

Sample Output 1:

0 1 
2 3 

Sample Input 2:

4 3
0 1
1 3 
0 3

Sample Output 2:

0 1 3 
2

SOLUTION-
import java.util.*;

public class Solution {

	public static void help(int edges[][],boolean visited[],ArrayList<Integer> arr,int start){  
        visited[start]=true;
        arr.add(start);
        int n=edges.length;   
          for(int j=0;j<n;j++){
              if(edges[start][j]==1&&!visited[j]){
                 help(edges,visited,arr,j); 
              }
          }
    }
    public static void helpp(int edges[][],int start){
        boolean visited[]=new boolean[edges.length];
        for(int i=0;i<edges.length;i++){
          if(!visited[i]){
              // this array list is creating again and again
             ArrayList<Integer> arrans= new ArrayList<Integer>();
             help(edges,visited,arrans,i);
             Collections.sort(arrans);
             for(int j=0;j<arrans.size();j++)
                System.out.print(arrans.get(j)+" ");   
                System.out.println();
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
            int fv=s.nextInt();
            int sv=s.nextInt();
            edges[fv][sv]=1;
            edges[sv][fv]=1;
        }
        helpp(edges,0);
    }
}