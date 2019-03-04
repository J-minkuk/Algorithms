package com.swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_1873 {
    static int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; ++t) {
            String[] HW = br.readLine().split(" ");
            int H = Integer.parseInt(HW[0]);
            int W = Integer.parseInt(HW[1]);
            char[][] map = new char[H][W];
            for (int i = 0; i < H; ++i) {
                map[i] = br.readLine().toCharArray();
            }

            int sR = -1;
            int sC = -1;
            for (int i = 0; i < H; ++i) {
                if (sR != -1 && sC != -1) break;
                for (int j = 0; j < W; ++j) {
                    char c = map[i][j];
                    if (c == '<' || c == '>' || c == '^' || c == 'v') {
                        sR = i;
                        sC = j;
                        break;
                    }
                }
            }

            int dir = -1;
            switch (map[sR][sC]) {
                case '^': dir = 0; break;
                case '>': dir = 1; break;
                case 'v': dir = 2; break;
                case '<': dir = 3; break;
            }

            map[sR][sC] = '.';
            int L = Integer.parseInt(br.readLine());
            char[] cmd = br.readLine().toCharArray();
            for (int i = 0; i < L; ++i) {
                char c = cmd[i];
                switch (c) {
                    case 'S':
                        int tR = sR;
                        int tC = sC;
                        while (true) {
                            tR = tR + direction[dir][0];
                            tC = tC + direction[dir][1];
                            if (tR < 0 || tR >= H || tC < 0 || tC >= W) break;
                            char temp = map[tR][tC];
                            if (temp == '#') break;
                            if (temp == '*') {
                                map[tR][tC] = '.';
                                break;
                            }
                        }
                        break;
                    case 'U':
                        dir = 0;
                        int nR1 = sR + direction[dir][0];
                        int nC1 = sC + direction[dir][1];
                        if (nR1 < 0 || nR1 >= H || nC1 < 0 || nC1 >= W) break;
                        if (map[sR + direction[dir][0]][sC + direction[dir][1]] == '.') {
                            sR = sR + direction[dir][0];
                            sC = sC + direction[dir][1];
                        }
                        break;
                    case 'R':
                        dir = 1;
                        int nR2 = sR + direction[dir][0];
                        int nC2 = sC + direction[dir][1];
                        if (nR2 < 0 || nR2 >= H || nC2 < 0 || nC2 >= W) break;
                        if (map[sR + direction[dir][0]][sC + direction[dir][1]] == '.') {
                            sR = sR + direction[dir][0];
                            sC = sC + direction[dir][1];
                        }
                        break;
                    case 'L':
                        dir = 3;
                        int nR3 = sR + direction[dir][0];
                        int nC3 = sC + direction[dir][1];
                        if (nR3 < 0 || nR3 >= H || nC3 < 0 || nC3 >= W) break;
                        if (map[sR + direction[dir][0]][sC + direction[dir][1]] == '.') {
                            sR = sR + direction[dir][0];
                            sC = sC + direction[dir][1];
                        }
                        break;
                    case 'D':
                        dir = 2;
                        int nR4 = sR + direction[dir][0];
                        int nC4 = sC + direction[dir][1];
                        if (nR4 < 0 || nR4 >= H || nC4 < 0 || nC4 >= W) break;
                        if (map[sR + direction[dir][0]][sC + direction[dir][1]] == '.') {
                            sR = sR + direction[dir][0];
                            sC = sC + direction[dir][1];
                        }
                        break;
                }
            }

            switch (dir) {
                case 0: map[sR][sC] = '^'; break;
                case 1: map[sR][sC] = '>'; break;
                case 2: map[sR][sC] = 'v'; break;
                case 3: map[sR][sC] = '<'; break;
            }

            System.out.print("#" + t + " ");
            for (int i = 0; i < H; ++i) {
                for (int j = 0; j < W; ++j) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
        }
    }
}
