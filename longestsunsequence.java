Given an array with N elements, you need to find the length of the longest subsequence of a given sequence such that all elements of the subsequence are sorted in strictly increasing order.
Input Format

Line 1 : An integer N 
Line 2 : Elements of arrays separated by spaces

Output Format

Line 1 : Length of longest subsequence

Input Constraints

1 <= n <= 10^3

Sample Input :

6
5 4 11 1 16 8

Sample Output 1 :

3

Sample Output Explanation

Length of longest subsequence is 3 i.e. (5,11,16) or (4,11,16).

Sample Input 2:

3
1 2 2

Sample Output 2 :

2

SOLUTION-
import java.util.Scanner;

public class Runner {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = s.nextInt();
		}
		System.out.println(Solution.lis(arr));

	}
}

public class Solution {

	public static int lis(int arr[]) {
		
		  int n = arr.length;
         int lis[] = new int[n]; 
          int i,j,max = 0; 
  
          /* Initialize LIS values for all indexes */
           for ( i = 0; i < n; i++ ) 
              lis[i] = 1; 
  
           /* Compute optimized LIS values in  
              bottom up manner */
           for ( i = 1; i < n; i++ ) 
              for ( j = 0; j < i; j++ )  
                         if ( arr[i] > arr[j] &&  
                                  lis[i] < lis[j] + 1) 
                    lis[i] = lis[j] + 1; 
  
           /* Pick maximum of all LIS values */
           for ( i = 0; i < n; i++ ) 
              if ( max < lis[i] ) 
                 max = lis[i]; 
  
            return max; 
        

	}	
}