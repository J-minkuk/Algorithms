package net.acmicpc.출력;

import java.util.Scanner;

/**
 * 별찍기 - 2
 */
@SuppressWarnings("Duplicates")
public class P2439 {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();

    for (int i = 1; i <= a; ++i) {
      for (int j = 1; j <= a - i; ++j) {
        System.out.print(" ");
      }
      for (int k = a - i; k < a; ++k) {
        System.out.print("*");
      }
      System.out.println();
    }

  }

}
