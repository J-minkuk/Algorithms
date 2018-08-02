package com.algorithm.baekjoon.problem.math;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 셀프 넘버
 */
public class P4673 {

  static SortedSet<Integer> sortedSet = new TreeSet<>();

  public static void main(String[] args) {

    SortedSet<Integer> numberList = new TreeSet<>();
    for (int i = 1; i <= 10000; ++i) {
      numberList.add(i);
      constructorNumber(i);
    }

    numberList.removeAll(sortedSet);
    for (int value : numberList) {
      System.out.println(value);
    }

  }

  static void constructorNumber(int n) {
    int result = 0;

    if (n > 10000) return;

    if (n <= 10000) {
      if (n < 100) {
        int value1 = n / 10;
        int value2 = n % 10;
        result = n + value1 + value2;
      }
      else if (n < 1000) {
        int value1 = n / 100;
        int value2 = (n - (value1 * 100)) / 10;
        int value3 = n % 10;
        result = n + value1 + value2 + value3;
      }
      else if (n < 10000) {
        int value1 = n / 1000;
        int value2 = (n - (value1 * 1000)) / 100;
        int value3 = (n - (value1 * 1000 + value2 * 100)) / 10;
        int value4 = n % 10;
        result = n + value1 + value2 + value3 + value4;
      }

      if (result <= 10000) {
        sortedSet.add(result);
      }
    }
  }

}
