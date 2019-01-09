package net.acmicpc.수학;

import java.util.Scanner;

/**
 * 소수 찾기
 */
public class P1978 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int testCase = scanner.nextInt();
    int[] numbers = new int[testCase];
    for (int i = 0; i < testCase; ++i) {
      numbers[i] = scanner.nextInt();
    }

    int count = 0;
    for (int i = 0; i < testCase; ++i) {
      boolean flag = true;
      if (numbers[i] == 1) flag = false;
      for (int j = 2; j < numbers[i]; ++j) {
        if (numbers[i] % j == 0) flag = false;
      }
      if (flag) count++;
    }
    System.out.println(count);
  }
}
