package net.acmicpc.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2606_바이러스_플로이드워셜 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int M = Integer.parseInt(br.readLine().trim());
        int[][] adjMat = new int[N + 1][N + 1];

        for (int i = 0; i < M; ++i) {
            String[] s = br.readLine().split(" ");
            int r = Integer.parseInt(s[0]);
            int c = Integer.parseInt(s[1]);
            adjMat[r][c] = adjMat[c][r] = 1;
        }

        for (int m = 1; m < N + 1; ++m) {
            for (int s = 1; s < N + 1; ++s) {
                if (m == s) continue;
                for (int e = 1; e < N + 1; ++e) {
                    if (m == e || m == s) continue;
                    if (adjMat[s][m] == 1 && adjMat[m][e] == 1) adjMat[s][e] = 1;
                }
            }
        }

        int count = 0;
        for (int j = 2; j < N + 1; ++j) {
            if (adjMat[1][j] == 1) ++count;
        }
        System.out.println(count);
    }
}
