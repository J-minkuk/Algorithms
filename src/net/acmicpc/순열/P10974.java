package net.acmicpc.순열;

import java.util.Scanner;

public class P10974 {
  static int N;
  static boolean[] checked;
  static int[] numbers;
  static StringBuilder sb = new StringBuilder();

  private static void permutation(int index) {
    if (index == N) {
      for (int value : numbers) {
        sb.append(value + " ");
      }
      sb.append("\n");
      return;
    }
    for (int i = 1; i <= N; ++i) {
      if (!checked[i]) {
        numbers[index] = i;
        checked[i] = true;
        permutation(index + 1);
        checked[i] = false;
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    checked = new boolean[N + 1];
    numbers = new int[N];
    permutation(0);
    System.out.println(sb);
  }
}
