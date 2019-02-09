package com.swea.D3;

import java.io.*;

public class D3_2805 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int T = Integer.parseInt(br.readLine());
    for (int t = 1; t <= T; ++t) {
      int N = Integer.parseInt(br.readLine());
      int[][] arr = new int[N][N];
      for (int n = 0; n < N; ++n) {
        String str = br.readLine();
        for (int i = 0; i < str.length(); ++i) {
          arr[n][i] = str.charAt(i) - '0';
        }
      }

      int mid = N / 2;
      int sum = 0;
      for (int i = 0; i < N; ++i) {
        int start = (mid - i) > 0 ? mid - i : (mid - i) * (-1);
        for (int j = start; j < (N - start); ++j) {
          sum += arr[i][j];
        }
      }
      bw.write("#" + t + " " + sum + "\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }
}
