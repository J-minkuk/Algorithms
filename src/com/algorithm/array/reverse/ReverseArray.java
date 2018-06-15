package com.algorithm.array.reverse;

import java.util.Arrays;

public class ReverseArray {

  static void reverseArray(int[] a) {
    int size = a.length;
    for (int i = 0; i < size / 2; ++i) {
      int temp = a[i];
      a[i] = a[(size - 1) - i];
      a[(size - 1) - i] = temp;
    }
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    reverseArray(a);
    System.out.println(Arrays.toString(a));
  }

}
