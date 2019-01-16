package com.swea.D2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D2_1974 {
  static boolean flag;
  static int[][] sdk;
  static int[] check;

  public static void main(String[] args) throws IOException {
    BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
    BufferedReader br = new BufferedReader(new FileReader("C:\\intelliJ_workspaces\\Algorithm\\src\\com\\swea\\D2\\testcase\\1974input.txt"));
    int T = Integer.parseInt(br.readLine());
    int N = 9;

    for (int t = 1; t <= T; ++t) {
      sdk = new int[N][N];
      check = new int[N + 1];
      flag = true;

      // 스도쿠 채우기
      for (int i = 0; i < N; ++i) {
        String[] s = br.readLine().split(" ");
        for (int j = 0; j < N; ++j) {
          sdk[i][j] = Integer.parseInt(s[j]);
        }
      }

//      for (int i = 0; i < N; ++i) {
//        System.out.println(Arrays.toString(sdk[i]));
//      }

      // 가로
      for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
          check[sdk[i][j]]++;
          if (check[sdk[i][j]] > 1) {
            flag = false;
            break;
          }
        }
        for (int c = 0; c < check.length; ++c) check[c] = 0;
        if (!flag) break;
      }

      // 세로
      for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
          check[sdk[j][i]]++;
          if (check[sdk[j][i]] > 1) {
            flag = false;
            break;
          }
        }
        for (int c = 0; c < check.length; ++c) check[c] = 0;
        if (!flag) break;
      }

      // 구역
      checkSdk(0, 0);

      if (flag) System.out.println("#" + t + " 1");
      else System.out.println("#" + t + " 0");
    }
  }

  private static void checkSdk(int i, int j) {
    if (i > 8 || j > 8) return;
    else {
      for (int c = i; c < 3 + i; ++c) {
        for (int r = j; r < 3 + j; ++r) {
          check[sdk[c][r]]++;
          if (check[sdk[c][r]] > 1) {
            flag = false;
            break;
          }
        }
      }
      for (int k = 0; k < check.length; ++k) check[k] = 0;
      if (!flag) return;
      else if (flag) {
        checkSdk(i + 3, j);
        checkSdk(i, j + 3);
        checkSdk(i + 3, j + 3);
      }
    }
  }
}
