package net.acmicpc.sort;

import java.util.Scanner;

/**
 * 수 정렬하기 -2 (오름차순)
 */
public class P2751_heap {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int testCase = scanner.nextInt();
    int[] numbers = new int[testCase];
    for (int i = 0; i < testCase; ++i) {
      numbers[i] = scanner.nextInt();
    }

    heapSort(numbers);
    for (int value : numbers) {
      System.out.println(value);
    }
  }

  private static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  private static void buildHeap(int[] a) {
    int end = a.length - 1;
    for (int i = end / 2; i >= 0; --i) {
      heapify(a, i ,end);
    }
  }

  private static void heapify(int[] a, int k, int end) {
    int left = 2 * k + 1;
    int right = 2 * k + 2;
    int larger;

    if (right <= end) larger = (a[left] > a[right]) ? left : right;
    else if (left <= end) larger = left;
    else return;

    if (a[larger] > a[k]) {
      swap(a, larger, k);
      heapify(a, larger, end);
    }
  }

  private static void heapSort(int[] a) {
    buildHeap(a);
    for (int end = a.length - 1; end >= 1; --end) {
      swap(a, 0, end);
      heapify(a, 0, end - 1);
    }
  }
}
