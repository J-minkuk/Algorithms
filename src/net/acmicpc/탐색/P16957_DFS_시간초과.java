package net.acmicpc.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P16957_DFS_시간초과 {
    static int R, C;
    static int[][] map;
    static int[][] count;
    static int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] RC = br.readLine().split(" ");
        R = Integer.parseInt(RC[0]);
        C = Integer.parseInt(RC[1]);
        map = new int[R][C];
        for (int i = 0; i < R; ++i) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < C; ++j) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        count = new int[R][C];
        for (int i = 0; i < R; ++i) {
            for (int j = 0; j < C; ++j) {
                count[i][j] = 1;
            }
        }

        for (int i = 0; i < R; ++i) {
            for (int j = 0; j < C; ++j) {
                if (count[i][j] != 0) dfs(i ,j);
            }
        }

        for (int i = 0; i < R; ++i) {
            for (int j = 0; j < C; ++j) {
                System.out.print(count[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void dfs(int r, int c) {
        boolean flag = false;
        int min = Integer.MAX_VALUE;
        int mR = -1;
        int mC = -1;
        for (int d = 0; d < 8; ++d) {
            int nR = r + dir[d][0];
            int nC = c + dir[d][1];
            if (nR < 0 || nR >= R || nC < 0 || nC >= C) continue;

            if (map[r][c] > map[nR][nC]) {
                if (min > map[nR][nC]) {
                    min = map[nR][nC];
                    mR = nR;
                    mC = nC;
                }
                flag = true;
            }
        }
        if (flag) {
            count[r][c]--;
            count[mR][mC]++;
            dfs(mR, mC);
        } else return;
    }
}
