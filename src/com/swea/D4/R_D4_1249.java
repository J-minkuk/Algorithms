package com.swea.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class R_D4_1249 {
  static int N;
  static int[][] map;
  static int[][] distance;
  static int[][] dir = {
          {-1, 0}, {1, 0}, {0, -1}, {0, 1}
  };

  static class Node {
    public int y, x, sum;
    public Node(int y, int x, int sum) {
      this.y = y;
      this.x = x;
      this.sum = sum;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int t = 1; t <= T; ++t) {
      N = Integer.parseInt(br.readLine());
      map = new int[N][N];
      distance = new int[N][N];

      for (int i = 0; i < N; ++i) {
        char[] chars = br.readLine().toCharArray();
        for (int j = 0; j < N; ++j) {
          map[i][j] = Integer.parseInt(chars[j] + "");
          distance[i][j] = Integer.MAX_VALUE;
        }
      }
      bfs();
      System.out.println("#" + t + " " + distance[N - 1][N - 1]);
    }
  }

  private static void bfs() {
    Queue<Node> q = new LinkedList<>();
    q.add(new Node(0, 0, 0));
    distance[0][0] = 0;

    while (!q.isEmpty()) {
      Node node = q.poll();
      for (int d = 0; d < 4; ++d) {
        int nY = node.y + dir[d][0];
        int nX = node.x + dir[d][1];
        if (nY < 0 || nY >= N || nX < 0 || nX >= N) continue;

        int sum = node.sum + map[nY][nX];
        if (sum < distance[nY][nX]) {
          distance[nY][nX] = sum;
          q.add(new Node(nY, nX, sum));
        }
      }
    }
  }
}
