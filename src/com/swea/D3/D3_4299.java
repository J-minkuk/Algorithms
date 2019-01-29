package com.swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_4299 {
  // D * 24 * 60
  // H * 60
  static int TIME = 15840 + 660 + 11;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int t = 1; t <= T; ++t) {
      String[] DHM = br.readLine().split(" ");
      int d = Integer.parseInt(DHM[0]);
      int h = Integer.parseInt(DHM[1]);
      int m = Integer.parseInt(DHM[2]);
      int time = (d * 24 * 60) + (h * 60) + m;

      int sub = time - TIME;
      System.out.println("#" + t + " " + (sub >= 0 ? sub : -1));
    }
  }
}
