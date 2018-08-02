package com.algorithm.baekjoon.problem.rules;

import java.util.Scanner;

/**
 * 2007년 x월 y일 요일 구하기
 * 2007년 1월 1일 = 일요일
 *
 * 1, 3, 5, 7, 8, 10, 12월 = 31일
 *           4, 6, 9, 11월 = 30일
 *                     2월 = 28일
 */
public class P1924 {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int x = scanner.nextInt();
    int y = scanner.nextInt();

    int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    int daysTotal = 0;
    for (int i = 0; i < x - 1; ++i) {
      daysTotal += days[i];
    }
    daysTotal += y;

    switch (daysTotal % 7) {
      case 1:
        System.out.println("MON"); break;
      case 2:
        System.out.println("TUE"); break;
      case 3:
        System.out.println("WED"); break;
      case 4:
        System.out.println("THU"); break;
      case 5:
        System.out.println("FRI"); break;
      case 6:
        System.out.println("SAT"); break;
      case 0:
        System.out.println("SUN"); break;
    }

  }

}
