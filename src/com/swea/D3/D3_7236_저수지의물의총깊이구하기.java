package com.swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_7236_저수지의물의총깊이구하기 {
    static int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
    static String[][] map;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; ++t) {
            int N = Integer.parseInt(br.readLine());
            map = new String[N][N];
            for (int i = 0; i < N; ++i) {
                String[] s = br.readLine().split(" ");
                for (int j = 0; j < N; ++j) {
                    map[i][j] = s[j];
                }
            }

            max = Integer.MIN_VALUE;
            for (int i = 1; i < N - 1; ++i) {
                for (int j = 1; j < N - 1; ++j) {
                    if (map[i][j].equals("W")) {
                        check(i, j);
                    }
                }
            }
            if (max != 0) System.out.println("#" + t + " " + max);
            else System.out.println("#" + t + " " + 1);
        }
    }

    private static void check(int r, int c) {
        int g = 0;
        for (int d = 0; d < 8; ++d) {
            int nR = r + dir[d][0];
            int nC = c + dir[d][1];
            if (map[nR][nC].equals("G")) ++g;
        }
        if (max < (8 - g)) max = 8 - g;
    }
}
