package net.acmicpc.순열조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P15652_순열 {
  static int M;
  static int N;
  static int[] numbers;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] NM = br.readLine().split(" ");
    N = Integer.parseInt(NM[0]);
    M = Integer.parseInt(NM[1]);

    numbers = new int[M];
    permutation(0);
  }

  private static void permutation(int index) {
    if (index == M) {
      boolean flag = true;
      for (int i = 0; i < numbers.length - 1; ++i) {
        if (numbers[i] > numbers[i + 1]) flag = false;
      }

      if (flag) {
        for (int v : numbers) {
          System.out.print(v + " ");
        }
        System.out.println();
      }
      return;
    }

    for (int i = 1; i <= N; ++i) {
      numbers[index] = i;
      permutation(index + 1);
    }
  }
}
