package com.swea.D6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D6_1263 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int t = 1; t <= 1; ++t) {
      String[] str = br.readLine().split(" ");
      int N = Integer.parseInt(str[0]);
      int[][] NWK = new int[N][N];
      int idx = 1;
      for (int i = 0; i < N; ++i) {
        for (int j = 0; j < N; ++j) {
          NWK[i][j] = Integer.parseInt(str[idx++]);
        }
      }

      // 절반만 신경쓰면됨
      for (int i = 0; i < N; ++i) {
        System.out.println(Arrays.toString(NWK[i]));
      }

    }
  }
}
