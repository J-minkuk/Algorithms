package com.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 정올_1082_화염에서탈출_BFS {
    static int R, C, dr, dc, result;
    static boolean flag;
    static char[][] map;
    static boolean[][] visited;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static Queue<Node> q, f;

    static class Node {
        int r, c, m;

        public Node(int r, int c, int m) {
            this.r = r;
            this.c = c;
            this.m = m;
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
//            System.out.println(Arrays.toString(map[i]));
        }

        q = new LinkedList<>();
        f = new LinkedList<>();
        for (int i = 0; i < R; ++i) {
            for (int j = 0; j < C; ++j) {
                if (map[i][j] == 'S') q.offer(new Node(i, j, 0));
                if (map[i][j] == '*') f.offer(new Node(i, j, 0));
                if (map[i][j] == 'D') {
                    dr = i; dc = j;
                }
            }
        }

        result = -1;
        flag = false;
        visited = new boolean[R][C];
        bfs();

        if (!flag) System.out.println("impossible");
        else System.out.println(result);
    }

    private static void bfs() {
        boolean check = true;

        while (check) {
            int fSize = f.size();
            for (int i = 0; i < fSize; ++i) {
                Node fnode = f.poll();
                for (int d = 0; d < 4; ++d) {
                    int nFR = fnode.r + dir[d][0];
                    int nFC = fnode.c + dir[d][1];
                    if (nFR < 0 || nFC < 0 || nFR >= R || nFC >= C) continue;
                    if (map[nFR][nFC] == '.') {
                        map[nFR][nFC] = '*';
                        f.offer(new Node(nFR, nFC, 0));
                    }
                }
            }

            int size = q.size();
            for (int i = 0; i < size; ++i) {
                Node node = q.poll();
                for (int d = 0; d < 4; ++d) {
                    int nR = node.r + dir[d][0];
                    int nC = node.c + dir[d][1];
                    if (nR < 0 || nC < 0 || nR >= R || nC >= C) continue;
                    if (map[nR][nC] == '*' || map[nR][nC] == 'X') continue;
                    if (map[nR][nC] == 'D') {
                        result = node.m + 1;
                        flag = true;
                        return;
                    }
                    if (!visited[nR][nC] && map[nR][nC] == '.') {
                        visited[nR][nC] = true;
                        q.offer(new Node(nR, nC, node.m + 1));
                    }
                }
            }

            if (q.size() == 0 && f.size() == 0) check = false;
        }
    }
}
