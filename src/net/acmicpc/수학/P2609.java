package net.acmicpc.수학;

import java.util.Scanner;

/**
 * 최대공약수와 최소공배수
 */
public class P2609 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int lcm = 0;
    int gcd = 1;
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    if (a <= b) {
      for (int j = 1; j <= a; ++j) {
        if (a % j == 0 && b % j == 0) {
          gcd = j;
        }
      }
    }
    else {
      for (int j = 1; j <= b; ++j) {
        if (a % j == 0 && b % j == 0) {
          gcd = j;
        }
      }
    }

    lcm = a * b / gcd;
    System.out.println(gcd);
    System.out.println(lcm);
  }
}
