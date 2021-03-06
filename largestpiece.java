Its Gary's birthday today and he has ordered his favourite square cake consisting of '0's and '1's . But Gary wants the biggest piece of '1's and no '0's . A piece of cake is defined as a part which consist of only '1's, and all '1's share an edge with eachother on the cake. Given the size of cake N and the cake , can you find the size of the biggest piece of '1's for Gary ?
Constraints :
1<=N<=50
Input Format :

Line 1 : An integer N denoting the size of cake 
Next N lines : N characters denoting the cake

Output Format :

Size of the biggest piece of '1's and no '0's

Sample Input :

2
11
01

Sample Output :

3

SOLUTION-
import java.util.*;
public class solution {
    public int solve(int n,String board[]) {
        char [][] graph = new char[n][n];
        boolean [][] visited = new boolean[n][n];
        LinkedList <String> path = new LinkedList<String>();
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                graph[i][j] =board[i].charAt(j);
            }
        }
        int ans,max;
        ans=max=0;
         for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                ans =0;
               if(visited[i][j]==false && graph[i][j]== '1')
               {
                   visited[i][j] =true;
                   ans= findBigCake(graph,visited,i,j);
                   ans++;
                   //System.out.println("fun");
                   if(max<ans)
                       max=ans;
               }
            }
        }
        return max;
        
    }
    public static  int [] getNeighbour(char graph[][],int row,int col)
    {
        int ans [] = new int[8];
        if(graph[row][col]=='0')
        {
            for(int i=0;i<8;i++)
                ans[i] =-1;
            return ans;
        }
        else
        {
            
        
        
        //right
        ans[0]= row;
        ans[1]= col+1;
        //down
    	ans[2]= row+1;
        ans[3]= col;
        //left
        ans[4]= row;
        ans[5]= col-1;
        //up
        ans[6]= row-1;
        ans[7]= col;
        
        
        return ans;
        }
    }
    
    public static int findBigCake(char [][]graph, boolean [][]visited, int row, int col)
    {
        int ans=0;
        int n = graph.length;
        LinkedList <String>q = new LinkedList<String>();
        String t = ""+(char)row+(char)col;
        q.add(t);
        int [] side = new int [8];
        while(q.isEmpty() == false)
        {
            String t1=(String)q.remove(0);
            //System.out.println("start="+t1.charAt(0)+" "+t1.charAt(1));
            int cur_row = t1.charAt(0);
            int cur_col = t1.charAt(1);
             //System.out.println("row="+cur_row+" "+cur_col);
           
            side = getNeighbour(graph,cur_row,cur_col);
            for(int i=0;i<8;i=i+2)
            {
                cur_row=side[i];
                cur_col=side[i+1];
                if(cur_row<0 || cur_col< 0 || cur_row>=n || cur_col >=n)
                    continue;
                if(visited[cur_row][cur_col]==false && graph[cur_row][cur_col]=='1')
                {
                    ans++;
                    visited[cur_row][cur_col]=true;
                    String temp = ""+(char)cur_row+(char)cur_col;
                    //System.out.print(cur_row+" "+cur_col+" ");
                    q.add(temp);
                }
                
            }
            
            
        }
        //System.out.println();
        return ans;
    }
}