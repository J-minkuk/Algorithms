package net.acmicpc.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P10026_적녹색약_BFS {
    private static int N, count1, count2;
    private static char[][] map;
    private static boolean[][] visited;
    private static int dir[][] = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        map = new char[N][N];
        for (int i = 0; i < N; ++i) {
            map[i] = br.readLine().toCharArray();
        }

        visited = new boolean[N][N];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (!visited[i][j]) {
                    bfs(i, j, map[i][j]);
                    ++count1;
                }
            }
        }

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (map[i][j] == 'R') map[i][j] = 'G';
            }
        }

        visited = new boolean[N][N];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (!visited[i][j]) {
                    bfs(i, j, map[i][j]);
                    ++count2;
                }
            }
        }
        System.out.println(count1 + " " + count2);
    }

    private static void bfs(int i, int j, char v) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(i, j));
        visited[i][j] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int d = 0; d < 4; ++d) {
                int nR = node.r + dir[d][0];
                int nC = node.c + dir[d][1];
                if (nR < 0 || nR >= N || nC < 0 || nC >= N) continue;
                if (!visited[nR][nC] && map[nR][nC] == v) {
                    visited[nR][nC] = true;
                    q.offer(new Node(nR, nC));
                }
            }
        }
    }
}
