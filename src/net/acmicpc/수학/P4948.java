package net.acmicpc.수학;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 베르트랑 공준
 */
public class P4948 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      int input = scanner.nextInt();
      if (input == 0) break;

      List<Boolean> numbers = new ArrayList<>();
      numbers.add(false);
      numbers.add(false);

      for (int i = 2; i <= (2 * input); ++i) {
        numbers.add(i, true);
      }

      for (int i = 2; (i * i) <= (2 * input); ++i) {
        if (numbers.get(i)) {
          for (int j = (i * i); j <= (2 * input); j += i) {
            numbers.set(j, false);
          }
        }
      }
      int count = 0;
      for (int i = input + 1; i < numbers.size(); ++i) {
        if (numbers.get(i)) {
          count++;
        }
      }
      System.out.println(count);
    }

  }
}
