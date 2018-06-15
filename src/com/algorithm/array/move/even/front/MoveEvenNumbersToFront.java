package com.algorithm.array.move.even.front;

import java.util.Arrays;
import java.util.Random;

/*
 * 배열에서 짝수는 앞으로 홀수는 뒤로, 그다음 정렬까지
 */
public class MoveEvenNumbersToFront {

  static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  static void moveEvenNumbersToFront(int[] a) {
    int start = 0;
    int end = a.length - 1;
    boolean flag = true;

    while (flag) {
      while ((a[start] % 2 == 0) && (start < end)) {
        ++start;
      }
      while ((a[end] % 2 == 1) && (start < end)) {
        --end;
      }
      if (start >= end) {
        flag = false;
      }
      swap(a, start, end);
    }
  }

  static int findPoint(int[] a) {
    while (true) {
      for (int i = 0; i < a.length; ++i) {
        if (a[i] % 2 == 1) return i;
      }
    }
  }

  static void partialSort(int[] a, int point) {
    Arrays.sort(a, 0, point);
    Arrays.sort(a, point, a.length);
  }

  public static void main(String[] args) {
    Random random = new Random();
    int[] a = new int[20];
    for (int i = 0; i < a.length; ++i) {
      a[i] = random.nextInt(20);
    }

    moveEvenNumbersToFront(a);
    int point = findPoint(a);
    partialSort(a, point);

    System.out.println(Arrays.toString(a));
  }

}
