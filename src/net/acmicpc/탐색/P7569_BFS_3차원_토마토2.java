package net.acmicpc.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P7569_BFS_3차원_토마토2 {
    static int M, N, H, max;
    static int[][][] tmt;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    static class Node {
        int h, r, c, day;

        public Node(int h, int r, int c, int day) {
            this.h = h;
            this.r = r;
            this.c = c;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] MNH = br.readLine().split(" ");
        M = Integer.parseInt(MNH[0]);
        N = Integer.parseInt(MNH[1]);
        H = Integer.parseInt(MNH[2]);
        tmt = new int[H][N][M];

        boolean flag = false;
        for (int h = 0; h < H; ++h) {
            for (int r = 0; r < N; ++r) {
                String[] s = br.readLine().split(" ");
                for (int c = 0; c < M; ++c) {
                    int v = Integer.parseInt(s[c]);
                    if (v == 0) flag = true;
                    tmt[h][r][c] = v;
                }
            }
        }

        if (!flag) {
            System.out.println(0);
            return;
        }

        for (int h = 0; h < H; ++h) {
            for (int r = 0; r < N; ++r) {
                for (int c = 0; c < M; ++c) {
                    if (tmt[h][r][c] == 0 && !dirCheck(h, r, c)) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        max = 0;
        bfs();
        System.out.println(max);

//        for (int h = 0; h < H; ++h) {
//            for (int r = 0; r < N; ++r) {
//                for (int c = 0; c < M; ++c) {
//                    System.out.print(tmt[h][r][c] + " ");
//                }
//                System.out.println();
//            }
//        }

    }

    private static boolean dirCheck(int h, int r, int c) {
        boolean check = false;
        for (int d = 0; d < 4; ++d) {
            int nR = r + dir[d][0];
            int nC = c + dir[d][1];
            if (nR < 0 || nR >= N || nC < 0 || nC >= M) continue;
            if (tmt[h][nR][nC] != -1) check = true;
        }

        if (h + 1 < H && tmt[h + 1][r][c] != -1) check = true;
        if (h - 1 >= 0 && tmt[h - 1][r][c] != -1) check = true;
        return check;
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        for (int h = 0; h < H; ++h) {
            for (int r = 0; r < N; ++r) {
                for (int c = 0; c < M; ++c) {
                    if (tmt[h][r][c] == 1) q.offer(new Node(h, r, c, 0));
                }
            }
        }

        while (!q.isEmpty()) {
            Node node = q.poll();
            max = Math.max(max, node.day);

            for (int d = 0; d < 4; ++d) {
                int nH = node.h;
                int nR = node.r + dir[d][0];
                int nC = node.c + dir[d][1];
                if (nR < 0 || nR >= N || nC < 0 || nC >= M) continue;

                if (tmt[nH][nR][nC] == 0) {
                    tmt[nH][nR][nC] = 1;
                    q.offer(new Node(nH, nR, nC, node.day + 1));
                }
            }

            if (node.h + 1 < H && tmt[node.h + 1][node.r][node.c] == 0) {
                tmt[node.h + 1][node.r][node.c] = 1;
                q.offer(new Node(node.h + 1, node.r, node.c, node.day + 1));
            }
            if (node.h - 1 >= 0 && tmt[node.h - 1][node.r][node.c] == 0) {
                tmt[node.h - 1][node.r][node.c] = 1;
                q.offer(new Node(node.h - 1, node.r, node.c, node.day + 1));
            }
        }
    }
}
