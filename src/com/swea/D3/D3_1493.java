package com.swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_1493 {
    static int N = 1001;
    static int[][] map = new int[N][N];

    public static void main(String[] args) throws IOException {
        int value = 1;
        int idx = 1;
        while (true) {
            int i = idx;
            for (int j = 1; j <= idx; ++j) {
                map[i--][j] = value++;
            }
            ++idx;
            if (idx == N) break;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; ++t) {
            String[] s = br.readLine().split(" ");
            int p = Integer.parseInt(s[0]);
            int q = Integer.parseInt(s[1]);

            int a1 = 0;
            int b1 = 0;
            boolean flag = false;
            for (int y = 1; y < N; ++y) {
                for (int x = 1; x < N; ++x) {
                    if (map[y][x] == p) {
                        a1 = y;
                        b1 = x;
                        flag = true;
                        break;
                    }
                    if (flag) break;
                }
            }

            int a2 = 0;
            int b2 = 0;
            flag = false;
            for (int y = 1; y < N; ++y) {
                for (int x = 1; x < N; ++x) {
                    if (map[y][x] == q) {
                        a2 = y;
                        b2 = x;
                        flag = true;
                        break;
                    }
                    if (flag) break;
                }
            }

            System.out.println("#" + t + " " + map[a1 + a2][b1 + b2]);
        }
    }
}
