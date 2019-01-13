package net.acmicpc.문자열처리;

import java.util.Scanner;

/**
 * 문자열 반복
 */
public class P2675 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int testCase = scanner.nextInt();
    int[] count = new int[testCase];
    String[] strArr = new String[testCase];

    for (int i = 0; i < testCase; ++i) {
      count[i] = scanner.nextInt();
      strArr[i] = scanner.nextLine().trim();
    }

    for (int i = 0; i < testCase; ++i) {
      for (int j = 0; j < strArr[i].length(); ++j) {
        for (int k = 0; k < count[i]; ++k) {
          System.out.print(strArr[i].charAt(j));
        }
      }
      System.out.println();
    }
  }
}
