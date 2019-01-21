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

  public static void main(String[] args) throws IOException {
    BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
    BufferedReader br = new BufferedReader(new FileReader("C:\\intelliJ_workspaces\\Algorithm\\src\\com\\swea\\D3\\testcase\\4615input.txt"));
    int T = Integer.parseInt(br.readLine());
    for (int t = 1; t <= T; ++t) {
      String[] str = br.readLine().split(" ");
      int N = Integer.parseInt(str[0]);  // 보드 사이즈(4, 6, 8)
      int M = Integer.parseInt(str[1]);  // 플레이어가 돌 놓는 횟수
      int[][] arr = new int[N][N];

      // 초기 시작 위치 초기화
      arr[N / 2][N / 2] = 2;
      arr[N / 2 - 1][N / 2 - 1] = 2;
      arr[N / 2][N / 2 - 1] = 1;
      arr[N / 2 - 1][N / 2] = 1;

      for (int i = 0; i < N; ++i) {
        System.out.println(Arrays.toString(arr[i]));
      }

      for (int i = 0; i < M; ++i) {
        String[] s = br.readLine().split(" ");
        int x = Integer.parseInt(s[0]) - 1;
        int y = Integer.parseInt(s[1]) - 1;
        int c = Integer.parseInt(s[2]); // 1흑 2백

        if (c == 1) { // 흑 선공
          for (int d = 0; d < 8; ++d) {
            int oneX = x + ONE_DIR[d][0];
            int oneY = y + ONE_DIR[d][1];
            int twoX = x + TWO_DIR[d][0];
            int twoY = y + TWO_DIR[d][1];
            if (twoX >= 0 && twoX < N && twoY >= 0 && twoY < N) {
              if (arr[oneY][oneX] == 2 && arr[twoY][twoX] == 1) {
                arr[y][x] = 1;
                arr[oneY][oneX] = 1;
              }
            }
          }
        } else if (c == 2) {  // 백 선공
          for (int d = 0; d < 8; ++d) {
            int oneX = x + ONE_DIR[d][0];
            int oneY = y + ONE_DIR[d][1];
            int twoX = x + TWO_DIR[d][0];
            int twoY = y + TWO_DIR[d][1];
            if (twoX >= 0 && twoX < N && twoY >= 0 && twoY < N) {
              if (arr[oneY][oneX] == 1 && arr[twoY][twoX] == 2) {
                arr[y][x] = 2;
                arr[oneY][oneX] = 2;
              }
            }
          }
        }
      }

      System.out.println();
      for (int k = 0; k < N; ++k) {
        System.out.println(Arrays.toString(arr[k]));
      }
    }
  }
}
