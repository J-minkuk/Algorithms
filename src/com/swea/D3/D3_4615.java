package com.swea.D3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D3_4615 {
  private static int N;
  private static int[][] arr;
  private static int c; // 돌 색깔

  /**
   * 상 하 좌 우
   * 좌상 좌하 우상 우하
   */
  private static int[][] DIR = {
          {0, -1}, {0, 1}, {-1, 0}, {1, 0},
          {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
  };

  private static void markStone(int x, int y) {
    arr[y][x] = c;
    for (int d = 0; d < 8; ++d) {
      check(x + DIR[d][0], y + DIR[d][1], DIR[d][0], DIR[d][1]);
    }
  }

  private static boolean check(int x, int y, int rowM, int colM) {
    if (x < 1 || x > N || y < 1 || y > N) return false;
    if (arr[y][x] != 1 && arr[y][x] != 2) return false; // 이거 왜 체크해야되는거지
    if (arr[y][x] == c) return true;
    if (check(x + rowM, y + colM, rowM, colM)) {
      arr[y][x] = c;
      return true;
    }
    return false;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
    BufferedReader br = new BufferedReader(new FileReader("C:\\intelliJ_workspaces\\Algorithm\\src\\com\\swea\\TODO\\testcase\\4615input.txt"));
    int T = Integer.parseInt(br.readLine());
    for (int t = 1; t <= T; ++t) {
      String[] NM = br.readLine().split(" ");
      N = Integer.parseInt(NM[0]);  // 보드 사이즈 (4, 6, 8)
      int M = Integer.parseInt(NM[1]);  // 돌을 놓는 횟수
      arr = new int[N + 2][N + 2];

      // 초기 시작 위치 초기화
      arr[N / 2][N / 2] = 2;
      arr[N / 2 + 1][N / 2 + 1] = 2;
      arr[N / 2][N / 2 + 1] = 1;
      arr[N / 2 + 1][N / 2] = 1;

      for (int i = 0; i < M; ++i) {
        String[] XYC = br.readLine().split(" ");
        int x = Integer.parseInt(XYC[0]);
        int y = Integer.parseInt(XYC[1]);
        c = Integer.parseInt(XYC[2]);

        markStone(x, y);
      }

      System.out.println();
      for (int i = 0; i < N + 2; ++i) {
        System.out.println(Arrays.toString(arr[i]));
      }

      int white = 0;
      int black = 0;
      for (int i = 0; i < N + 2; ++i) {
        for (int j = 0; j < N + 2; ++j) {
          if (arr[i][j] == 1) ++black;
          if (arr[i][j] == 2) ++white;
        }
      }
      System.out.println("#" + t + " " + black + " " + white);
    }
  }
}
