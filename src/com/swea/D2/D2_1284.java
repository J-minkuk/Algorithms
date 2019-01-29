package com.swea.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D2_1284 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int t = 1; t <= T; ++t) {
      String[] str = br.readLine().split(" ");
      int P = Integer.parseInt(str[0]);
      int Q = Integer.parseInt(str[1]);
      int R = Integer.parseInt(str[2]);
      int S = Integer.parseInt(str[3]);
      int W = Integer.parseInt(str[4]);

      int feeA = P * W;
      int feeB = 0;
      if (W <= R) feeB = Q;
      else feeB = Q + (W - R) * S;

      System.out.println("#" + t + " " + (feeA > feeB ? feeB : feeA));
    }
  }
}
