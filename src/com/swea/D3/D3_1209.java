package com.swea.D3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_1209 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedReader br1 = new BufferedReader(new FileReader("D:\\sts_projects\\Algorithm\\src\\com\\swea\\D3\\testcase\\1209_input.txt"));

    for (int i = 0; i < 10; ++i) {
      int testCaseNum = Integer.parseInt(br.readLine());
      int[][] arr = new int[100][100];
      int max = 0;
      int sum = 0;

      // 입력값 2차원 배열로 만들기
      for (int x = 0; x < 100; ++x) {
        int inputsIdx = 0;
        String[] inputs = br.readLine().split(" ");
        for (int y = 0; y < 100; ++y) {
          arr[x][y] = Integer.parseInt(inputs[inputsIdx++]);
        }
      }

      // 각 행의 합 중 최댓값
      for (int col = 0; col < 100; ++col) {
        sum = 0;
        for (int row = 0; row < 100; ++row) {
          sum += arr[col][row];
          if (sum > max) max = sum;
        }
      }

      // 각 열의 합 중 최댓값
      for (int row = 0; row < 100; ++row) {
        sum = 0;
        for (int col = 0; col < 100; ++col) {
          sum += arr[col][row];
          if (sum > max) max = sum;
        }
      }

      // 각 대각선의 합 중 최댓값 - Case 1
      sum = 0;
      for (int idx = 0; idx < 100; ++idx) {
        sum += arr[idx][idx];
        if (sum > max) max = sum;
      }

      // 각 대각선의 합 중 최댓값 - Case 2
      sum = 0;
      int colIdx = 0;
      for (int idx = 99; idx >= 0; --idx) {
        sum += arr[colIdx++][idx];
        if (sum > max) max = sum;
      }
      System.out.println("#" + testCaseNum + " " + max);
    }
  }
}
