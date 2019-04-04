package net.acmicpc.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1613_역사_플로이드워셜 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);
        int[][] adjMat = new int[N + 1][N + 1];
        for (int i = 0; i < K; ++i) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            adjMat[a][b] = 1;
        }

        for (int m = 1; m < N + 1; ++m) {
            for (int s = 1; s < N + 1; ++s) {
                if (m == s) continue;
                for (int e = 1; e < N + 1; ++e) {
                    if (m == e || s == e) continue;
                    if (adjMat[s][m] == 1 && adjMat[m][e] == 1) adjMat[s][e] = 1;
                }
            }
        }

        int S = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < S; ++i) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            if (adjMat[a][b] == 1 && adjMat[b][a] == 1 || adjMat[a][b] == 0 && adjMat[b][a] == 0) {
                System.out.println(0);
            } else if (adjMat[a][b] == 1) System.out.println(-1);
            else System.out.println(1);
        }
    }
}
