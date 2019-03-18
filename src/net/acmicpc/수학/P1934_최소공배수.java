package net.acmicpc.수학;

import java.util.Scanner;

/**
 * 최소공배수
 */
public class P1934_최소공배수 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        int[] a = new int[testCase];
        int[] b = new int[testCase];
        int lcm = 0;
        int gcd = 1;
        for (int i = 0; i < testCase; ++i) {
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
        }

        for (int i = 0; i < testCase; ++i) {
            if (a[i] <= b[i]) {
                for (int j = 1; j <= a[i]; ++j) {
                    if (a[i] % j == 0 && b[i] % j == 0) {
                        gcd = j;
                    }
                }
            } else {
                for (int j = 1; j <= b[i]; ++j) {
                    if (a[i] % j == 0 && b[i] % j == 0) {
                        gcd = j;
                    }
                }
            }
            lcm = a[i] * b[i] / gcd;
            System.out.println(lcm);
        }
    }
}
