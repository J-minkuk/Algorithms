package com.swea.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1
3
13 0 50
12 70 90
25 60 100

 */
public class D4_1865_동철이의일분배_DFS {
    static int N;
    static double max;
    static double[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; ++t) {
            N = Integer.parseInt(br.readLine().trim());
            map = new double[N][N];
            for (int i = 0; i < N; ++i) {
                String[] s = br.readLine().split(" ");
                for (int j = 0; j < N; ++j) {
                    map[i][j] = Integer.parseInt(s[j]) * 0.01;
                }
            }

            max = 0.0;
            visited = new boolean[N];
            dfs(0, 1.0);
            System.out.printf("#%d %.6f", t, max * 100);
            System.out.println();
        }
    }

    private static void dfs(int r, double value) {
        if (value <= max) return;
        if (r == N) {
            max = Math.max(max, value);
            return;
        }

        for (int i = 0; i < N; ++i) {
            if (!visited[i] && map[r][i] != 0) {
                visited[i] = true;
                dfs(r + 1, value * map[r][i]);
                visited[i] = false;
            }
        }
    }
}
