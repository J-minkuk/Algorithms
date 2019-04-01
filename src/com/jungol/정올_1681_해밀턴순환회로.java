package com.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
5
0 14 4 10 20
14 0 7 8 7
4 5 0 7 16
11 7 9 0 2
18 7 17 4 0

 */
public class 정올_1681_해밀턴순환회로 {
    static int N, min;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        map = new int[N][N];
        for (int i = 0; i < N; ++i) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < N; ++j) {
                map[i][j] = Integer.parseInt(s[j]);
            }
//            System.out.println(Arrays.toString(map[i]));
        }

        visited = new boolean[N];
        min = Integer.MAX_VALUE;
        for (int i = 1; i < N; ++i) {
            if (map[0][i] != 0) {
                visited[i] = true;
                dfs(i, map[0][i], 1);
                visited[i] = false;
            }
        }
        System.out.println(min);
    }

    private static void dfs(int to, int w, int count) {
        if (w >= min) return;
        if (count == N - 1) {
            if (map[to][0] == 0) return;
            if (w + map[to][0] < min) min = w + map[to][0];
            return;
        }
        for (int i = 1; i < N; ++i) {
            if (!visited[i] && map[to][i] != 0) {
                visited[i] = true;
                dfs(i, w + map[to][i], count + 1);
                visited[i] = false;
            }
        }
    }
}
