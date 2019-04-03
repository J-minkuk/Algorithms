package net.acmicpc.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P7576_토마토_BFS_count {
    static int M, N, min;
    static int[][] tmt;
    static boolean perfect;
    static int[][] dir = {
            {-1, 0}, {1, 0}, {0, 1}, {0, -1}
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
        String[] MN = br.readLine().split(" ");
        M = Integer.parseInt(MN[0]);
        N = Integer.parseInt(MN[1]);
        tmt = new int[N][M];

        for (int i = 0; i < N; ++i) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < M; ++j) {
                tmt[i][j] = Integer.parseInt(s[j]);
            }
        }

        boolean flag = true;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (tmt[i][j] == 0) {
                    flag = false;
                    break;
                }
            }
            if (!flag) break;
        }

        if (flag) {
            System.out.println(0);
            return;
        }

        min = Integer.MAX_VALUE;
        perfect = true;
        bfs();

        if (perfect) System.out.println(min);
        else System.out.println(-1);
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        for (int r = 0; r < N; ++r) {
            for (int c = 0; c < M; ++c) {
                if (tmt[r][c] == 1) q.offer(new Node(r, c));
            }
        }

        int count = 0;
        while (!q.isEmpty()) {
            ++count;
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                Node node = q.poll();
                for (int d = 0; d < 4; ++d) {
                    int nR = node.r + dir[d][0];
                    int nC = node.c + dir[d][1];
                    if (nR < 0 || nC < 0 || nR >= N || nC >= M) continue;
                    if (tmt[nR][nC] == -1) continue;

                    if (tmt[nR][nC] == 0) {
                        tmt[nR][nC] = 1;
                        q.offer(new Node(nR, nC));
                    }
                }
            }
        }

        for (int r = 0; r < N; ++r) {
            for (int c = 0; c < M; ++c) {
                if (tmt[r][c] == 0) {
                    perfect = false;
                    break;
                }
            }
            if (!perfect) break;
        }

        min = Math.min(min, count - 1);
    }
}

/*
6 4
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 1

 */