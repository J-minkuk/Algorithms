package net.acmicpc.수학;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 에라토스테네스의 체
 */
public class P1929_에라토스테네스의체 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int m = scanner.nextInt();
    int n = scanner.nextInt();

    List<Boolean> numbers = new ArrayList<>();
    numbers.add(false);
    numbers.add(false);

    for (int i = 2; i <= n; ++i) {
      numbers.add(i, true);
    }

    for (int i = 2; (i * i) <= n; ++i) {
      if (numbers.get(i)) {
        for (int j = (i * i); j <= n; j += i) {
          numbers.set(j, false);
        }
      }
    }

    List<Integer> primeList = new ArrayList<>();
    for (int i = m; i < numbers.size(); ++i) {
      if (numbers.get(i)) {
        primeList.add(i);
      }
    }

    for (int value : primeList) {
      System.out.println(value);
    }

  }
}
