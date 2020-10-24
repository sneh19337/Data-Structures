Given an undirected, connected and weighted graph G(V, E) with V number of vertices (which are numbered from 0 to V-1) and E number of edges.
Find and print the shortest distance from the source vertex (i.e. Vertex 0) to all other vertices (including source vertex also) using Dijkstra's Algorithm.
Print the ith vertex number and the distance from source in one line separated by space. Print different vertices in different lines.
Note : Order of vertices in output doesn't matter.
Input Format :

Line 1: Two Integers V and E (separated by space)
Next E lines : Three integers ei, ej and wi, denoting that there exists an edge between vertex ei and vertex ej with weight wi (separated by space)

Output Format :

In different lines, ith vertex number and its distance from source (separated by space)

Constraints :
2 <= V, E <= 10^5
Sample Input 1 :

4 4
0 1 3
0 3 5
1 2 1
2 3 8

Sample Output 1 :

0 0
1 3
2 4
3 5

SOLUTION-
import java.util.Scanner;

public class Solution {

private static void dijkstra(int[][] adjacencyMatrix) {
		int v = adjacencyMatrix.length;
		boolean visited[] = new boolean[v];
		int distance[] = new int[v];
		distance[0] = 0;
		for(int i = 1; i < v; i++){
			distance[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 0; i < v - 1; i++){
			// Find Vertex with Min distance
			int minVertex = findMinVertex(distance, visited);
			visited[minVertex] = true;
			// Explore neighbors
			for(int j = 0; j < v; j++){
				if(adjacencyMatrix[minVertex][j] != 0 && !visited[j] && distance[minVertex] != Integer.MAX_VALUE){
					int newDist = distance[minVertex] + adjacencyMatrix[minVertex][j];
					if(newDist < distance[j]){
						distance[j] = newDist;
					}
				}
			}
		}
		
		// Print
		for(int i = 0; i < v; i++){
			System.out.println(i + " "+ distance[i]);
		}
		
	}
		
private static int findMinVertex(int[] distance, boolean visited[]) {
		
		int minVertex = -1;
		for(int i = 0; i < distance.length; i++){
			if(!visited[i]  && (minVertex == -1 || distance[i] < distance[minVertex])){
				minVertex = i;
			}
		}
		return minVertex;
	}
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int v = s.nextInt();
		int e = s.nextInt();
		int adjacencyMatrix[][] = new int[v][v];
		for(int i = 0; i < e; i++){
			int v1 = s.nextInt();
			int v2 = s.nextInt();
			int weight = s.nextInt();
			adjacencyMatrix[v1][v2] = weight;
			adjacencyMatrix[v2][v1] = weight;
		}
		dijkstra(adjacencyMatrix);
}


}