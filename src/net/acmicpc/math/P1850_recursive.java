package net.acmicpc.math;

import java.util.Scanner;

/**
 * 최대공약수 (재귀함수)
 *
 * 이렇게 구하는 방법까지 알아야 하나
 * 수학 싫어하면 생각 못 할 것 같다.
 *
 * 최대공약수 구하는 법
 * : 두 수 a, b의 대소 관계와 상관없이 계속해서 서로를 나누는 과정을 반복한다.
 * : 나머지가 0이 되는 순간에 나누는 그 특정 숫자가 최대공약수가 된다.
 *
 * 최소공배수 구하는 법
 * : 두 수 a, b를 곱한다.
 * : 최대공약수로 나눈다. 결과가 바로 최소공배수다.
 */
public class P1850_recursive {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    long aCount = scanner.nextLong();
    long bCount = scanner.nextLong();
    long gcd = gcd(aCount, bCount);

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < gcd; ++i) {
      sb.append(1);
    }
    System.out.println(sb.toString());

  }

  static long gcd(long a, long b) {
    if (a == 0) {
      return b;
    }
    return gcd(b % a, a);
  }
}
