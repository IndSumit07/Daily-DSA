package Codeforces_Contests.January_12_2026;

import java.util.*;

public class Hourglass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long s = sc.nextLong();
            long k = sc.nextLong();
            long m = sc.nextLong();

            long flips = m / k;
            long rem = m % k;

            long result;

            if (s < k) {
                result = Math.max(0, s - rem);
            } else {
                if (flips % 2 == 0) {
                    result = Math.max(0, s - rem);
                } else {
                    result = Math.max(0, k - rem);
                }
            }

            System.out.println(result);
        }
    }
}
