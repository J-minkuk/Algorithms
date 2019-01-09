package net.acmicpc.none;

import java.util.*;

/**
 * 통계학
 *
 * 단, N은 홀수라고 가정한다.
 *
 * (뭔가 되게 지저분하게 코딩했다...)
 */
public class P2108 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int testCase = scanner.nextInt();
    int[] a = new int[testCase];
    for (int i = 0; i < testCase; ++i) {
      a[i] = scanner.nextInt();
    }

    Arrays.sort(a);
    int midValue = a[(a.length - 1) / 2];   // 중앙값
    int range = a[a.length - 1] - a[0];     // 범위

    Map<Integer, Integer> map = new HashMap<>();
    int sum = 0;
    double average = 0.0;
    for (int i = 0; i < testCase; ++i) {
      sum += a[i];

      if (map.get(a[i]) == null) {
        map.put(a[i], 1);
      }
      else {
        map.put(a[i], map.get(a[i]) + 1);
      }
    }
    average = 1.0 * sum / testCase;   // 산술평균
    average = Math.round(average);
    int intAvg = (int) average;

    int maxValue = 0;
    for (int key : map.keySet()) {
      if (map.get(key) > maxValue) {
        maxValue = map.get(key);
      }
    }

    List<Integer> list = new ArrayList<>();
    for (int key : map.keySet()) {
      if (map.get(key) == maxValue) {
        list.add(key);
      }
    }
    Collections.sort(list);

    System.out.println(intAvg);
    System.out.println(midValue);
    if (list.size() == 1) {
      System.out.println(list.get(0));
    }
    else {
      System.out.println(list.get(1));
    }
    System.out.println(range);
  }
}
