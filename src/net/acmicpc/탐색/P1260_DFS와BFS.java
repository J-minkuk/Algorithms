package net.acmicpc.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P1260_DFS와BFS {
    private static int N;
    private static int[][] graph;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);       // 정점수
        int M = Integer.parseInt(str[1]);   // 간선수
        int V = Integer.parseInt(str[2]);   // 시작 정점
        graph = new int[N + 1][N + 1];

        for (int i = 0; i < M; ++i) {
            String[] e = br.readLine().split(" ");
            int from = Integer.parseInt(e[0]);
            int to = Integer.parseInt(e[1]);
            graph[from][to] = 1;
            graph[to][from] = 1;
        }

        visited = new boolean[N + 1];
        dfs(V);

        System.out.println();
        Arrays.fill(visited, false);
        bfs(V);
    }

    private static void dfs(int from) {
        visited[from] = true;
        System.out.print(from + " ");
        for (int to = 1; to <= N; ++to) {
            if (graph[from][to] == 1 && !visited[to]) dfs(to);
        }
    }

    private static void bfs(int from) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(from);
        visited[from] = true;
        System.out.print(from + " ");

        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int to = 1; to <= N; ++to) {
                if (graph[temp][to] == 1 && !visited[to]) {
                    q.offer(to);
                    visited[to] = true;
                    System.out.print(to + " ");
                }
            }
        }
    }
}
