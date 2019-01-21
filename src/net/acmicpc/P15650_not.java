package net.acmicpc;

import java.util.Scanner;

public class P15650_not {
  static int N;
  static int M;
  static int[] numbers;
  static boolean[] check;

  private static void permutation(int index) {
    if (index == M) {
      for (int i = 0; i < M - 1; ++i) {
        if (i == M - 1) {
          for (int v : numbers) {
            System.out.print(v + " ");
          }
          System.out.println();
        }
      }
      return;
    }
    for (int i = 1; i <= N; ++i) {
      if (!check[i]) {
        numbers[index] = i;
        check[i] = true;
        permutation(index + 1);
        check[i] = false;
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    M = sc.nextInt();
    numbers = new int[M];
    check = new boolean[N + 1];
    permutation(0);
  }
}
