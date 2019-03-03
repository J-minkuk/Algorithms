package net.acmicpc.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * SWEA - D4_1249 (보급로)와 유사함
 */
public class P1261_BFS_클래스활용 {
    static int N, M;
    static char[][] map;
    static int[][] dis;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0 ,1}};

    static class Node {
        public int r, c, dis;
        public Node(int r, int c, int dis) {
            this.r = r;
            this.c = c;
            this.dis = dis;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        M = Integer.parseInt(NM[0]);    // 가로
        N = Integer.parseInt(NM[1]);    // 세로
        map = new char[N][M];
        dis = new int[N][M];

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                dis[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < N; ++i) {
            map[i] = br.readLine().toCharArray();
//            System.out.println(Arrays.toString(map[i]));
//            System.out.println(Arrays.toString(dis[i]));
        }

        bfs();
        System.out.println(dis[N - 1][M - 1]);
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0));
        dis[0][0] = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int d = 0; d < 4; ++d) {
                int nR = node.r + dir[d][0];
                int nC = node.c + dir[d][1];
                if (nR < 0 || nR >= N || nC < 0 || nC >= M) continue;

                int tempDis = node.dis + (map[nR][nC] - '0');
                if (tempDis < dis[nR][nC]) {
                    dis[nR][nC] = tempDis;
                    q.add(new Node(nR, nC, tempDis));
                }
            }
        }
    }
}
