package kakao;

import java.util.Scanner;

/**
 * 인형들
 */
public class B2018 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int testCase = scanner.nextInt();
    int countRange = scanner.nextInt();
    int[] persons = new int[testCase];

    for (int i = 0; i < testCase; ++i) {
      persons[i] = scanner.nextInt();
    }

    double minVariance = Double.MAX_VALUE;

    for (int i = 0; i <= testCase - countRange; ++i) {
      double average = 0.0;    // 평균
      double variance = 0.0;   // 분산
      double sum = 0.0;
      double sumForVariance = 0.0;

      for (int j = i; j < i + countRange; ++j) {
        sum += persons[j];
      }
      average = sum / countRange;

      for (int j = i; j < i + countRange; ++j) {
        double distance = persons[j] - average;
        sumForVariance += distance * distance;
      }
      variance = sumForVariance / countRange;
      if (variance < minVariance) {
        minVariance = variance;
      }
    }

    double stdDeviation = Math.sqrt(minVariance);
    stdDeviation = Math.floor(stdDeviation * 100000000000d) / 100000000000d;
    System.out.format("%.11f\n", stdDeviation);
  }
}
