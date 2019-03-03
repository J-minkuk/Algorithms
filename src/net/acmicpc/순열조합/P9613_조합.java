package net.acmicpc.순열조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P9613_조합 {
  static int N;
  static int[] numbers;
  static int[] result;
  static long sum;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int t = 1; t <= T; ++t) {
      String[] line = br.readLine().split(" ");
      N = Integer.parseInt(line[0]);
      numbers = new int[N];
      for (int i = 0; i < N; ++i) {
        numbers[i] = Integer.parseInt(line[i + 1]);
      }

      result = new int[2];
      sum = 0;
      Arrays.sort(numbers);
      combination(0, 0);
      System.out.println(sum);
    }
  }

  private static void combination(int count, int valueIndex) {
    if (count == 2) {
      int a = result[0];
      int b = result[1];
      int gcd = 0;
      for (int i = a; i > 0; --i) {
        if (a % i == 0 && b % i == 0) {
          gcd = i;
          break;
        }
      }
      sum += gcd;
      return;
    }

    for (int i = valueIndex; i < N; ++i) {
      result[count] = numbers[i];
      combination(count + 1, i + 1);
    }
  }
}
