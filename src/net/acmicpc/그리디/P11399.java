package net.acmicpc.그리디;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ATM
 */
public class P11399 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int peopleCount = scanner.nextInt();
    int[] minutes = new int[peopleCount];
    int[] sumMinutes = new int[peopleCount];

    for (int i = 0; i < peopleCount; ++i) {
      minutes[i] = scanner.nextInt();
    }
    Arrays.sort(minutes);
    sumMinutes[0] = minutes[0];

    for (int i = 1; i < peopleCount; ++i) {
      sumMinutes[i] = sumMinutes[i - 1] + minutes[i];
    }

    long minimumSum = 0;
    for (int value : sumMinutes) {
      minimumSum += value;
    }
    System.out.println(minimumSum);
  }
}
