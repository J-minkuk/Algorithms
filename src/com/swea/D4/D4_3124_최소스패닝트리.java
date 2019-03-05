package com.swea.D4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 크루스칼 알고리즘 활용
 * 최소 신장 트리
 */
public class D4_3124_최소스패닝트리 {

    static Edge[] edgeList;
    private static int[] parent;

    public static int find(int a) {
        if (parent[a] < 0) return a;    // 자신이 루트이면 그냥 자신의 번호 리턴
        return parent[a] = find(parent[a]);
    }

    public static boolean union(int a, int b) {

        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot != bRoot) {   // 두 노드의 root가 다르면 합침
            parent[bRoot] = aRoot;
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; ++t) {

            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int vertexCount = Integer.parseInt(st.nextToken());
            int edgeCount = Integer.parseInt(st.nextToken());
            parent = new int[vertexCount + 1];
            edgeList = new Edge[edgeCount];
            Arrays.fill(parent, -1);

            for (int i = 0; i < edgeCount; ++i) {
                st = new StringTokenizer(br.readLine().trim());
                edgeList[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            } // 간선 저장

            // 간선비용이 작은 순서대로 정렬
            Arrays.sort(edgeList);

            long result = 0;
            int count = 0;  // 연결 간선수
            for (Edge edge : edgeList) {
                if (union(edge.start, edge.end)) {  // 싸이클이 발생하지 않았으면
                    result = result + edge.weight;
                    if (++count == vertexCount - 1) {   // 연결 간선수가 정점수 -1 이면 다 연결한 것임.
                        break;
                    }
                }
            }
            System.out.println("#" + t + " " + result);
        }
    }

    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }

    }

}
