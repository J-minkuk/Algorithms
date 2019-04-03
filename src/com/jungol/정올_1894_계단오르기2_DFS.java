package com.jungol;

import java.util.Scanner;

public class 정올_1894_계단오르기2_DFS {
    static int N, count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        count = 0;

        dfs(0);
        System.out.println(count);
    }

    private static void dfs(int v) {
        if (v > N) return;
        if (v == N) {
            ++count;
            return;
        }

        dfs(v + 1);
        dfs(v + 2);
    }
}
