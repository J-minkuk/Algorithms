package com.swea.D3;

import java.util.Scanner;

public class D3_6692_다솔이의월급상자 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; ++t) {
            int N = sc.nextInt();
            double result = 0;
            for (int i = 0; i < N; ++i) {
                double p = sc.nextDouble();
                double x = sc.nextDouble();
                result += p * x;
            }
            System.out.printf("#%d %.6f", t, result);
        }
    }
}
