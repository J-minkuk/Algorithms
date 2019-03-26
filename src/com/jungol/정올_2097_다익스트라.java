package com.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class 정올_2097_다익스트라 {
    static int N, M;
    static int[][] graph;
    static int[] dis, path;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);    // 지하철 수
        M = Integer.parseInt(NM[1]);    // 목적지의 번호

        graph = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; ++i) {
            String[] s = br.readLine().split(" ");
            for (int j = 1; j < N + 1; ++j) {
                graph[i][j] = Integer.parseInt(s[j - 1]);
            }
        }


        dis = new int[N + 1];
        path = new int[N + 1];
        visited = new boolean[N + 1];

        dis[1] = 0;
        for (int i = 2; i < N + 1; ++i) {
            dis[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < N + 1; ++i) {
            int minNode = -1;
            int minVal = Integer.MAX_VALUE;

            for (int j = 1; j < N + 1; ++j) {
                if (!visited[j] && minVal > dis[j]) {
                    minNode = j;
                    minVal = dis[j];
                }
            }
            visited[minNode] = true;

            for (int j = 1; j < N + 1; ++j) {
                if (dis[j] > minVal + graph[minNode][j]) {
                    dis[j] = minVal + graph[minNode][j];
                    path[j] = minNode;
                }
            }
        }

        System.out.println(dis[M]);

        int idx = M;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(idx);
        while (true) {
            if (idx != 1) {
                list.add(path[idx]);
                idx = path[idx];
            }
            else break;
        }

        System.out.println(Arrays.toString(path));

        for (int i = list.size() - 1; i >= 0; --i) {
            System.out.print(list.get(i) + " ");
        }
    }
}
