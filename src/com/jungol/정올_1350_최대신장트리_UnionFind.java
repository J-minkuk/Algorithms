package com.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
5 8
1 2 3
1 3 7
2 3 10
2 4 4
2 5 8
3 4 6
3 5 2
4 5 17

 */
public class 정올_1350_최대신장트리_UnionFind {
    static Edge[] edges;
    static int[] tree;

    static class Edge implements Comparable<Edge> {
        int s, e, w;

        public Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return (-1) * (this.w - o.w);
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "s=" + s +
                    ", e=" + e +
                    ", w=" + w +
                    '}';
        }
    }

    private static int find(int a) {
        if (tree[a] < 0) return a;
        return tree[a] = find(tree[a]);
    }

    private static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot != bRoot) {
            tree[bRoot] = aRoot;
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int N = Integer.parseInt(st.nextToken());   // 정점 수
        int M = Integer.parseInt(st.nextToken());   // 간선 수

        tree = new int[N + 1];
        Arrays.fill(tree, -1);

        edges = new Edge[M];
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine().trim());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(from, to, weight);
        }
        Arrays.sort(edges);
//        System.out.println(Arrays.toString(edges));

        int result = 0;
        int count = 0;
        for (Edge e : edges) {
            if (union(e.s, e.e)) {
                result += e.w;
                if (++count == N - 1) break;
            }
        }
        System.out.println(result);
    }
}
