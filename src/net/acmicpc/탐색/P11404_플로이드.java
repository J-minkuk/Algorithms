package net.acmicpc.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11404_플로이드 {
    static int MAX = 9999999;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim()); // 도시 수
        int M = Integer.parseInt(br.readLine().trim()); // 버스 수
        int[][] adjMat = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; ++i) {
            for (int j = 1; j < N + 1; ++j) {
                adjMat[i][j] = MAX;
            }
        }

        for (int i = 1; i < M + 1; ++i) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);
            if (adjMat[a][b] > c) adjMat[a][b] = c;
        }

        for (int m = 1; m < N + 1; ++m) {
            for (int s = 1; s < N + 1; ++s) {
                if (m == s) continue;
                for (int e = 1; e < N + 1; ++e) {
                    if (m == e || s == e) continue;
                    if (adjMat[s][m] + adjMat[m][e] < adjMat[s][e]) adjMat[s][e] = adjMat[s][m] + adjMat[m][e];
                }
            }
        }

        for (int i = 1; i < N + 1; ++i) {
            for (int j = 1; j < N + 1; ++j) {
                if (adjMat[i][j] == MAX) System.out.print(0 + " ");
                else System.out.print(adjMat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
