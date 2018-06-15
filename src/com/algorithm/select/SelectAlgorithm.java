package com.algorithm.select;

import java.util.Arrays;
import java.util.Random;

public class SelectAlgorithm {

  static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  static int partition(int[] a, int start, int end) {
    int value = a[end];
    int i = start - 1;
    for (int j = start; j < end; ++j) {
      if (a[j] < value) {
        swap(a, ++i, j);
      }
    }
    swap(a, i + 1, end);
    return i + 1;
  }

  static int select(int[] a, int start, int end, int nth) {
    if (start >= end) return a[start];

    int middle = partition(a, start, end);
    int middleNth = middle - start + 1;

    if (nth == middleNth) {
      return a[middle];
    }
    else if (nth < middleNth) {
      return select(a, start, middle - 1, nth);
    }
    else {
      return select(a, middle + 1, end, nth - middleNth);
    }
  }

  public static void main(String[] args) {
    Random random = new Random();
    int[] a = new int[10];
    for (int i = 0; i < a.length; ++i) {
      a[i] = random.nextInt(20);
    }

    System.out.println(Arrays.toString(a));
    System.out.format("1 번째 작은 값: %d\n", select(a, 0, a.length - 1, 1));
    System.out.format("2 번째 작은 값: %d\n", select(a, 0, a.length - 1, 2));
    System.out.format("3 번째 작은 값: %d\n", select(a, 0, a.length - 1, 3));
    System.out.format("4 번째 작은 값: %d\n", select(a, 0, a.length - 1, 4));
  }

}
