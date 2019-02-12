package net.acmicpc.순열조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P15651 {
  static int M;
  static int N;
  static int[] numbers;
  static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] NM = br.readLine().split(" ");
    N = Integer.parseInt(NM[0]);
    M = Integer.parseInt(NM[1]);
    sb = new StringBuilder();
    numbers = new int[M];
    permutation(0);
    System.out.println(sb.toString().trim());
  }

  private static void permutation(int index) {
    if (index == M) {
      for (int v : numbers) {
        sb.append(v).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = 1; i <= N; ++i) {
      numbers[index] = i;
      permutation(index + 1);
    }
  }
}
