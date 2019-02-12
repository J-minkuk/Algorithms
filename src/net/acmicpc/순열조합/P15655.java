package net.acmicpc.순열조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P15655 {
  static int M;
  static int N;
  static int[] numbers;
  static int[] result;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] NM = br.readLine().split(" ");
    N = Integer.parseInt(NM[0]);
    M = Integer.parseInt(NM[1]);

    numbers = new int[N];
    result = new int[M];
    String[] num = br.readLine().split(" ");
    for (int i = 0; i < N; ++i) {
      numbers[i] = Integer.parseInt(num[i]);
    }

    Arrays.sort(numbers);
    combination(0, 0);
  }

  private static void combination(int count, int valueIndex) {
    if (count == M) {
      for (int i = 0; i < result.length; ++i) {
        System.out.print(result[i] + " ");
      }
      System.out.println();
      return;
    }

    for (int i = valueIndex; i < N; ++i) {
      result[count] = numbers[i];
      combination(count + 1, i + 1);
    }
  }
}
