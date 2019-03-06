package com.swea.D4;

import java.util.Scanner;

public class D4_5213 {
    public static void main(String[] args) {
        long[] list = new long[1000001];
        for (int i = 1; i < 1000000; i += 2) { // 1부터 홀수를 쭉 돌면서
            for (int j = 1; (j * i) <= 1000000; ++j) {
                list[j * i] += i;
            }
        }

        for (int i = 1; i < 1000000; ++i) {
            list[i + 1] += list[i];
        }

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; ++t) {
            int L = sc.nextInt();
            int R = sc.nextInt();
            System.out.println("#" + t + " " + (list[R] - list[L - 1]));
        }
    }
}