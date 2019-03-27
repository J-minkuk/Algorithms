package com.swea.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class D4_3752 {
    static int N;
    static int[] num;
    static boolean[][] check;
    static HashSet<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; ++t) {
            N = Integer.parseInt(br.readLine());
            num = new int[N];
            set = new HashSet<>();

            String[] s = br.readLine().split(" ");
            for (int i = 0; i < N; ++i) {
                num[i] = Integer.parseInt(s[i]);
            }

            check = new boolean[N + 1][10002];
            for (int i = 2; i <= N; ++i) {
                go(0, 0);
            }

            System.out.println("#" + t + " " + set.size());
        }
    }

    private static void go(int index, int sum) {
        check[index][sum] = true;
        if (!set.contains(sum)) set.add(sum);
        if (index == N) return;
        for (int i = index; i < N; ++i) {
            if (check[i + 1][sum + num[i]] == true) continue;
            go(i + 1, sum + num[i]);
        }
    }
}
