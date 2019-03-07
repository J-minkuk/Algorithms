package net.acmicpc.구현;

import java.util.Scanner;

/**
 * 별찍기 - 3
 */
public class P2440 {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();

    for (int i = a; i > 0; --i) {
      for (int j = i; j > 0; --j) {
        System.out.print("*");
      }
      System.out.println();
    }

  }

}
