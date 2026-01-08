package GFG;

/*
    You are given an array arr[] of positive integers and an integer k.
    You have to count the number of subarrays that contain exactly k odd numbers.

    Input: arr[] = [2, 5, 6, 9], k = 2
    Output: 2
    Explanation: There are 2 subarrays with 2 odds: [2, 5, 6, 9] and [5, 6, 9].

    Input: arr[] = [2, 2, 5, 6, 9, 2, 11], k = 2
    Output: 8
    Explanation: There are 8 subarrays with 2 odds: [2, 2, 5, 6, 9], [2, 5, 6, 9], [5, 6, 9], [2, 2, 5, 6, 9, 2], [2, 5, 6, 9, 2], [5, 6, 9, 2], [6, 9, 2, 11] and [9, 2, 11].
*/

public class Day_08 {
    public static void main(String[] args) {
        int[] arr = {2, 2, 5, 6, 9, 2, 11};
        int k = 2;

        System.out.println(countSubarrays(arr, k));
    }
    private static int countSubarrays(int[] arr, int k){
        int ans = 0;
        int oddCount=0;
        int l=0;
        int r=0;
        int validStart=0;
        int n=arr.length;

        while(r<n){
            if(arr[r]%2!=0){
                oddCount++;
                validStart=0;
            }

            while(oddCount==k){
                validStart++;
                if(arr[l]%2!=0){
                    oddCount--;
                }
                l++;
            }

            ans+=validStart;
            r++;
        }

        return ans;
    }
}
