package com.swea.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D2_1966 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int t = 1; t <= T; ++t) {
      int N = Integer.parseInt(br.readLine());
      int[] numbers = new int[N];
      String[] str = br.readLine().split(" ");
      for (int i = 0; i < str.length; ++i) {
        numbers[i] = Integer.parseInt(str[i]);
      }
      Arrays.sort(numbers);
      System.out.print("#" + t + " ");
      for (int v : numbers) {
        System.out.print(v + " ");
      }
      System.out.println();
    }
  }
}
