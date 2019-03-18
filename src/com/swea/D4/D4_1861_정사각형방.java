package com.swea.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
4
13 2 14 12
10 16 6 5
1 8 3 15
7 11 4 9
 */
public class D4_1861_정사각형방 {
    static int N, max, sR, sC, V;
    static int[][] map;
    static Node[] arr;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    static class Node implements Comparable<Node> {
        int r, c, w;

        public Node(int r, int c, int w) {
            this.r = r;
            this.c = c;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; ++t) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            for (int i = 0; i < N; ++i) {
                String[] s = br.readLine().split(" ");
                for (int j = 0; j < N; ++j) {
                    map[i][j] = Integer.parseInt(s[j]);
                }
            }

            arr = new Node[N * N];
            int idx = 0;
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    arr[idx++] = new Node(i, j, map[i][j]);
                }
            }
            Arrays.sort(arr);

            max = Integer.MIN_VALUE;
            int temp = 0;
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < N; ++j) {
                    dfs(arr[temp].r, arr[temp].c, 1);
                    ++temp;
                }
            }

            System.out.println("#" + t + " " + map[sR][sC] + " " + max);
        }
    }

    private static void dfs(int r, int c, int count) {
        if (max < count) {
            sR = r;
            sC = c;
            max = count;
        }
        for (int d = 0; d < 4; ++d) {
            int nR = r + dir[d][0];
            int nC = c + dir[d][1];
            if (nR < 0 || nR >= N || nC < 0 || nC >= N) continue;

            if (map[nR][nC] + 1 == map[r][c]) dfs(nR, nC, count + 1);
        }
    }
}
