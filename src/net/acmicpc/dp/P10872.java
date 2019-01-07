package net.acmicpc.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 팩토리얼 - DP
 */
public class P10872 {

  static int[] values = new int[13];

  public static int factorial(int n) {
    if (n == 0) return values[0];
    else if (n == 1) return values[1];
    else if (n == 2) return values[2];
    else if (n > 2) {
      int temp = values[n - 1];
      if (temp != 0) {
        values[n] = n * values[n - 1];
      } else {
        values[n] = n * factorial(n - 1);
      }
    }
    return values[n];
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    values[0] = 1;
    values[1] = 1;
    values[2] = 2;
    System.out.println(factorial(Integer.parseInt(br.readLine())));
  }
}
