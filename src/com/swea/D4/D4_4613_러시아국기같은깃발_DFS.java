package com.swea.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D4_4613_러시아국기같은깃발_DFS {
    static int N, M, MIN;
    static char[][] map;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; ++t) {
            String[] NM = br.readLine().split(" ");
            N = Integer.parseInt(NM[0]);
            M = Integer.parseInt(NM[1]);
            map = new char[N][M];
            for (int i = 0; i < N; ++i) {
                map[i] = br.readLine().toCharArray();
//                System.out.println(Arrays.toString(map[i]));
            }


            MIN = Integer.MAX_VALUE;
            for (int i = 0; i < N - 2; ++i) {
                for (int j = i + 1; j < N - 1; ++j) {
                    dfs(i, j);
                }
            }

            System.out.println("#" + t + " " + MIN);
        }
    }

    private static void dfs(int w, int b) {
        int temp = 0;
        for (int i = 0; i <= w; ++i) {
            for (int j = 0; j < M; ++j) {
                if (map[i][j] != 'W') ++temp;
            }
            if (temp > MIN) return;
        }

        for (int i = w + 1; i <= b; ++i) {
            for (int j = 0; j < M; ++j) {
                if (map[i][j] != 'B') ++temp;
            }
            if (temp > MIN) return;
        }

        for (int i = b + 1; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (map[i][j] != 'R') ++temp;
            }
            if (temp > MIN) return;
        }

        if (temp < MIN) MIN = temp;
    }

}