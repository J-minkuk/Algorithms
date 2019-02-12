package com.swea.D5;

import java.util.Scanner;

public class D5_1247 {
  static int N;
  static int[][] NP;
  static int result;
  static int hX, hY;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt(); sc.nextLine();
    for (int t = 1; t <= T; ++t) {
      N = sc.nextInt();
      int cX = sc.nextInt();
      int cY = sc.nextInt();
      hX = sc.nextInt();
      hY = sc.nextInt();
      NP = new int[N][2];
      for (int i = 0; i < N; ++i) {
        NP[i][0] = sc.nextInt();
        NP[i][1] = sc.nextInt();
      }

      result = Integer.MAX_VALUE;
      boolean[] check = new boolean[N];
      minDistance(0, 0, cX, cY, check);
      System.out.println("#" + t + " " + result);
    }
  }

  private static void minDistance(int tempDis, int count, int startX, int startY, boolean[] check) {
    if (count == N) {
      tempDis += Math.abs(startX - hX) + Math.abs(startY - hY);
      if (result > tempDis) result = tempDis;
      return;
    }

    for (int i = 0; i < N; ++i) {
      if (!check[i]) {
        tempDis += Math.abs(startX - NP[i][0]) + Math.abs(startY - NP[i][1]);
        check[i] = true;
        minDistance(tempDis, count + 1, NP[i][0], NP[i][1], check);
        tempDis -= Math.abs(startX - NP[i][0]) + Math.abs(startY - NP[i][1]);
        check[i] = false;
      }
    }
  }
}
