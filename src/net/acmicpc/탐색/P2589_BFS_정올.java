package net.acmicpc.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2589_BFS_정올 {
    static int H, W;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static char[][] map;
    static int[][] distance;
    static ArrayList<Integer> list = new ArrayList<>();

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
        String[] HW = br.readLine().split(" ");
        H = Integer.parseInt(HW[0]);
        W = Integer.parseInt(HW[1]);
        map = new char[H][W];
        for (int i = 0; i < H; ++i) {
            map[i] = br.readLine().toCharArray();
//            System.out.println(Arrays.toString(map[i]));
        }

        for (int r = 0; r < H; ++r) {
            for (int c = 0; c < W; ++c) {
                if (map[r][c] == 'L') {
                    bfs(r, c);
                }
            }
        }

        Collections.sort(list);
//        System.out.println(list);
        System.out.println(list.get(list.size() - 1));
    }

    private static void bfs(int r, int c) {
//        System.out.println(r + " " + c);
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(r, c, 0));

        distance = new int[H][W];
        for (int i = 0; i < H; ++i) {
            for (int j = 0; j < W; ++j) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        distance[r][c] = 0;

        while(!q.isEmpty()) {
            Node node = q.poll();
            for (int d = 0; d < 4; ++d) {
                int nR = node.r + dir[d][0];
                int nC = node.c + dir[d][1];
                if (nR < 0 || nR >= H || nC < 0 || nC >= W) continue;

                if (map[nR][nC] == 'L') {
                    int tempDis = node.dis + 1;
                    if (tempDis < distance[nR][nC]) {
                        distance[nR][nC] = tempDis;
                        q.add(new Node(nR, nC, tempDis));
                    }
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < H; ++i) {
            for (int j = 0; j < W; ++j) {
                if (i == r && j == c || distance[i][j] == Integer.MAX_VALUE) continue;
                if (max < distance[i][j]) max = distance[i][j];
            }
        }

//        for (int i = 0; i < H; ++i) {
//            System.out.println(Arrays.toString(distance[i]));
//        }
//        System.out.println("max " + max);
        list.add(max);
    }
}
