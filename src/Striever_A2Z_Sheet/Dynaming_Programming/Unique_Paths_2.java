package Striever_A2Z_Sheet.Dynaming_Programming;

/*
    You are given an m x n integer array grid. There is a robot initially
    located at the top-left corner (i.e., grid[0][0]). The robot tries to move
    to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only
    move either down or right at any point in time.

    An obstacle and space are marked as 1 or 0 respectively in grid. A path that
    the robot takes cannot include any square that is an obstacle.

    Return the number of possible unique paths that the robot can take to reach
    the bottom-right corner.

    The testcases are generated so that the answer will be less than or equal to
    2 * 109.

    Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
    Output: 2
    Explanation: There is one obstacle in the middle of the 3x3 grid above.
    There are two ways to reach the bottom-right corner:
    1. Right -> Right -> Down -> Down
    2. Down -> Down -> Right -> Right
*/

public class Unique_Paths_2 {
    public static void main(String[] args) {
        int[][] obsGrid = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };

        int m = obsGrid.length;
        int n = obsGrid[0].length;
        int[][] dp = new int[m][n];
        System.out.println(tabulation(obsGrid));
    }
    private static int recursion(int[][] obsGrid, int i, int j){
        if(i==0 && j==0 && obsGrid[i][j]!=1) return 1;
        if(i<0 || j<0 || obsGrid[i][j]==1) return 0;

        int up = recursion(obsGrid, i-1, j);
        int left = recursion(obsGrid, i, j-1);

        return up+left;
    }
    private static int memoization(int[][] obsGrid, int i, int j, int[][] dp){
        if(i==0 && j==0 && obsGrid[i][j]!=1) return 1;
        if(i<0 || j<0 || obsGrid[i][j]==1) return 0;

        if(dp[i][j]!=0) return dp[i][j];
        int up = recursion(obsGrid, i-1, j);
        int left = recursion(obsGrid, i, j-1);

        return dp[i][j]=up+left;
    }
    private static int tabulation(int[][] obsGrid){
        int m = obsGrid.length;
        int n = obsGrid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0]=1;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 && j==0 && obsGrid[i][j]!=1){
                    dp[i][j]=1;
                    continue;
                }

                if(obsGrid[i][j]==1){
                    dp[i][j]=0;
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
