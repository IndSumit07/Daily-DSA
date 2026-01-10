package Striever_A2Z_Sheet.Dynaming_Programming;

/*
    Given a triangle array, return the minimum path sum from top to bottom.

    For each step, you may move to an adjacent number of the row below. More
    formally, if you are on index i on the current row, you may move to either index
    i or index i + 1 on the next row.



    Example 1:

    Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
    Output: 11
    Explanation: The triangle looks like:
       2
      3 4
     6 5 7
    4 1 8 3
    The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined
    above).
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    public static void main(String[] args) {
        int[][] arr = {
                {2},
                {3, 4},
                {6,5,7},
                {4,1,8,3}
        };
        int[][] dp = new int[arr.length][arr.length];
        System.out.println(spaceOptimization(arr));
    }

    public static int recursion(int[][] arr, int i, int j){
        if(i==arr.length-1){
            return arr[i][j];
        }

        int d = arr[i][j] + recursion(arr, i+1, j);
        int dg = arr[i][j] + recursion(arr, i+1, j+1);

        return Math.min(d, dg);
    }

    public static int memoization(int[][] arr, int i, int j, int[][] dp){
        if(i==arr.length-1){
            return arr[i][j];
        }

        if(dp[i][j]!=0) return dp[i][j];
        int d = arr[i][j] + memoization(arr, i+1, j, dp);
        int dg = arr[i][j] + memoization(arr, i+1, j+1, dp);

        return dp[i][j] = Math.min(d, dg);
    }
    public static int tabulation(int[][] arr){
        int[][] dp = new int[arr.length][arr.length];
        for(int j=0; j<arr.length; j++){
            dp[arr.length-1][j] = arr[arr.length-1][j];
        }

        for(int i=arr.length-2; i>=0; i--){
            for(int j=i; j>=0; j--){
                int d = arr[i][j] + dp[i+1][j];
                int dg = arr[i][j] + dp[i+1][j+1];

                dp[i][j] = Math.min(d, dg);
            }
        }
        return dp[0][0];
    }

    public static int spaceOptimization(int[][] arr){
        int[] front = new int[arr.length];

        for(int j=0; j<arr.length; j++){
            front[j]=arr[arr.length-1][j];
        }

        for(int i=arr.length-2; i>=0; i--){
            int[] cur = new int[arr.length];
            for(int j=i; j>=0; j--){
                int d = arr[i][j] + front[j];
                int dg = arr[i][j] + front[j+1];

                cur[j]=Math.min(d, dg);
            }
            front=cur;
        }
        return front[0];
    }
}
