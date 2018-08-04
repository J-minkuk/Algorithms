package com.algorithm.baekjoon.problem.array;

import java.util.*;

/**
 * 접미사 배열
 */
public class P11656 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String s = scanner.nextLine();
    String[] arr = new String[s.length()];

    makeAllCaseSuffix(arr, s);
    Arrays.sort(arr);

    for (String str : arr) {
      System.out.println(str);
    }
  }

  private static void makeAllCaseSuffix(String[] arr, String str) {
    int length = str.length();
    for (int i = 0; i < length; ++i) {
      arr[i] = (str.substring(i, length));
    }
  }
}
