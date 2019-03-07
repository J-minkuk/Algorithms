package net.acmicpc.시뮬레이션;

import java.util.Scanner;

/**
 * 평균 점수
 */
public class P10039 {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int[] scores = new int[5];
    int total = 0;
    int average = 0;
    int numbers = scores.length;
    for (int i = 0; i < numbers; ++i) {
      scores[i] = scanner.nextInt();
    }

    for (int i = 0; i < numbers; ++i) {
      if (scores[i] < 40) {
        total += 40;
      }
      else {
        total += scores[i];
      }
    }

    average = total / numbers;
    System.out.println(average);

  }

}
