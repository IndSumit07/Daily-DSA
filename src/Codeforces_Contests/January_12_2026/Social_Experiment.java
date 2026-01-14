package Codeforces_Contests.January_12_2026;

import java.util.*;
public class Social_Experiment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-->0){
            int n = sc.nextInt();

            if(n==2){
                System.out.println(2);
                continue;
            }
            if(n==3){
                System.out.println(3);
                continue;
            }

            if(n%2==0){
                System.out.println(0);
            }else{
                System.out.println(1);
            }
        }
    }
}
