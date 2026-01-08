package Leetcode;

/*
    Given two arrays nums1 and nums2.

    Return the maximum dot product between non-empty subsequences of nums1 and nums2
    with the same length.

    A subsequence of an array is a new array which is formed from the original array
    by deleting some (can be none) of the characters without disturbing the relative
    positions of the remaining characters. (ie, [2,3,5] is a subsequence of
    [1,2,3,4,5] while [1,5,3] is not).

    Example 1:

    Input: nums1 = [2,1,-2,5], nums2 = [3,0,-6]
    Output: 18
    Explanation: Take subsequence [2,-2] from nums1 and subsequence [3,-6] from nums2.
    Their dot product is (2*3 + (-2)*(-6)) = 18.
*/

public class Day_08 {
    public static void main(String[] args) {
        int[] nums1 = {3, -2};
        int[] nums2 = {2, -6, 7};

        System.out.println(maxDotProduct1(nums1, nums2, 0, 0));
    }

    // Basic Recursion
    private static int maxDotProduct1(int[] nums1, int[] nums2, int i, int j){
        if(i==nums1.length || j==nums2.length){
            return Integer.MIN_VALUE;
        }

        int take = nums1[i]*nums2[j]+Math.max(0, maxDotProduct1(nums1, nums2, i+1, j+1));
        int skipA = maxDotProduct1(nums1, nums2, i+1, j);
        int skipB = maxDotProduct1(nums1, nums2, i, j+1);

        return Math.max(take, Math.max(skipA, skipB));
    }

    // Using DP Array -> Memoization Solution
    private static int maxDotProduct2(int[] nums1, int[] nums2, int i, int j, int[][] dp){
        if(i==nums1.length || j==nums2.length){
            return Integer.MIN_VALUE/2;
        }

        if(dp[i][j]!=0){
            return dp[i][j];
        }
        int take = nums1[i]*nums2[j]+Math.max(0, maxDotProduct2(nums1, nums2, i+1, j+1, dp));
        int skipA = maxDotProduct2(nums1, nums2, i+1, j, dp);
        int skipB = maxDotProduct2(nums1, nums2, i, j+1, dp);

        return dp[i][j]=Math.max(take, Math.max(skipA, skipB));
    }

    // Tabulation Solution

    private static int maxDotProduct3(int[] nums1, int[] nums2){
        int n = nums1.length;
        int m = nums2.length;

        int[][] dp = new int[n+1][m+1];

        for (int i = 0; i <= n; i++) {
            dp[i][m] = Integer.MIN_VALUE / 2;
        }
        for (int j = 0; j <= m; j++) {
            dp[n][j] = Integer.MIN_VALUE / 2;
        }

        for(int i=n-1; i>=0; i--){
            for(int j=m-1; j>=0; j--){

                int take = nums1[i]*nums2[j] + Math.max(0, dp[i+1][j+1]);
                int skipA = dp[i+1][j];
                int skipB = dp[i][j+1];

                dp[i][j]=Math.max(take, Math.max(skipA, skipB));
            }
        }

        return dp[0][0];
    }

}


/*
    Ques. Why return Integer.MIN_VALUE;
    Ans. “Returning a very negative number makes ‘choosing nothing’ worse than choosing any real pair, even if the pair           product is negative.”
*/