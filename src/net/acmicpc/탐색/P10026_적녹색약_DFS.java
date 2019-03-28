package net.acmicpc.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10026_적녹색약_DFS {
    private static int N, count1, count2;
    private static char[][] map;
    private static boolean[][] visited1;
    private static boolean[][] visited2;
    private static int dir[][] = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        map = new char[N][N];
        visited1 = new boolean[N][N];
        visited2 = new boolean[N][N];
        for (int i = 0; i < N; ++i) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (!visited1[i][j]) {
                    dfs1(i, j, map[i][j]);
                    ++count1;
                }
            }
        }

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (map[i][j] == 'R') map[i][j] = 'G';
            }
        }

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (!visited2[i][j]) {
                    dfs2(i, j, map[i][j]);
                    ++count2;
                }
            }
        }
        System.out.println(count1 + " " + count2);
    }

    private static void dfs1(int r, int c, char v) {
        visited1[r][c] = true;
        for (int d = 0; d < 4; ++d) {
            int nR = r + dir[d][0];
            int nC = c + dir[d][1];
            if (nR < 0 || nC < 0 || nR >= N || nC >= N) continue;
            if (!visited1[nR][nC] && map[nR][nC] == v) dfs1(nR, nC, map[nR][nC]);
        }
    }

    private static void dfs2(int r, int c, char v) {
        visited2[r][c] = true;
        for (int d = 0; d < 4; ++d) {
            int nR = r + dir[d][0];
            int nC = c + dir[d][1];
            if (nR < 0 || nC < 0 || nR >= N || nC >= N) continue;
            if (!visited2[nR][nC] && map[nR][nC] == v) dfs2(nR, nC, map[nR][nC]);
        }
    }
}
