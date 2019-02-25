package com.swea.D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D5_1256 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int t = 1; t <= T; ++t) {
      int K = Integer.parseInt(br.readLine());
      String str = br.readLine();
      int LENGTH = str.length();
      String[] suffixes = new String[LENGTH];
      for (int i = 0; i < LENGTH; ++i) {
        suffixes[i] = str.substring(i, LENGTH);
      }
      Arrays.sort(suffixes);
      System.out.println("#" + t + " " + suffixes[K - 1]);
    }
  }
}
