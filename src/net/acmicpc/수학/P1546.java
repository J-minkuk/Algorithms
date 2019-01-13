package net.acmicpc.수학;

import java.util.Scanner;

/**
 * 평균
 */
public class P1546 {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int count = scanner.nextInt();
    int sum = 0;
    int maxScore = 0;

    for (int i = 0; i < count; ++i) {
      int score = scanner.nextInt();
      sum += score;
      if (score > maxScore) {
        maxScore = score;
      }
    }

    double average = 100.0 * sum / maxScore / count;
    System.out.format("%.2f", average);

  }

}
