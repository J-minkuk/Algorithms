package net.acmicpc.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P1697_숨바꼭질_BFS {
    static int N, K;
    static int sec;
    static boolean[] visited;

    static class Node {
        int point, dis;

        public Node(int point, int dis) {
            this.point = point;
            this.dis = dis;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");
        N = Integer.parseInt(NK[0]);    // 수빈 위치
        K = Integer.parseInt(NK[1]);    // 동생 위치

        visited = new boolean[100001];
        sec = Integer.MAX_VALUE;
        bfs();
        System.out.println(sec);
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(N, 0));
        visited[N] = true;

        while (!q.isEmpty()) {
            boolean flag = false;
            for (int i = 0; i < q.size(); ++i) {
                Node temp = q.poll();

                if (temp.point == K && temp.dis < sec) {
                    sec = temp.dis;
                    flag = true;
                }

                int m1 = temp.point + 1;
                int m2 = temp.point - 1;
                int m3 = temp.point * 2;
                int nD = temp.dis + 1;

                if (sec > nD) {
                    if (m1 <= 100000 && !visited[m1]) {
                        q.offer(new Node(m1, nD));
                        visited[m1] = true;
                    }
                    if (m2 >= 0 && !visited[m2]) {
                        q.offer(new Node(m2, nD));
                        visited[m2] = true;
                    }
                    if (m3 <= 100000 && !visited[m3]) {
                        q.offer(new Node(m3, nD));
                        visited[m3] = true;
                    }
                }
            }
            if (flag) break;
        }
    }
}
