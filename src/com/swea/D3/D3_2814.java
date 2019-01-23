package com.swea.D3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D3_2814 {
  public static void main(String[] args) throws IOException {
    BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
    BufferedReader br = new BufferedReader(new FileReader("C:\\intelliJ_workspaces\\Algorithm\\src\\com\\swea\\D3\\testcase\\2814input.txt"));

    int T = Integer.parseInt(br.readLine());
    for (int t = 1; t <= T; ++t) {
      String[] str = br.readLine().split(" ");
      int N = Integer.parseInt(str[0]); // 정점의 번호 1 ~ N
      int M = Integer.parseInt(str[1]); // M개의 간선

      int[][] link = new int[N + 1][N + 1];
      for (int i = 0; i < M; ++i) {
        String[] edge = br.readLine().split(" ");
        int y = Integer.parseInt(edge[0]);
        int x = Integer.parseInt(edge[1]);
        link[y][x] = 1;
        link[x][y] = 1;
      }

      for (int i = 0; i < N + 1; ++i) {
        System.out.println(Arrays.toString(link[i]));
      }

      int length = 0;
      for (int i = 0; i < N; ++i) {
        if (link[i][i] == 1) ++length;
      }
    }
  }
}
