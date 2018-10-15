package com.algorithm.baekjoon.problem.sort;

import java.util.*;

/**
 * 단어 정렬
 *
 * Comparator
 */
public class P1181 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int testCase = scanner.nextInt();

    Set<String> set = new HashSet<>();
    for (int i = 0; i < testCase; ++i) {
      set.add(scanner.next());
    }

    String[] strArr = new String[set.size()];

    set.toArray(strArr);
    Arrays.sort(strArr);
    Arrays.sort(strArr, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return Integer.compare(o1.length(), o2.length());
      }
    });

    for (String s : strArr) {
      System.out.println(s);
    }
  }
}
