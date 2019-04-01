package net.acmicpc.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P14503_로봇청소기_DFS {
    static int N;
    static int M;
    static int[][] map;
    static int count;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        map = new int[N][M];

        String[] YXD = br.readLine().split(" ");
        int R = Integer.parseInt(YXD[0]);
        int C = Integer.parseInt(YXD[1]);
        int D = Integer.parseInt(YXD[2]);   // 0북 1동 2남 3서

        for (int i = 0; i < N; ++i) {
            String[] v = br.readLine().split(" ");
            for (int j = 0; j < M; ++j) {
                map[i][j] = Integer.parseInt(v[j]);
            }
//            System.out.println(Arrays.toString(map[i]));
        }

        count = 1;
        dfs(R, C, D);
        System.out.println(count);
    }

    private static void dfs(int r, int c, int d) {
        map[r][c] = 2;
        int newR, newC;
        for (int i = 0; i < 4; ++i) {
            d = (d + 3) % 4;    // 왼쪽 방향 계산
            newR = r + dir[d][0];
            newC = c + dir[d][1];

            if (newR >= 0 && newR < N && newC >= 0 && newC < M && map[newR][newC] == 0) {
                count++;
                dfs(newR, newC, d);
                return;
            }
        }

        // 후진
        int back = (d + 2) % 4; // 후진 방향 계산
        newR = r + dir[back][0];
        newC = c + dir[back][1];
        if (newR >= 0 && newR < N && newC >= 0 && newC < M && map[newR][newC] != 1) dfs(newR, newC, d);
    }
}
