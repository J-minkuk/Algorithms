package net.acmicpc.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P3184_양_BFS {
    static int R, C, resultO, resultV;
    static char[][] map;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;

    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] RC = br.readLine().split(" ");
        R = Integer.parseInt(RC[0]);
        C = Integer.parseInt(RC[1]);
        map = new char[R][C];
        for (int i = 0; i < R; ++i) {
            map[i] = br.readLine().toCharArray();
        }

        resultO = 0;
        resultV = 0;
        visited = new boolean[R][C];
        for (int i = 0; i < R; ++i) {
            for (int j = 0; j < C; ++j) {
                if (!visited[i][j] && map[i][j] != '#') bfs(i, j);
            }
        }
        System.out.println(resultO + " " + resultV);
    }

    private static void bfs(int i, int j) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(i, j));

        int vCount = 0;
        int oCount = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();
            int r = node.r;
            int c = node.c;
            if (map[r][c] == 'v') ++vCount;
            else if (map[r][c] == 'o') ++oCount;
            visited[i][j] = true;

            for (int d = 0; d < 4; ++d) {
                int nR = r + dir[d][0];
                int nC = c + dir[d][1];

                if (nR < 0 || nC < 0 || nR >= R || nC >= C) continue;
                if (visited[nR][nC] || map[nR][nC] == '#') continue;

                q.offer(new Node(nR, nC));
                visited[nR][nC] = true;
            }
        }

        if (oCount > vCount) resultO += oCount;
        else resultV += vCount;
    }
}
