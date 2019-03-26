package net.acmicpc.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P6593_상범빌딩_BFS_3차원 {
    private static int L, R, C;
    private static int startL, startR, startC;
    private static int endL, endR, endC;
    private static char[][][] map;
    private static int[][][] dis;
    private static int[][] dir = {
            {1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}
    };

    static class Node {
        int l, r, c, d;

        public Node(int l, int r, int c, int d) {
            this.l = l;
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String[] s = br.readLine().split(" ");
            L = Integer.parseInt(s[0]); // 층
            R = Integer.parseInt(s[1]); // 행
            C = Integer.parseInt(s[2]); // 열
            if (L == 0 && R == 0 && C == 0) break;

            map = new char[L][R][C];
            for (int i = 0; i < L; ++i) {
                for (int r = 0; r < R; ++r) {
                    map[i][r] = br.readLine().toCharArray();
                }
                br.readLine();
            }

            dis = new int[L][R][C];
            for (int i = 0; i < L; ++i) {
                for (int r = 0; r < R; ++r) {
                    for (int c = 0; c < C; ++c) {
                        if (map[i][r][c] == 'S') {
                            startL = i;
                            startR = r;
                            startC = c;
                        }
                        if (map[i][r][c] == 'E') {
                            endL = i;
                            endR = r;
                            endC = c;
                        }
                        dis[i][r][c] = Integer.MAX_VALUE;
                    }
                }
            }

            bfs();

            if (dis[endL][endR][endC] != Integer.MAX_VALUE)
                System.out.printf("Escaped in %d minute(s).\n", dis[endL][endR][endC]);
            else System.out.println("Trapped!");
        }
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(startL, startR, startC, 0));
        dis[startL][startR][startC] = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int d = 0; d < 6; ++d) {
                int nL = node.l + dir[d][0];
                int nR = node.r + dir[d][1];
                int nC = node.c + dir[d][2];
                if (nL >= L || nL < 0 || nR >= R || nC >= C || nR < 0 || nC < 0) continue;

                if (map[nL][nR][nC] == '.' || map[nL][nR][nC] == 'E') {
                    int tempDis = node.d + 1;
                    if (tempDis < dis[nL][nR][nC]) {
                        dis[nL][nR][nC] = tempDis;
                        q.offer(new Node(nL, nR, nC, tempDis));
                    }
                }
            }
        }
    }
}
