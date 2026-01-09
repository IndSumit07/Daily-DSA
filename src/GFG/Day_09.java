package GFG;

/*
    You are given an array arr[] of positive integers and an integer k, find the
    number of subarrays in arr[] where the count of distinct integers is at most
    k.

    Note: A subarray is a contiguous part of an array.

    Input: arr[] = [1, 2, 2, 3], k = 2
    Output: 9
    Explanation: Subarrays with at most 2 distinct elements are: [1], [2], [2],
    [3], [1, 2], [2, 2], [2, 3], [1, 2, 2] and [2, 2, 3].
*/

import java.util.HashMap;

public class Day_09 {
    public static void main(String[] args) {
        int[] arr={1, 2, 2, 3};
        int k=2;

        HashMap<Integer, Integer> map = new HashMap<>();
        int l=0;
        int r=0;
        int ans=0;

        while(r<arr.length){
            map.put(arr[r], map.getOrDefault(arr[r], 0)+1);

            while(map.size()>k){
                if(map.get(arr[l])==1){
                    map.remove(arr[l]);
                }else{
                    map.put(arr[l], map.get(arr[l])-1);
                }
                l++;
            }

            ans+=r-l+1;
            r++;
        }

        System.out.println(ans);

    }

}
