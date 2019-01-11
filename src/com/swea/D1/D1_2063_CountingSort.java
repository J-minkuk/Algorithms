package com.swea.D1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class D1_2063_CountingSort {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner sc = new Scanner(new FileReader("C:\\intelliJ_workspaces\\Algorithm\\src\\com\\swea\\D1\\testcase\\2063input.txt"));
    Scanner sc1 = new Scanner(System.in);

    int N = sc.nextInt();
    int[] numbers = new int[N];
    int[] count = new int[200];
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    int center = N / 2 + 1;
    int answer = 0;

    for (int i = 0; i < N; ++i) {
      numbers[i] = sc.nextInt();
      count[numbers[i]]++;

      if (numbers[i] < min) min = numbers[i];
      if (numbers[i] > max) max = numbers[i];
    }

    for (int i = min; i <= max; ++i) {
      if (i > 0) count[i] = count[i - 1] + count[i];
      if (count[i] >= center) {
        answer = i;
        break;
      }
    }
    System.out.println(answer);
  }
}
