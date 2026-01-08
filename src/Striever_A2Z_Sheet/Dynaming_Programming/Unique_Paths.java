package Striever_A2Z_Sheet.Dynaming_Programming;

/*
    There is a robot on an m x n grid. The robot is initially located at the
    top-left corner (i.e., grid[0][0]). The robot tries to move to the
    bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move
    either down or right at any point in time.

    Given the two integers m and n, return the number of possible unique paths
    that the robot can take to reach the bottom-right corner.

    The test cases are generated so that the answer will be less than or equal
    to 2 * 109.

    Input: m = 3, n = 2
    Output: 3
    Explanation: From the top-left corner, there are a total of 3 ways to reach
    the bottom-right corner:
    1. Right -> Down -> Down
    2. Down -> Down -> Right
    3. Down -> Right -> Down
*/

public class Unique_Paths {
    public static void main(String[] args) {
        int m = 3;
        int n = 2;
        int[][] dp = new int[m][n];
        System.out.println(recursion(m-1, n-1));
    }
    public static int recursion(int i, int j){
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;

        int up = recursion(i-1, j);
        int left = recursion(i, j-1);

        return up+left;
    }

    public static int memoization(int i, int j, int[][] dp){
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;

        if(dp[i][j]!=0) return dp[i][j];
        int up = memoization(i-1, j, dp);
        int left = memoization(i, j-1, dp);

        return dp[i][j]=up+left;
    }

    public static int tabulation(int m, int n){
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 && j==0){
                    dp[i][j]=1;
                    continue;
                }

                int up=0;
                if(i>0){
                    up=dp[i-1][j];
                }
                int left=0;
                if(j>0){
                    left=dp[i][j-1];
                }

                dp[i][j]=up+left;
            }
        }
        return dp[m-1][n-1];
    }
}
