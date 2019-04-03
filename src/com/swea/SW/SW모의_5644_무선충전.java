package com.swea.SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW모의_5644_무선충전 {
    static int M, A;
    static int[] mA, mB;
    static int[][] BC;
    static boolean[] checkA, checkB;
    static int[][] dir = {
            {0, 0}, {0, -1}, {1, 0}, {0, 1}, {-1, 0}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; ++t) {
            String[] MA = br.readLine().split(" ");
            M = Integer.parseInt(MA[0]);    // 이동시간
            A = Integer.parseInt(MA[1]);    // BC의 개수

            // 사용자 이동 정보
            mA = new int[M];
            String[] sA = br.readLine().split(" ");
            for (int i = 0; i < M; ++i) {
                mA[i] = Integer.parseInt(sA[i]);
            }
            mB = new int[M];
            String[] sB = br.readLine().split(" ");
            for (int i = 0; i < M; ++i) {
                mB[i] = Integer.parseInt(sB[i]);
            }

            BC = new int[A][4]; // 열,행,C,P
            for (int i = 0; i < A; ++i) {
                String[] s = br.readLine().split(" ");
                BC[i][0] = Integer.parseInt(s[0]);  // 열
                BC[i][1] = Integer.parseInt(s[1]);  // 행
                BC[i][2] = Integer.parseInt(s[2]);  // C
                BC[i][3] = Integer.parseInt(s[3]);  // P
            }

            int cax = 1, cay = 1;
            int cbx = 10, cby = 10;

            int result = 0;
            for (int i = 0; i <= M; ++i) {
                checkA = new boolean[A];
                checkB = new boolean[A];
                if (i > 0) {
                    cax += dir[mA[i - 1]][0];
                    cay += dir[mA[i - 1]][1];
                    cbx += dir[mB[i - 1]][0];
                    cby += dir[mB[i - 1]][1];
                }

                for (int j = 0; j < A; ++j) {
                    int[] AP = BC[j];
                    int X = AP[0];
                    int Y = AP[1];
                    int C = AP[2];
                    if (Math.abs(X - cax) + Math.abs(Y - cay) <= C) checkA[j] = true;
                    if (Math.abs(X - cbx) + Math.abs(Y - cby) <= C) checkB[j] = true;
                }
//                System.out.println("checkA: " + i + "초 " + Arrays.toString(checkA));
//                System.out.println("checkB: " + i + "초 " + Arrays.toString(checkB));

                int max = 0;
                for (int j = 0; j < A; ++j) {
                    for (int k = 0; k < A; ++k) {
                        int temp = 0;
                        if (checkA[j] && checkB[k] && j == k) temp = BC[j][3];
                        else if (checkA[j] && checkB[k] && j != k) temp = BC[j][3] + BC[k][3];
                        else {
                            if (checkA[j]) temp = BC[j][3];
                            if (checkB[k]) temp = BC[k][3];
                        }
                        max = Math.max(max, temp);
                    }
                }
//                System.out.println(max);
//                System.out.println();
                result += max;
            }

            System.out.println("#" + t + " " + result);
        }
    }
}
