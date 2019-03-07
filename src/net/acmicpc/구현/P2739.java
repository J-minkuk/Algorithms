package net.acmicpc.구현;

import java.util.Scanner;

/**
 * 구구단
 */
public class P2739 {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();

    for (int i = 1; i < 10; ++i) {
      System.out.format("%d * %d = %d\n", a, i, a * i);
    }

  }

}
