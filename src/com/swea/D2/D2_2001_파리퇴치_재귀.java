package com.swea.D2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D2_2001_파리퇴치_재귀 {
    static int M, N;
    static int[][] arr;
    static int max;

    static void maxAttack(int col, int row, int colN, int rowN) {
        if (colN > N || rowN > N) return;
        maxAttack(col + 1, row, colN + 1, rowN);
        maxAttack(col, row + 1, colN, rowN + 1);

        int sum = 0;
        for (int i = col; i < colN; ++i) {
            for (int j = row; j < rowN; ++j) {
                sum += arr[i][j];
            }
        }
        if (sum > max) max = sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("C:\\intelliJ_workspaces\\Algorithm\\src\\com\\swea\\TODO\\testcase\\2001input.txt"));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; ++t) {
            String[] nm = br.readLine().split(" ");
            N = Integer.parseInt(nm[0]);
            M = Integer.parseInt(nm[1]);

            // 배열 만들기
            arr = new int[N][N];
            for (int i = 0; i < N; ++i) {
                String[] vs = br.readLine().split(" ");
                for (int j = 0; j < vs.length; ++j) {
                    arr[i][j] = Integer.parseInt(vs[j]);
                }
            }

            max = Integer.MIN_VALUE;
            maxAttack(0, 0, M, M);
            System.out.println("#" + t + " " + max);
        }
    }
}
