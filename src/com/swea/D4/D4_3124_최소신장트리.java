package com.swea.D4;

import java.util.Arrays;
import java.util.Scanner;

/*
1
7
11
1 2 2
2 7 7
7 6 9
6 5 23
5 4 1
4 1 10
1 3 3
2 3 3
3 7 4
3 6 3
3 5 6
 */
public class D4_3124_최소신장트리 {
  static int[] parents;

  static int findRoot(int a) {
    if (parents[a] < 0) return a;
    return parents[a] = findRoot(parents[a]);
  }

  static boolean union(int a, int b) {
    int aRoot = findRoot(a);
    int bRoot = findRoot(b);
    if (aRoot != bRoot) {
      parents[bRoot] = aRoot;
      return true;
    }
    return false;
  }

  static class Edge implements Comparable<Edge> {
    int from, to, w;

    public Edge(int from, int to, int w) {
      this.from = from;
      this.to = to;
      this.w = w;
    }

    @Override
    public String toString() {
      return from + " " + to + " " + w;
    }

    @Override
    public int compareTo(Edge o) {
      return this.w - o.w;
    }

  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for (int t = 1; t <= T; ++t) {
      int V = sc.nextInt();
      int E = sc.nextInt();

      Edge[] arr = new Edge[E];
      for (int i = 0; i < E; ++i) {
        int from = sc.nextInt();
        int to = sc.nextInt();
        int w = sc.nextInt();
        arr[i] = new Edge(from, to, w);
      }
      Arrays.sort(arr);
      parents = new int[V + 1];
      Arrays.fill(parents, -1);

      long result = 0;
      int count = 0;
      for (Edge e : arr) {
        if (union(e.from, e.to)) {
          result += e.w;
          if (++count == V - 1) break;
        }
      }
      System.out.println("#" + t + " " + result);
    }
  }
}
