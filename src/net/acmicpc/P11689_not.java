package net.acmicpc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * GCD(n, k) = 1
 *
 * TODO 시간복잡도를 줄여야하는데 너무 어려움
 */
public class P11689_not {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

    List<Integer> divisorsN = new ArrayList<>();
    for (int i = 1; i <= n; ++i) {
      if (n % i == 0) divisorsN.add(i);
    }

    int count = 0;
    for (int i = 2; i <= n; ++i) {
      boolean flag = true;
      for (int j = 1; j < divisorsN.size(); ++j) {
        if (i % divisorsN.get(j) == 0) flag = false;
      }
      if (flag) count++;
    }
    System.out.println(count + 1);
  }
}
