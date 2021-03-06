Gary has two string S and V. Now Gary wants to know the length shortest subsequence in S such that it is not a subsequence in V.
Note: input data will be such so there will always be a solution.
Input Format :

Line 1 : String S of length N (1 <= N <= 1000)
Line 2 : String V of length M (1 <= M <= 1000)

Output Format :

Length of shortest subsequence in S such that it is not a subsequence in V

Sample Input :

babab
babba

Sample Output :

3

SOLUTION-
import java.util.*;
public class runner {

	public static void main(String[] args) {
		
		String S,V;
		
		Scanner scan = new Scanner(System.in);
		
		S = scan.next();
		V = scan.next();
		System.out.println(new solution().solve(S,V));

	}

}

public class solution {
	
	public int solve(String S,String V){
		
	int m = S.length();
		int n = V.length();
		int[][] storage = new int[m + 1][n + 1];
		for(int i = 1; i <= m; i ++)
			storage[i][0] = 1;
		for(int j = 0; j <= n; j ++)
			storage[0][j] = Integer.MAX_VALUE;
		for(int i = 1; i <= m; i ++) {
			char ch = S.charAt(i - 1);
			for(int j = 1; j <= n; j ++) {
				// Searching
				int k;
				for(k = j - 1; k >= 0; k --) {
					if(V.charAt(k) == ch)
						break;
				}
				// Not Found
				if(k == -1)
					storage[i][j] = 1;
				else {
					int x = storage[i - 1][j];
					int y = storage[i - 1][k];
					if(y != Integer.MAX_VALUE)
						y ++;
					storage[i][j] = Math.min(x, y);
				}
			}
		}
		return storage[m][n];
	}
	
}
