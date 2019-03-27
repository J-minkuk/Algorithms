package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW모의_2105_디저트카페_DFS {
    private static int N, result;
    private static int[][] map;
    private static int[][] dir = {
            {1, 1}, {1, -1}, {-1, -1}, {-1, 1}
    };

    private static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t <= T; ++t) {
            N = Integer.parseInt(br.readLine().trim());
            map = new int[N][N];
            for (int i = 0; i < N; ++i) {
                String[] s = br.readLine().split(" ");
                for (int j = 0; j < N; ++j) {
                    map[i][j] = Integer.parseInt(s[j]);
                }
            }

            result = Integer.MIN_VALUE;
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    go(new Node(i, j), new Node(i, j), 0, String.valueOf(map[i][j]), 0);
                }
            }

            if (result == Integer.MIN_VALUE) System.out.println("#" + t + " " + -1);
            else System.out.println("#" + t + " " + result);
        }
    }

    private static void go(Node start, Node current, int dis, String path, int d) {
        if (d == 4) return;
        int nR = current.r + dir[d][0];
        int nC = current.c + dir[d][1];
        if (nR < 0 || nC < 0 || nR >= N || nC >= N) return;

        if (start.r == nR && start.c == nC) {
            result = Math.max(result, dis + 1);
            return;
        }

        String temp = String.valueOf(map[nR][nC]);
        String nS = path + " " + temp;
        Node node = new Node(nR, nC);

        boolean flag = true;
        String[] str = path.split(" ");
        for (String s : str) {
            if (s.equals(temp)) {
                flag = false;
                break;
            }
        }
        if (flag) {
            go(start, node, dis + 1, nS, d);
            go(start, node, dis + 1, nS, d + 1);
        }

    }
}
