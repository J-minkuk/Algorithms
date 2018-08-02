package com.algorithm.baekjoon.problem.array;

import java.util.Scanner;

/**
 * OX 퀴즈
 */
public class P8958 {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int testCase = scanner.nextInt();

    String[] strArr = new String[testCase];
    int[] numArr = new int[testCase];
    int score = 0;

    for (int i = 0; i < testCase; ++i) {
      strArr[i] = scanner.next();
    }

    for (int i = 0; i < strArr.length; ++i) {
      score = 0;
      for (int j = 0; j < strArr[i].length(); ++j) {
        if (strArr[i].charAt(j) == 'O') {
          numArr[i] += ++score;
        }
        else {
          score = 0;
        }
      }
    }

    for (int value : numArr) {
      System.out.println(value);
    }

  }

}
