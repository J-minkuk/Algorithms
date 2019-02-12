package com.swea.TODO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_1216 {
  private static char[] chars;
  private static int length;
  private static int max;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = 1;
    for (int t = 1; t <= T; ++t) {
      br.readLine();
      String str = br.readLine();
      chars = str.toCharArray();
      length = 0;
      max = 0;

      for (int i = 0; i < str.length(); ++i) {
        check(i, chars.length - 1);
      }
      System.out.println("#" + t + " " + max);
    }
  }

  private static void check(int i, int j) {
    if (i >= j) {
      if (length > max) max = length;
    }
    else if (chars[i] == chars[j]) {
      System.out.println(chars[i] + " " + chars[j]);
      ++length;
      check(i + 1, j - 1);
    } else {
      length = 0;
      check(i, j - 1);
    }

  }
}
