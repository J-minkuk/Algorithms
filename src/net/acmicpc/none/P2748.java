package net.acmicpc.none;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2748 {
  static long[] numbers = new long[91];

  public static long fibonacci(int n) {
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
