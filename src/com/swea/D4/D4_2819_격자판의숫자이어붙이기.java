package com.swea.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class D4_2819_격자판의숫자이어붙이기 {
    static int[][] board = new int[4][4];
    static HashSet<Integer> set = new HashSet<>();
    static int[][] dir = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; ++t) {

            for (int i = 0; i < 4; ++i) {
                String[] str = br.readLine().split(" ");
                for (int j = 0; j < 4; ++j) {
                    board[i][j] = Integer.parseInt(str[j]);
                }
            }

            set.clear();
            for (int i = 0; i < 4; ++i) {
                for (int j = 0; j < 4; ++j) {
                    dfs(i, j, board[i][j], 0);
                }
            }
            System.out.println("#" + t + " " + set.size());
        }
    }

    private static void dfs(int c, int r, int number, int count) {
        if (count == 6) {
            set.add(number);
            return;
        }
        for (int i = 0; i < 4; ++i) {
            int nC = c + dir[i][0];
            int nR = r + dir[i][1];
            if (nC < 0 || nC >= 4 || nR < 0 || nR >= 4) continue;
            dfs(nC, nR, number * 10 + board[nC][nR], count + 1);
        }
    }
}
