package com.swea.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D4_1868_파핑파핑지뢰찾기_DFS {
    static int N;
    static int[][] map;
    static int[][] dir = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; ++t) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            for (int i = 0; i < N; ++i) {
                String s = br.readLine();
                for (int j = 0; j < N; ++j) {
                    if (s.charAt(j) == '*') map[i][j] = -1;
                }
            }

//            for (int i = 0; i < N; ++i) {
//                System.out.println(Arrays.toString(map[i]));
//            }
//            System.out.println();

            for (int r = 0; r < N; ++r) {
                for (int c = 0; c < N; ++c) {
                    if (map[r][c] == -1) continue;

                    int count = 0;
                    for (int d = 0; d < 8; ++d) {
                        int nR = r + dir[d][0];
                        int nC = c + dir[d][1];
                        if (nR >= 0 && nR < N && nC >= 0 && nC < N && map[nR][nC] == -1) ++count;
                    }
                    map[r][c] = count;
                }
            }

//            for (int i = 0; i < N; ++i) {
//                System.out.println(Arrays.toString(map[i]));
//            }
//            System.out.println();

            int result = 0;
            for (int r = 0; r < N; ++r) {
                for (int c = 0; c < N; ++c) {
                    if (map[r][c] == 0) {
                        dfs(r, c);
                        ++result;
                    }
                }
            }

//            for (int i = 0; i < N; ++i) {
//                System.out.println(Arrays.toString(map[i]));
//            }
//            System.out.println();

            for (int r = 0; r < N; ++r) {
                for (int c = 0; c < N; ++c) {
                    if (map[r][c] != -1) ++result;
                }
            }
            System.out.println("#" + t + " " + result);
        }
    }

    private static void dfs(int r, int c) {
        map[r][c] = -1;
        for (int d = 0; d < 8; ++d) {
            int nR = r + dir[d][0];
            int nC = c + dir[d][1];
            if (nR >= 0 && nR < N && nC >= 0 && nC < N) {
                if (map[nR][nC] == 0) dfs(nR, nC);
                else map[nR][nC] = -1;
            }
        }
    }
}
