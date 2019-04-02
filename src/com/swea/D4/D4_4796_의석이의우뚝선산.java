package com.swea.D4;

import java.util.Scanner;

public class D4_4796_의석이의우뚝선산 {
    static int N;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; ++t) {
            N = sc.nextInt();
            arr = new int[N];
            for (int i = 0; i < N; ++i) {
                arr[i] = sc.nextInt();
            }

            int count = 0;
            for (int i = 1; i < N - 1; ++i) {
                int mid = arr[i];
                if (arr[i - 1] < mid && arr[i + 1] < mid) {
                    int left = 0;
                    for (int l = i; l > 0; --l) {
                        if (arr[l] > arr[l - 1]) ++left;
                        else break;
                    }

                    int right = 0;
                    for (int r = i; r < N - 1; ++r) {
                        if (arr[r] > arr[r + 1]) ++right;
                        else break;
                    }

                    count += left * right;
                }
            }

            System.out.println("#" + t + " " + count);
        }
    }
}
