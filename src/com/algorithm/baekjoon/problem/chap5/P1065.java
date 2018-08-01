package com.algorithm.baekjoon.problem.chap5;

import java.util.Scanner;

/**
 * 한수
 *
 * 1~99까지는 모두 한수로 처리하는 듯하다. => 99개
 * 100 이상인 것부터 한수인지 따져보면 되겠다.
 */
public class P1065 {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int count = 0;

    if (n < 100) {
      count = n;
      System.out.println(count);
    }
    else {
      count = 99;
      for (int i = 100; i <= n; ++i) {
        count += numberCheck(i);
      }
      if (n == 1000) count--;
      System.out.println(count);
    }

  }

  static int numberCheck(int number) {
    // TODO first에 '% 10'이 있고 없고 무슨 차이지 ??
    int first = number / 100 % 10;
    int second = number / 10 % 10;
    int third = number % 10;

    if (second * 2 == first + third) {
      return 1;
    }
    return 0;
  }

}
