package com.swea.D4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class D4_1211 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedReader br1 = new BufferedReader(new FileReader("D:\\sts_projects\\Algorithm\\src\\com\\swea\\D4\\testcase\\1211_input.txt"));

    for (int testCase = 0; testCase < 10; ++testCase) {
      int testCaseNum = Integer.parseInt(br.readLine());
      int[][] arr = new int[100][100];
      List<Integer> startRowList = new ArrayList<>();

      // 입력값 2차원 배열로 만들기
      for (int x = 0; x < 100; ++x) {
        int inputsIdx = 0;
        String[] inputs = br.readLine().split(" ");
        for (int y = 0; y < 100; ++y) {
          arr[x][y] = Integer.parseInt(inputs[inputsIdx++]);
          if (arr[0][y] == 1) startRowList.add(y);
        }
      }

      int minDistance = Integer.MAX_VALUE;
      int resultIdx = 0;
      for (int startRow : startRowList) {
        boolean[][] marking = new boolean[100][100];
        int row = startRow;
        int col = 0;
        int distance = 0;

        while (col < 99) {
          marking[col][row] = true;
          distance++;

          if ((row - 1) >= 0 && arr[col][row - 1] == 1 && !marking[col][row - 1]) row--;
          else if ((row + 1) < 100 && arr[col][row + 1] == 1 && !marking[col][row + 1]) row++;
          else if ((col + 1) < 100 && arr[col + 1][row] == 1 && !marking[col + 1][row]) col++;
        }
        if (distance <= minDistance) {
          minDistance = distance;
          if (startRow > resultIdx) resultIdx = startRow;
        }
      }
      System.out.println("#" + testCaseNum + " " + resultIdx);
    }
  }
}
