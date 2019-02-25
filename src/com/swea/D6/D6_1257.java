package com.swea.D6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class D6_1257 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int t = 1; t <= T; ++t) {
      int K = Integer.parseInt(br.readLine());
      String str = br.readLine();
      int LENGTH = str.length();

      TreeSet<String> set = new TreeSet<>();
      for (int i = 0; i < LENGTH; ++i) {
        for (int j = i + 1; j <= LENGTH; ++j) {
          set.add(str.substring(i, j));
        }
      }

      String[] result = new String[set.size()];
      int idx = 0;
      for (String s : set) {
        result[idx++] = s;
      }

      if (result.length < K) System.out.println("#" + t + " none");
      else System.out.println("#" + t + " " + result[K - 1]);
    }
  }
}
