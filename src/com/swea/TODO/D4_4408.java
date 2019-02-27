package com.swea.TODO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D4_4408 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine().trim());
    for (int t = 1; t <= T; ++t) {
      int N = Integer.parseInt(br.readLine().trim());  // 학생수
      int[][] room = new int[N + 1][2];
      int[] count = new int[201];
      for (int i = 1; i <= N; ++i) {
        String[] str = br.readLine().split(" ");
        room[i][0] = Integer.parseInt(str[0]);
        room[i][1] = Integer.parseInt(str[1]);
      }

      for (int i = 1; i <= N; ++i) {
        int idx1 = (room[i][0] + 1) / 2; // >> 나누기 2와 같다.
        int idx2 = (room[i][1] + 1) / 2;
        int big = idx1 > idx2 ? idx1 : idx2;
        int small = idx1 < idx2 ? idx1 : idx2;
        for (int v = small; v <= big; ++v) {
          ++count[v];
        }
      }

      int max = Integer.MIN_VALUE;
      for (int c : count) {
        max = c > max ? c : max;
      }
      System.out.println("#" + t + " " + max);
    }
  }
}
