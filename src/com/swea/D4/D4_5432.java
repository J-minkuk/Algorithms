package com.swea.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D4_5432 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int t = 1; t <= T; ++t) {
      String s = br.readLine();
      int size = 0;
      int total = 0;
      for (int i = 0; i < s.length(); ++i) {
        switch (s.charAt(i)) {
          case '(':
            ++size;
            break;
          case ')':
            if (s.charAt(i - 1) == '(') {
              --size;
              total += size;
            } else if (s.charAt(i - 1) == ')') {
              --size;
              total += 1;
            }
            break;
        }
      }
      System.out.println("#" + t + " " + total);
    }
  }
}
