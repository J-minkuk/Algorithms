package net.acmicpc.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11403_경로찾기_플로이드워셜 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim()); // 정점 수
        int[][] adjMat = new int[N][N];
        for (int i = 0; i < N; ++i) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < N; ++j) {
                adjMat[i][j] = Integer.parseInt(s[j]);
            }
        }

        for (int m = 0; m < N; ++m) {
            for (int s = 0; s < N; ++s) {
                for (int e = 0; e < N; ++e) {
                    if (adjMat[s][m] == 1 && adjMat[m][e] == 1) adjMat[s][e] = 1;
                }
            }
        }

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                System.out.print(adjMat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
