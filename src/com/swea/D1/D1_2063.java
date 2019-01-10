package com.swea.D1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class D1_2063 {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner sc = new Scanner(new FileReader("C:\\intelliJ_workspaces\\Algorithm\\src\\com\\swea\\D1\\testcase\\2063input.txt"));
    Scanner sc1 = new Scanner(System.in);

    int N = sc.nextInt();
    int[] arr = new int[N];
    for (int i = 0; i < N; ++i) {
      arr[i] = sc.nextInt();
    }
    Arrays.sort(arr);
    System.out.println(Arrays.toString(arr));
    System.out.println(arr[N / 2]);
  }
}
