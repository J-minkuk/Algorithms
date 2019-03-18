package net.acmicpc.정렬;

import java.util.Scanner;

/**
 * 수 정렬하기 (오름차순)
 */
public class P2750_수정렬하기_오름차순 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < arr.length - 1; ++i) {
            for (int j = 0; j < arr.length - 1; ++j) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }

        for (int i = 0; i < arr.length; ++i) {
            System.out.println(arr[i]);
        }
    }

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
