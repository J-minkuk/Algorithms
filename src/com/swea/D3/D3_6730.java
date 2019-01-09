package com.swea.D3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class D3_6730 {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner sc = new Scanner(new FileReader("C:\\intelliJ_workspaces\\Algorithm\\src\\com\\swea\\D3\\testcase\\6730_input.txt"));
    Scanner sc1 = new Scanner(System.in);
    int T = sc.nextInt();
    for (int t = 1; t <= T; ++t) {
      int N = sc.nextInt();
      int[] obstacle = new int[N];
      int[] sub = new int[N - 1];

      for (int i = 0; i < N; ++i) {
        obstacle[i] = sc.nextInt();
      }

      for (int i = 0; i < N - 1; ++i) {
        sub[i] = obstacle[i + 1] - obstacle[i];
      }

      int max = 0;
      int min = 0;
      for (int i = 0; i < sub.length; ++i) {
        if (sub[i] > 0 && sub[i] > max) max = sub[i];
        else if (sub[i] < 0 && sub[i] < min) min = sub[i];
      }
      System.out.println("#" + t + " " + max + " " + Math.abs(min));
    }
  }
}
