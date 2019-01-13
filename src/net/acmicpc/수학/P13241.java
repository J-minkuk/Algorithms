package net.acmicpc.수학;

import java.util.Scanner;

/**
 * 최소공배수
 */
@SuppressWarnings("Duplicates")
public class P13241 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    long lcm = 0;
    long gcd = 1;
    long a = scanner.nextLong();
    long b = scanner.nextLong();

    if (a <= b) {
      for (long j = 1; j <= a; ++j) {
        if (a % j == 0 && b % j == 0) {
          gcd = j;
        }
      }
    }
    else {
      for (long j = 1; j <= b; ++j) {
        if (a % j == 0 && b % j == 0) {
          gcd = j;
        }
      }
    }

    lcm = a * b / gcd;
    System.out.println(lcm);
  }
}
