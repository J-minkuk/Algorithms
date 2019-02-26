package com.swea.D6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D6_1263 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int t = 1; t <= T; ++t) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int NWT[][] = new int[N][N];
      int[] cc = new int[N];

      for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
          NWT[i][j] = Integer.parseInt(st.nextToken());
          if (i != j && NWT[i][j] == 0) NWT[i][j] = 9999999;
        }
      }

      for (int v = 0; v < N; ++v) {
        for (int i = 0; i < N; ++i) {
          for (int j = 0; j < N; ++j) {
            NWT[i][j] = Math.min(NWT[i][j], NWT[i][v] + NWT[v][j]);
          }
        }
      }

      int result = Integer.MAX_VALUE;
      for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
          cc[i] += NWT[i][j];
        }
        result = Math.min(result, cc[i]);
      }
      System.out.println("#" + t + " " + result);
    }
  }
}
