package com.algorithm;

import java.util.Scanner;

public class Fibonacci3_DP {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] result = new long[N + 1];
        result[0] = 0;
        result[1] = 1;
        for (int i = 2; i <= N; ++i) {
            result[i] = result[i - 2] + result[i - 1];
        }
        System.out.println(result[N]);
    }

}
