package com.swea.TODO;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class D4_1238_재귀 {
  static Queue<Integer> q;
  static int[][] info;
  static boolean[] visited;
  static int result;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = 10;
    for (int t = 1; t <= T; ++t) {
      int SIZE = sc.nextInt();
      int start = sc.nextInt();
      info = new int[101][101];
      visited = new boolean[101];

      for (int i = 0; i < SIZE / 2; ++i) {
        int from = sc.nextInt();
        int to = sc.nextInt();
        info[from][to] = 1;
      }

      q = new LinkedList<>();
      result = 0;
      bfs(start, start);
      System.out.println("#" + t + " " + result);
    }
  }

  // TODO 재귀로도 구현하기
  private static void bfs(int point, int point2) {
//    if (q.isEmpty()) return;

    q.add(point);
    visited[point] = true;
    int max = Integer.MIN_VALUE;
    result = (max > point2) ? max : point2;

    for (int i = 0; i < q.size(); ++i) {
      int next = q.remove();
      for (int p = 1; p < 101; ++p) {
        if (visited[next]) continue;
        if (info[next][p] == 1) {
          bfs(next, p);
        }
      }
    }
  }

  private static void bfs1(int point) {
    Queue<Integer> q = new LinkedList<>();
    q.add(point);
    visited[point] = true;
    result = point;

    while(!q.isEmpty()) {
      int size = q.size();
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < size; ++i) {
        int value = q.remove();
        for (int p = 1; p < 101; ++p) {
          if (visited[p]) continue;
          if (info[value][p] == 1) {
            q.add(p);
            visited[p] = true;
            max = Math.max(max, p);
          }
        }
      }
      if (!q.isEmpty()) result = max;
    }
  }
}
