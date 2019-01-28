package com.swea.D3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_1209 {
  public static void main(String[] args) throws IOException {
    BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
    BufferedReader br = new BufferedReader(new FileReader("C:\\intelliJ_workspaces\\Algorithm\\src\\com\\swea\\D3\\testcase\\1209input.txt"));

    for (int t = 1; t <= 10; ++t) {
      int testCaseNum = Integer.parseInt(br.readLine());
      int[][] arr = new int[100][100];
      int max = 0;

      // 입력값 2차원 배열로 만들기
      for (int x = 0; x < 100; ++x) {
        int inputsIdx = 0;
        String[] inputs = br.readLine().split(" ");
        for (int y = 0; y < 100; ++y) {
          arr[x][y] = Integer.parseInt(inputs[inputsIdx++]);
        }
      }

      for (int i = 0; i < 100; ++i) {
        int sumCol = 0;
        int sumRow = 0;
        for (int j = 0; j < 100; ++j) {
          sumCol += arr[i][j];
          sumRow += arr[j][i];
        }
        if (sumCol > max) max = sumCol;
        if (sumRow > max) max = sumRow;
      }

      int sum1 = 0;
      int sum2 = 0;
      for (int idx = 0; idx < 100; ++idx) {
        sum1 += arr[idx][idx];
        sum2 += arr[idx][100 - idx - 1];
      }
      if (sum1 > max) max = sum1;
      if (sum2 > max) max = sum2;

      System.out.println("#" + testCaseNum + " " + max);
    }
  }
}
