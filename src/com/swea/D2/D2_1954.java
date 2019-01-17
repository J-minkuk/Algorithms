package com.swea.D2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D2_1954 {
  public static void main(String[] args) throws IOException {
    BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
    BufferedReader br = new BufferedReader(new FileReader("C:\\intelliJ_workspaces\\Algorithm\\src\\com\\swea\\D2\\testcase\\1954input.txt"));
    int T = Integer.parseInt(br.readLine());
    for (int t = 1; t <= T; ++t) {
      int N = Integer.parseInt(br.readLine());
      int V = N * N;
      int[][] arr = new int[N][N];

      String dir = "R";
      int i = 0, j = 0, v = 1;

      while (v <= V) {
        arr[i][j] = v++;
        switch (dir) {
          case "R":
            j++;
            if (j == N - 1) dir = "D";
            if (j < N && arr[i][j] != 0) {
              j--;
              i++;
              dir = "D";
            }
            break;
          case "L":
            j--;
            if (j == 0) dir = "U";
            if (j >= 0 && arr[i][j] != 0) {
              j++;
              i--;
              dir = "U";
            }
            break;
          case "U":
            i--;
            if (i == 0) dir = "R";
            if (i >= 0 && arr[i][j] != 0) {
              i++;
              j++;
              dir = "R";
            }
            break;
          case "D":
            i++;
            if (i == N - 1) dir = "L";
            if (i < N && arr[i][j] != 0) {
              i--;
              j--;
              dir = "L";
            }
            break;
        }
      }

      System.out.println("#" + t);
      for (int c = 0; c < N; ++c) {
        for (int r = 0; r < N; ++r) {
          System.out.print(arr[c][r] + " ");
        }
        System.out.println();
      }
    }
  }
}
