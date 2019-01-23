package com.swea.D3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D3_4615_TODO {
  /**
   * 상 하 좌 우
   * 좌상 좌하 우상 우하
   */
  private static int[][] ONE_DIR = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
  private static int[][] TWO_DIR = {{0, -2}, {0, 2}, {-2, 0}, {2, 0}, {-2, -2}, {-2, 2}, {2, -2}, {2, 2}};
  private static int[][] arr;
  private static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
    BufferedReader br = new BufferedReader(new FileReader("C:\\intelliJ_workspaces\\Algorithm\\src\\com\\swea\\D3\\testcase\\4615input.txt"));
    int T = Integer.parseInt(br.readLine());
    for (int t = 1; t <= 1; ++t) {
      String[] str = br.readLine().split(" ");
      N = Integer.parseInt(str[0]);  // 보드 사이즈(4, 6, 8)
      int M = Integer.parseInt(str[1]);  // 플레이어가 돌 놓는 횟수
      arr = new int[N + 2][N + 2];

      // 초기 시작 위치 초기화
      arr[N / 2][N / 2] = 2;
      arr[N / 2 + 1][N / 2 + 1] = 2;
      arr[N / 2][N / 2 + 1] = 1;
      arr[N / 2 + 1][N / 2] = 1;

      // 시작 위치 확인
      for (int i = 0; i < N + 2; ++i) {
        System.out.println(Arrays.toString(arr[i]));
      }

      for (int i = 0; i < M; ++i) {
        String[] s = br.readLine().split(" ");
        int x = Integer.parseInt(s[0]);
        int y = Integer.parseInt(s[1]);
        int c = Integer.parseInt(s[2]); // 1흑 2백
        stonePosition(x, y, c);
      }

      System.out.println();
      for (int i = 0; i < N + 2; ++i) {
        System.out.println(Arrays.toString(arr[i]));
      }
    }
  }

  private static void stonePosition(int x, int y, int c) {
    for (int i = 0; i < 8; ++i) {
      int oneX = x + ONE_DIR[i][0];
      int oneY = y + ONE_DIR[i][1];
      int twoX = x + TWO_DIR[i][0];
      int twoY = y + TWO_DIR[i][1];
      if (c == 1 && twoX > 0 && twoX <= N && twoY > 0 && twoY <= N) {
        if (arr[oneY][oneX] == 2) {
          arr[y][x] = c;
          arr[oneY][oneX] = c;
          break;
        }
      } else if (c == 2 && twoX > 0 && twoX <= N && twoY > 0 && twoY <= N) {
        if (arr[oneY][oneX] == 1) {
          arr[y][x] = c;
          arr[oneY][oneX] = c;
          break;
        }
      }
    }
  }
}
