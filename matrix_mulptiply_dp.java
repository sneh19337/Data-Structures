Given a chain of matrices A1, A2, A3,.....An, you have to figure out the most efficient way to multiply these matrices i.e. determine where to place parentheses to minimise the number of multiplications.
You will be given an array p[] of size n + 1. Dimension of matrix Ai is p[i - 1]*p[i]. You need to find minimum number of multiplications needed to multiply the chain.
Input Format :

Line 1 : Integer n i.e. number of matrices
Line 2 : n + 1 integers i.e. elements of array p[] 

Output Format :

Line 1 : Minimum number of multiplication needed

Constraints :

1 <= n <= 100

Sample Input 1 :

3
10 15 20 25

Sample Output :

8000

Sample Output Explanation :
There are two ways to multiply the chain - A1*(A2*A3) or (A1*A2)*A3.
If multiply in order A1*(A2*A3) then number of multiplications required are 15000.
If multiply in order (A1*A2)*A3 then number of multiplications required are 8000.
Thus minimum number of multiplications required are 8000

SOLUTION-
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
	
		int n = s.nextInt();
		int p[] = new int[n + 1];
		for(int i = 0; i <= n; i++){
			p[i] = s.nextInt();
		}
		System.out.println(Solution.mcm(p));
	}

}

public class Solution {

	
	public static int mcm(int[] p){
		
	 int n=p.length;
        int storage[][]=new int[n][n];
        // cost is zero when multiplying one matrix.
        for(int i=0;i<n;i++)
            storage[i][i]=0;

        for(int l=2;l<n;l++){
            for(int i=1;i<n-l+1;i++){
                int j=i+l-1;
                if(j==n)
                    continue;
                storage[i][j] = Integer.MAX_VALUE; 
                for (int k=i; k<=j-1; k++) 
                { 
                    // q = cost/scalar multiplications 
                   int q = storage[i][k] + storage[k+1][j] + p[i-1]*p[k]*p[j]; 
                    if (q < storage[i][j]) 
                        storage[i][j] = q; 
                } 
            }
        }
        
        return storage[1][n-1];

	}


	
}
