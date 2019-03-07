package net.acmicpc.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P16957_BFS_PriorityQueue {
    static int R, C;
    static int[][] map;
    static int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
    static PriorityQueue<Node> temp = new PriorityQueue<>();
    static Stack<Node> stack = new Stack<>();
    static int[][] count;

    static class Node implements Comparable<Node> {
        int r, c, num;

        public Node(int r, int c, int num) {
            this.r = r;
            this.c = c;
            this.num = num;
        }

        @Override
        public int compareTo(Node o) {
            return this.num - o.num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] RC = br.readLine().split(" ");
        R = Integer.parseInt(RC[0]);
        C = Integer.parseInt(RC[1]);
        map = new int[R][C];
        for (int i = 0; i < R; ++i) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < C; ++j) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        for (int i = 0; i < R; ++i) {
            for (int j = 0; j < C; ++j) {
                temp.offer(new Node(i, j, map[i][j]));
            }
        }

        // 내림차순으로 다시 큐에 저장
        while (!temp.isEmpty()) {
            stack.push(temp.poll());
        }

        count = new int[R][C];
        for (int i = 0; i < R; ++i) {
            Arrays.fill(count[i], 1);
        }
        bfs();

        for (int i = 0; i < R; ++i) {
            for (int j = 0; j < C; ++j) {
                System.out.print(count[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void bfs() {
        while (!stack.isEmpty()) {
            int min = Integer.MAX_VALUE;
            Node node = stack.pop();
            int mR = -1;
            int mC = -1;

            // 8방향에서 최소값 좌표 찾기
            for (int d = 0; d < 8; ++d) {
                int nR = node.r + dir[d][0];
                int nC = node.c + dir[d][1];
                if (nR < 0 || nR >= R || nC < 0 || nC >= C) continue;
                if (count[nR][nC] == 0) continue;

                if (min > map[nR][nC]) {
                    min = map[nR][nC];
                    mR = nR;
                    mC = nC;
                }
            }

            if (mR != -1 && mC != -1) {
                count[mR][mC] += count[node.r][node.c];
                count[node.r][node.c] = 0;
            }
        }
    }
}
