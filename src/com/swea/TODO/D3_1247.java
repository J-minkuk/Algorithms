package com.swea.TODO;

import java.util.Scanner;

public class D3_1247 {
  static int N;
  static int[][] NP;
  static int result;
  static int tempDis;
  static boolean[] check;
  static int count;
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

      result = 0;
      tempDis = Integer.MAX_VALUE;
      count = 0;
      check = new boolean[N];
      minDistance(cX, cY);
      System.out.println("#" + t + " " + result);
    }
  }

  private static void minDistance(int startX, int startY) {
//    System.out.println(startX + " " + startY);
    if (count == N) {
      result += Math.abs(startX - hX) + Math.abs(startY - hY);
      return;
    }

    int idx = 0;
    for (int i = 0; i < N; ++i) {
      if (!check[i]) {
        int dis = Math.abs(startX - NP[i][0]) + Math.abs(startY - NP[i][1]);
        if (tempDis > dis) {
          idx = i;
          tempDis = dis;
        }
      }
    }
    check[idx] = true;
    result += tempDis;
    tempDis = Integer.MAX_VALUE;
    count++;
    minDistance(NP[idx][0], NP[idx][1]);
  }
}
