package com.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 정올_1863_종교_DFS {
    static int N, M;
    static boolean[] visited;
    static int[] check;
    static ArrayList<Integer>[] list;
    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);

        check = new int[N + 1];
        visited = new boolean[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 0; i <= N; ++i) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; ++i) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            list[a].add(b);
            list[b].add(a);
        }

        q = new LinkedList<>();
        int count = 0;
        for (int i = 1; i <= N; ++i) {
            q.clear();
            if (!visited[i]) ++count;
            bfs(i, count);
        }

        int max = 0;
        for (int result : check) {
            max = Math.max(result, max);
        }
        System.out.println(max);
    }

    private static void bfs(int i, int count) {
        if (!visited[i]) {
            q.offer(i);
            visited[i] = true;
            check[i] = count;
        }

        while (!q.isEmpty()) {
            int qIdx = q.poll();
            for (int temp : list[qIdx]) {
                if (!visited[temp]) {
                    q.offer(temp);
                    visited[temp] = true;
                    check[temp] = count;
                }
            }
        }
    }
}
