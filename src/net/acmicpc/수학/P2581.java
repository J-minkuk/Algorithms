package net.acmicpc.수학;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 소수
 */
public class P2581 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int m = scanner.nextInt();
    int n = scanner.nextInt();

    List<Integer> primeList = new ArrayList<>();
    for (int i = m; i <= n; ++i) {
      boolean flag = true;
      for (int j = 2; j < i; ++j) {
        if (i % j == 0) {
          flag = false;
          break;
        }
      }
      if (i == 1) flag = false;
      if (flag) primeList.add(i);
    }

    int sum = 0;
    for (int value : primeList) {
      sum += value;
    }

    if (primeList.isEmpty()) {
      System.out.println(-1);
    }
    else {
      System.out.println(sum);
      System.out.println(primeList.get(0));
    }
  }
}
