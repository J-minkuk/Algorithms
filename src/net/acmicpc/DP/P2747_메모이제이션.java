package net.acmicpc.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 피보나치 - DP
 */
public class P2747_메모이제이션 {

  static int[] numbers = new int[46];

  public static int fibonacci(int n) {
    if (n == 0) return numbers[n];
    if (n < 2) return numbers[n];
    else {
      if (numbers[n - 1] != 0 && numbers[n - 2] != 0) {
        numbers[n] = numbers[n - 1] + numbers[n - 2];
      } else if (numbers[n - 1] != 0) {
        numbers[n] = numbers[n - 1] + fibonacci(n - 2);
      } else if (numbers[n - 2] != 0) {
        numbers[n] = fibonacci(n - 1) + numbers[n - 2];
      } else {
        numbers[n] = fibonacci(n - 1) + fibonacci(n - 2);
      }
      return numbers[n];
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    numbers[0] = 0;
    numbers[1] = 1;
    System.out.println(fibonacci(Integer.parseInt(br.readLine())));
  }
}
