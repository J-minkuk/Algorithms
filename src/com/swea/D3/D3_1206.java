package com.swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_1206 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    BufferedReader br = new BufferedReader(new FileReader("D:\\sts_projects\\Algorithm\\src\\com\\swea\\D3\\testcase\\1206_input.txt"));

    for (int i = 0; i < 10; ++i) {
      int sum = 0;
      int xWidth = Integer.parseInt(br.readLine());
      String[] temp = br.readLine().split(" ");

      int[] heights = new int[temp.length];
      for (int j = 0; j < temp.length; ++j) {
        heights[j] = Integer.parseInt(temp[j]);
      }

      for (int idx = 2; idx < heights.length - 2; ++idx) {
        if (heights[idx] < heights[idx - 1] || heights[idx] < heights[idx - 2]) continue;
        else if (heights[idx] < heights[idx + 1] || heights[idx] < heights[idx + 2]) continue;
        else {
          int left1 = heights[idx] - heights[idx - 1];
          int left2 = heights[idx] - heights[idx - 2];
          int left = left1 < left2 ? left1 : left2;

          int right1 = heights[idx] - heights[idx + 1];
          int right2 = heights[idx] - heights[idx + 2];
          int right = right1 < right2 ? right1 : right2;

          sum += left < right ? left : right;
        }
      }
      System.out.println("#" + (i + 1) + " " + sum);
    }
  }
}
