
A thief robbing a store and can carry a maximal weight of W into his knapsack. There are N items and ith item weigh wi and is of value vi. What is the maximum value V, that thief can take ?
Space complexity should be O(W).
Input Format :

Line 1 : N i.e. number of items
Line 2 : N Integers i.e. weights of items separated by space
Line 3 : N Integers i.e. values of items separated by space
Line 4 : Integer W i.e. maximum weight thief can carry

Output Format :

Line 1 : Maximum value V

Constraints
1 <= N <= 10^4
1<= wi <= 100
1 <= vi <= 100
Sample Input 1 :

4
1 2 4 5
5 4 8 6
5

Sample Output :

13

SOLUTION-
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int weight[] = new int[n];
		for(int i = 0 ; i < n; i++){
			weight[i] = s.nextInt();
		}
		int value[] = new int[n];
		for(int i = 0 ; i < n; i++){
			value[i] = s.nextInt();
		}
		int maxWeight = s.nextInt();
		System.out.println(Solution.knapsack(weight, value, maxWeight));
		
	}

}

public class Solution {
	
	
	
public static int knapsack(int[] weight,int value[],int maxWeight){

	/* Your class should be named Solution.
	 * Don't write main() function.
	 * Don't read input, it is passed as function argument.
	 * Return output and don't print it.
	 * Taking input and printing output is handled automatically.
	 */       
      int storagePrev[] = new int[maxWeight+1];
        int storageCurrent[] = new int [maxWeight+1];
        for(int i=1;i<value.length+1;i++){
            for(int w = 1;w<maxWeight+1;w++){
                if(weight[i-1]>w){
                    storageCurrent[w] = storagePrev[w];
                }
                else { 
                storageCurrent[w]= Math.max(storagePrev[w - weight[i-1]]+ value[i-1],storagePrev[w]);
                }
            }
                storagePrev = storageCurrent ;
                storageCurrent = new int[maxWeight+1];
            
        }
        return storagePrev[maxWeight];
		
	}
}