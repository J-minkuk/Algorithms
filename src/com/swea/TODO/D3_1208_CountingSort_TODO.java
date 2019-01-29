//package com.swea.D3;
//
//import java.io.IOException;
//import java.util.Scanner;
//
//public class D3_1208_CountingSort {
//  static int min;
//  static int max;
//  static int DUMP;
//  static int[] count;
//
//  public static void main(String[] args) throws IOException {
//    Scanner sc = new Scanner(System.in);
//    int T = 10;
//    int N = 10;
//
//    DUMP = sc.nextInt();
//
//    for (int t = 1; t <= T; ++t) {
//      DUMP = sc.nextInt();
//      int[] height = new int[100];
//      count = new int[101];
//
//      for (int i = 0; i < 100; ++i) {
//        min = Integer.MAX_VALUE;
//        max = Integer.MIN_VALUE;
//
//        if (height[i] < min) min = height[i];
//        if (height[i] > max) max = height[i];
//      }
//      System.out.println("#" + t + " " + getFlatten());
//    }
//  }
//
//  private static int getFlatten() {
//    for (int d = 0; d < DUMP; ++d) {
//      if (max - min <= 1) break;
//      count[min + 1]++;
//      count[max - 1]++;
//      if (--count[max] == 0) max--;
//      if (--count[min] == 0) min++;
//    }
//    return max - min;
//  }
//}
