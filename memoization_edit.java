Given two strings s and t of lengths m and n respectively, find the Edit Distance between the strings. Edit Distance of two strings is minimum number of steps required to make one string equal to other. In order to do so you can perform following three operations only :

1. Delete a character

2. Replace a character with another one

3. Insert a character

Note - Strings don't contain spaces
Input Format :

Line 1 : String s
Line 2 : String t

Output Format :

Line 1 : Edit Distance value

Constraints

1<= m,n <= 20

Sample Input 1 :

abc
dc

Sample Output 1 :

2

SOLUTION-
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
	
		String str1 = s.nextLine();
		String str2 = s.nextLine();
		System.out.println(Solution.editDistance(str1, str2));
		
	}

}

public class Solution {

	
	public static int editDistance(String s1, String s2){
		
  int[][] output = new int[s1.length() + 1][s2.length() + 1];
        for(int i = 0; i <= s1.length(); i ++) {
            output[i][0] = i;
        }
        for(int i = 0; i <= s2.length(); i ++) {
            output[0][i] = i;
        }
        for(int i = 1; i <= s1.length(); i ++) {
            for(int j = 1; j <= s2.length(); j ++) {
                if(s1.charAt(s1.length() - i) == s2.charAt(s2.length() - j))
                    output[i][j] = output[i - 1][j - 1];
                else
                    output[i][j] = 1 + Math.min(output[i][j - 1], Math.min(output[i - 1][j - 1], output[i - 1][j]));
            }
        }
        return output[s1.length()][s2.length()];
	
}

}
