package net.acmicpc.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1389_케빈베이컨의6단계법칙_플로이드워셜 {
    static int MAX = 9999999;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        int[][] adjMat = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; ++i) {
            for (int j = 1; j < N + 1; ++j) {
                if (i == j) continue;
                adjMat[i][j] = MAX;
            }
        }

        for (int i = 0; i < M; ++i) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            adjMat[a][b] = adjMat[b][a] = 1;
        }

        for (int m = 1; m < N + 1; ++m) {
            for (int s = 1; s < N + 1; ++s) {
                if (m == s) continue;
                for (int e = 1; e < N + 1; ++e) {
                    if (m == e || s == e) continue;
                    if (adjMat[s][m] + adjMat[m][e] < adjMat[s][e]) {
                        adjMat[s][e] = adjMat[e][s] = Math.min(adjMat[s][e], adjMat[s][m] + adjMat[m][e]);
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int idx = -1;
        for (int i = 1; i < N + 1; ++i) {
            int sum = 0;
            for (int j = 1; j < N + 1; ++j) {
                sum += adjMat[i][j];
            }
            if (min > sum) {
                min = sum;
                idx = i;
            }
        }
        System.out.println(idx);
    }
}
