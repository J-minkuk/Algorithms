package com.swea.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D4_1227_미로2 {
    static int N = 100;
    static char[][] maze = new char[N][N];
    static int[][] dir = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };
    static int result;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for (int t = 1; t <= T; ++t) {
            int tNum = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; ++i) {
                char[] chars = br.readLine().toCharArray();
                for (int j = 0; j < N; ++j) {
                    maze[i] = chars;
                }
            }

            result = 0;
            visited = new boolean[N][N];
            dfs(1, 1);
            System.out.println("#" + tNum + " " + result);
        }
    }

    private static void dfs(int c, int r) {
        visited[c][r] = true;
        if (maze[c][r] == '3') {
            result = 1;
            return;
        }
        for (int i = 0; i < 4; ++i) {
            int nC = c + dir[i][1];
            int nR = r + dir[i][0];
            if (nC < 1 || nC > N - 1 || nR < 1 || nR > N - 1) continue;
            if (!visited[nC][nR] && maze[nC][nR] == '0' || maze[nC][nR] == '3') {
                dfs(nC, nR);
            }
        }
    }
}
