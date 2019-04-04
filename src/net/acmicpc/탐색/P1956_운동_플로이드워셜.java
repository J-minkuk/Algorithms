package net.acmicpc.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1956_운동_플로이드워셜 {
    static int MAX = 9999999;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] VE = br.readLine().split(" ");
        int V = Integer.parseInt(VE[0]);
        int E = Integer.parseInt(VE[1]);
        int[][] adjMat = new int[V + 1][V + 1];
        for (int i = 1; i < V + 1; ++i) {
            for (int j = 1; j < V + 1; ++j) {
                adjMat[i][j] = MAX;
            }
        }

        for (int j = 0; j < E; ++j) {
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            int c = Integer.parseInt(s[2]);
            adjMat[a][b] = c;
        }

        for (int m = 1; m < V + 1; ++m) {
            for (int s = 1; s < V + 1; ++s) {
                for (int e = 1; e < V + 1; ++e) {
                    if (adjMat[s][m] + adjMat[m][e] < adjMat[s][e]) {
                        adjMat[s][e] = Math.min(adjMat[s][e], adjMat[s][m] + adjMat[m][e]);
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i < V + 1; ++i) {
            answer = Math.min(answer, adjMat[i][i]);
        }


        if (answer == MAX) System.out.println(-1);
        else System.out.println(answer);
    }
}
