package Striever_A2Z_Sheet.Dynaming_Programming;

/*
    Geek is going for a training program for n days. He can perform any of
    these activities: Running, Fighting, and Learning Practice. Each activity
    has some point on each day. As Geek wants to improve all his skills, he
    can't do the same activity on two consecutive days. Given a 2D array
    arr[][] of size n where arr[i][0], arr[i][1], and arr[i][2] represent the
    merit points for Running, Fighting, and Learning on the i-th day, determine
    the maximum total merit points Geek can achieve.

    Example:

    Input: arr[]= [[1, 2, 5], [3, 1, 1], [3, 3, 3]]
    Output: 11
    Explanation: Geek will learn a new move and earn 5 point then on second
    day he will do running and earn 3 point and on third day he will do
    fighting and earn 3 points so, maximum merit point will be 11.
*/

public class Ninjas_Training {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,5},
                {3,1,1},
                {3,3,3}
        };

        int[][] dp = new int[arr.length][4];

        System.out.println(memoization(arr, dp, arr.length-1, 3));

    }
    private static int memoization(int[][] arr, int[][] dp, int day, int last){
        if(day==0){
            int max=0;
            for(int i=0; i<3; i++){
                if(i!=last){
                    dp[0][i]=arr[0][i];
                    max=Math.max(max, arr[0][i]);
                }
            }
            return max;
        }

        if(dp[day][last]!=0) return dp[day][last];
        int max=0;
        for(int i=0; i<3; i++){
            if(i!=last){
                int points = arr[day][i] + memoization(arr, dp, day-1, i);
                max=Math.max(max, points);
            }
        }
        return dp[day][last]=max;
    }

    private static int tabulation(int[][] arr){
        int n = arr.length;
        int[][] dp = new int[n][4];

        dp[0][0] = Math.max(arr[0][1], arr[0][2]);
        dp[0][1] = Math.max(arr[0][0], arr[0][2]);
        dp[0][2] = Math.max(arr[0][0], arr[0][1]);
        dp[0][3] = Math.max(arr[0][0], Math.max(arr[0][1], arr[0][2]));

        for(int i=1; i<n; i++){
            for(int last=0; last<4; last++){
                dp[i][last]=0;
                for(int task=0; task<3; task++){
                    if(task!=last){
                        int point = arr[i][task]+dp[i-1][task];
                        dp[i][last] = Math.max(dp[i][last], point);
                    }
                }
            }
        }
        return dp[n-1][3];
    }

    private static int spaceOptimized(int[][] arr){
        int n=arr.length;
        int[] dp = new int[4];

        dp[0]=Math.max(arr[0][1], arr[0][2]);
        dp[1]=Math.max(arr[0][0], arr[0][2]);
        dp[2]=Math.max(arr[0][0], arr[0][1]);
        dp[3]=Math.max(arr[0][1], Math.max(arr[0][0], arr[0][2]));

        for(int i=1; i<n; i++){
            int[] temp = new int[4];
            for(int last=0; last<4; last++){
                temp[last]=0;

                for(int task=0; task<3; task++){
                    if(task!=last){
                        int point = arr[i][task] + dp[task];
                        temp[last] = Math.max(temp[last], point);
                    }
                }
            }
            dp=temp;
        }
        return dp[3];
    }
}
