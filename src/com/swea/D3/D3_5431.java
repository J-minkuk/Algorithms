package com.swea.D3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class D3_5431 {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner sc = new Scanner(new FileReader("C:\\intelliJ_workspaces\\Algorithm\\src\\com\\swea\\D3\\testcase\\0110input.txt"));
    int T = sc.nextInt();
    for (int t = 1; t <= T; ++t) {
      int N = sc.nextInt();
      int P = sc.nextInt();
      int[] person = new int[N];

      for (int i = 0; i < P; ++i) {
        int p = sc.nextInt();
        person[p - 1] = 1;
      }

      System.out.print("#" + t + " ");
      for (int i = 0; i < person.length; ++i) {
        if (person[i] == 0) System.out.print((i + 1) + " ");
      }
      System.out.println();
    }
  }
}
