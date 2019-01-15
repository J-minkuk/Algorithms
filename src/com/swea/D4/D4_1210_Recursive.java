package com.swea.D4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D4_1210_Recursive {
  static int startCol, startRow;
  static int[][] ladder;
  static int testCaseNum;

  private static void findEndPoint(int x, int y) {
    ladder[x][y] = 0; // 방문 표시
    if (x <= 0) {
      System.out.println("#" + testCaseNum + " " + y);
      return;
    }
    if ((y - 1) >= 0 && ladder[x][y - 1] == 1) findEndPoint(x, y - 1);  // 좌
    else if ((y + 1) < 100 && ladder[x][y + 1] == 1) findEndPoint(x, y + 1); // 우
    else if ((x - 1) >= 0 && ladder[x - 1][y] == 1) findEndPoint(x - 1, y);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
    BufferedReader br = new BufferedReader(new FileReader("C:\\intelliJ_workspaces\\Algorithm\\src\\com\\swea\\D4\\testcase\\1210input.txt"));

    for (int testCase = 0; testCase < 10; ++testCase) {
      testCaseNum = Integer.parseInt(br.readLine());
      ladder = new int[100][100];
      startCol = 0;
      startRow = 0;

      // 입력값 2차원 배열로 만들기
      for (int x = 0; x < 100; ++x) {
        int inputsIdx = 0;
        String[] inputs = br.readLine().split(" ");
        for (int y = 0; y < 100; ++y) {
          ladder[x][y] = Integer.parseInt(inputs[inputsIdx++]);
          if (ladder[x][y] == 2) {
            startCol = x;
            startRow = y;
          }
        }
      }
      findEndPoint(startCol, startRow);
    }
  }
}
