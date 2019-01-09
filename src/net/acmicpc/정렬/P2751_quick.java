package net.acmicpc.정렬;

import java.util.Scanner;

/**
 * 수 정렬하기 -2 (오름차순)
 */
public class P2751_quick {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int testCase = scanner.nextInt();
    int[] numbers = new int[testCase];

    for (int i = 0; i < numbers.length; ++i) {
      numbers[i] = scanner.nextInt();
    }
    quickSort(numbers, 0, numbers.length - 1);
    for (int value : numbers) {
      System.out.println(value);
    }
  }

  private static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  private static int partition(int[] a, int start, int end) {
    int criteriaValue = a[end];
    int i = start - 1;

    for (int j = start; j < end; ++j) {
      if (a[j] < criteriaValue) {
        swap(a, ++i, j);
      }
    }
    swap(a, i + 1, end);
    return i + 1;
  }

  private static void quickSort(int[] a, int start, int end) {
    if (start >= end) return;
    int middle = partition(a, start, end);
    quickSort(a, start, middle - 1);
    quickSort(a, middle + 1, end);
  }
}
