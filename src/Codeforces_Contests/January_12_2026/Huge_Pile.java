package Codeforces_Contests.January_12_2026;
import java.util.*;
public class Huge_Pile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            long k = sc.nextLong();

            if (k == n) {
                System.out.println(0);
                continue;
            }

            long pow = 1;
            boolean found = false;

            for (int i = 1; i <= 60; i++) {
                pow <<= 1; // pow = 2^i

                long low = n / pow;                 // floor
                long high = (n + pow - 1) / pow;    // ceil

                if (k == low || k == high) {
                    System.out.println(i);
                    found = true;
                    break;
                }

                if (high == 0) break; // no point continuing
            }

            if (!found) {
                System.out.println(-1);
            }
        }
    }
}
