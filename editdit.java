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
1<= m,n <= 10
Sample Input 1 :

abc
dc

Sample Output 1 :

2

SOLUTION-
import java.util.Scanner;

public class runner {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
	
		String str1 = s.next();
		String str2 = s.next();
		System.out.println(Solution.editDistance(str1, str2));
	}
}
public class Solution {
	public static int editDistance(String s1, String s2){		
		  if(s1.length() == 0 && s2.length() != 0)
            return s2.length();
        if(s1.length() != 0 && s2.length() == 0)
            return s1.length();
        if(s1.length() == 0 && s2.length() == 0)
            return 0;
        
        int op1 = 0, op2 = 0, op3 = 0;
        if(s1.charAt(0) == s2.charAt(0)) {
            return editDistance(s1.substring(1), s2.substring(1));
        } else {
            op1 = editDistance(s1, s2.substring(1));
            op2 = editDistance(s1.substring(1), s2);
            op3 = editDistance(s1.substring(1), s2.substring(1));
            return 1 + Math.min(op1, Math.min(op2, op3));
        }
}
}
