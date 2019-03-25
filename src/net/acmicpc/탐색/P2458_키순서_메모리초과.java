package net.acmicpc.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P2458_키순서_메모리초과 {
    static int N, M;
    static int[][] adjMat;
    static int[] answer;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);    // 학생 수
        M = Integer.parseInt(NM[1]);    // 두 학생을 비교한 횟수
        adjMat = new int[N + 1][N + 1];
        answer = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; ++i) {
            String[] s = br.readLine().split(" ");
            int r = Integer.parseInt(s[0]);
            int c = Integer.parseInt(s[1]);
            adjMat[r][c] = 1;
        }

        for (int i = 1; i < N + 1; ++i) {
            for (int j = 1; j < N + 1; ++j) {
                if (adjMat[i][j] == 1) ++answer[i];
            }
        }

        for (int i = 1; i < N + 1; ++i) {
            if (!visited[i]) connect(i);
        }

        for (int i = 1; i < N + 1; ++i) {
            for (int j = 1; j < N + 1; ++j) {
                if (adjMat[i][j] == 1) ++answer[j];
            }
        }

        int result = 0;
        for (int i = 1; i < N + 1; ++i) {
            if (answer[i] == N - 1) ++result;
        }

        System.out.println(result);
    }

    private static void connect(int student) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(student);

        while (!q.isEmpty()) {
            int temp = q.poll();
            if (visited[temp]) continue;
            visited[temp] = true;

            for (int i = 1; i < N + 1; ++i) {
                if (temp == i) continue;
                if (adjMat[temp][i] == 1) {
                    for (int j = 1; j < N + 1; ++j) {
                        if (adjMat[i][j] == 1) {
                            adjMat[student][j] = 1;
                            q.offer(j);
                        }
                    }
                }
            }
        }
    }
}
