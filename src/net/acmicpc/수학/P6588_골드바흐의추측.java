package net.acmicpc.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 숫자의 제곱근까지만 약수의 여부를 검증하면 된다. (n / 2)
 */
public class P6588_골드바흐의추측 {
  static int n;
  static int[] result;
  static boolean flag;
  static boolean[] isPrime;
  static int MAX = 1000000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 최초 1번만 만든다.
    isPrime = new boolean[MAX + 1];
    for (int i = 2; i <= MAX; ++i) {
      isPrime[i] = true;
    }

    for (int i = 2; (i * i) <= MAX; ++i) {
      if (isPrime[i]) {
        for (int j = (i * i); j <= MAX; j += i) {
          isPrime[j] = false;
        }
      }
    }

    while (true) {
      n = Integer.parseInt(br.readLine());
      if (n == 0) break;

      result = new int[2];
      flag = false;

      for (int i = 2; i <= n / 2; ++i) {
        if (isPrime[i] && isPrime[n - i]) {
          System.out.printf("%d = %d + %d\n", n, i, (n - i));
          flag = true;
          break;
        }
      }
      if (!flag) System.out.println("Goldbach's conjecture is wrong.");
    }
  }
}
