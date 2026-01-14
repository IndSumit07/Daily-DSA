package GFG;
import java.util.*;
/*
    Given an array arr[], where each element contains either a 'P' for policeman or
    a 'T' for thief. Find the maximum number of thieves that can be caught by the
    police.

    Keep in mind the following conditions :

    1. Each policeman can catch only one thief.
    2. A policeman cannot catch a thief who is more than k units away from him.

    Input: arr[] = ['P', 'T', 'T', 'P', 'T'], k = 1
    Output: 2
    Explanation: Maximum 2 thieves can be caught. First policeman catches first
    thief and second police man can catch either second or third thief.
*/

public class Day_14 {
    public static void main(String[] args) {
        char[] arr = {'T', 'T', 'P', 'P', 'T', 'P'};
        int k = 2;

        System.out.println(catchThieves(arr, k));
    }

    public static int catchThieves(char[] arr, int k){
        ArrayList<Integer> t = new ArrayList<>();
        ArrayList<Integer> p = new ArrayList<>();

        for(int i=0; i<arr.length; i++){
            if(arr[i]=='T'){
                t.add(i);
            }else{
                p.add(i);
            }
        }

        int i=0;
        int j=0;
        int ans=0;

        while(i<t.size() && j<p.size()){
            if(Math.abs(t.get(i) - p.get(j))<=k){
                i++;
                j++;
                ans++;
            }else if(t.get(i)<p.get(j)){
                i++;
            }else {
                j++;
            }
        }
        return ans;
    }
}
