package com.swea.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D2_1204 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    BufferedReader br = new BufferedReader(new FileReader("D:\\sts_projects\\Algorithm\\src\\com\\swea\\D2\\testcase\\1204_input.txt"));
    int testCase = Integer.parseInt(br.readLine());

    for (int i = 0; i < testCase; ++i) {
      int testNum = Integer.parseInt(br.readLine());
      int[] scoreCounts = new int[101];

      String[] scores = br.readLine().split(" ");
      for (int j = 0; j < scores.length; ++j) {
        scoreCounts[Integer.parseInt(scores[j])]++;
      }

      int max = scoreCounts[0];
      int resultIndex = 0;
      for (int k = 1; k < 101; ++k) {
        if (max <= scoreCounts[k]) {
          max = scoreCounts[k];
          resultIndex = k;
        }
      }
      System.out.println("#" + testNum + " " + resultIndex);
    }
  }
}
