package com.swea.D2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class D2_1961_숫자배열회전 {
    public static void main(String[] args) throws IOException {
        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("C:\\intelliJ_workspaces\\Algorithm\\src\\com\\swea\\D2\\testcase\\1961input.txt"));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; ++t) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];

            // 숫자 배열 완성
            for (int i = 0; i < N; ++i) {
                String[] s = br.readLine().split(" ");
                for (int j = 0; j < N; ++j) {
                    arr[i][j] = Integer.parseInt(s[j]);
                }
            }


            System.out.println("#" + t);
            for (int j = 0; j < N; ++j) {
                // 90도
                for (int i = N - 1; i >= 0; --i) {
                    System.out.print(arr[i][j]);
                    if (i == 0) System.out.print(" ");
                }

                // 180도
                for (int i = N - 1; i >= 0; --i) {
                    System.out.print(arr[N - j - 1][i]);
                    if (i == 0) System.out.print(" ");
                }

                // 270도
                for (int i = 0; i < N; ++i) {
                    System.out.print(arr[i][N - j - 1]);
                    if (i == N - 1) System.out.print(" ");
                }
                System.out.println();
            }
        }
    }
}
