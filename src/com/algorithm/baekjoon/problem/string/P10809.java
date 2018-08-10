package com.algorithm.baekjoon.problem.string;

import java.util.Scanner;

/**
 * 알파벳 찾기
 */
public class P10809 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String str = scanner.nextLine().trim().toLowerCase();

    String[] arr = { "a", "b", "c", "d", "e",
                     "f", "g", "h", "i", "j",
                     "k", "l", "m", "n", "o",
                     "p", "q", "r", "s", "t",
                     "u", "v", "w", "x", "y", "z" };

    for (int i = 0; i < arr.length; ++i) {
      arr[i] = String.valueOf(str.indexOf(arr[i]));
    }

    for (String s : arr) {
      System.out.print(s + " ");
    }

  }
}
