package com.algorithm.baekjoon.problem.sort;

import java.util.Scanner;

/**
 * 소트인사이드
 */
public class P1427 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    String s = Integer.toString(n);
    int[] arr = new int[s.length()];

    for (int i = 0; i < s.length(); ++i) {
      arr[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
    }

    for (int i = 0; i < arr.length - 1; ++i) {
      for (int j = 0; j < arr.length - 1; ++j) {
        if (arr[j] < arr[j + 1]) {
          swap(arr, j, j + 1);
        }
      }
    }

    for (int i = 0; i < arr.length; ++i) {
      System.out.print(arr[i]);
    }
  }

  static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
