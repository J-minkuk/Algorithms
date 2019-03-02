package net.acmicpc.순열조합;

import java.util.Scanner;

public class P15649_순열 {
  static int N;
  static int R;
  static boolean[] checked;
  static int[] numbers;
  static StringBuilder sb = new StringBuilder();

  private static void permutation(int index) {
    if (index == R) {
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
    R = sc.nextInt();
    checked = new boolean[N + 1];
    numbers = new int[R];
    permutation(0);
    System.out.println(sb);
  }
}
