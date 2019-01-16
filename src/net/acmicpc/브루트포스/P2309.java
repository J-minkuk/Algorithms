package net.acmicpc.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2309 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = 9;
    int[] heights = new int[N];
    // 난쟁이 키 입력
    int sum = 0;
    for (int i = 0; i < N; ++i) {
      heights[i] = Integer.parseInt(br.readLine());
      sum += heights[i];
    }

    int sub = sum - 100;
    for (int i = 0; i < N - 1; ++i) {
      boolean flag = false;
      for (int j = i + 1; j < N; ++j) {
        if (heights[i] + heights[j] == sub) {
          heights[i] = 0;
          heights[j] = 0;
          flag = true;
          break;
        }
      }
      if (flag) break;
    }

    Arrays.sort(heights);
    for (int i = 2; i < N; ++i) {
      System.out.println(heights[i]);
    }
  }
}
