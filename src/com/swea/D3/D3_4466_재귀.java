package com.swea.D3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_4466_재귀 {
    static int N;
    static int K;
    static int max;
    static int[] scores;
    static boolean[] check;

    private static void getMaxScore(int index) {
        if (index == K) {
            int sum = 0;
            for (int i = 0; i < N; ++i) {
                if (check[i]) sum += scores[i];
            }
            if (sum > max) max = sum;
            return;
        }
        for (int i = 0; i < N; ++i) {
            if (!check[i]) {
                check[i] = true;
                getMaxScore(index + 1);
                check[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("C:\\intelliJ_workspaces\\Algorithm\\src\\com\\swea\\D3\\testcase\\4466input.txt"));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; ++t) {
            String[] str = br.readLine().split(" ");
            N = Integer.parseInt(str[0]);
            K = Integer.parseInt(str[1]);
            check = new boolean[N + 1];

            max = 0;
            scores = new int[N];
            String[] sC = br.readLine().split(" ");
            for (int i = 0; i < N; ++i) {
                scores[i] = Integer.parseInt(sC[i]);
            }
            getMaxScore(0);
            System.out.println("#" + t + " " + max);
        }
    }
}
