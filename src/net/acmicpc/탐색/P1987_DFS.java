package net.acmicpc.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class P1987_DFS {
    static int N, M, max = 0;
    static char[][] map;
    static HashMap<Character, Boolean> check;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        map = new char[N][M];
        check = new HashMap<>();
        for (int i = 0; i < N; ++i) {
            map[i] = br.readLine().toCharArray();
//            System.out.println(Arrays.toString(map[i]));
        }

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                check.put(map[i][j], false);
            }
        }

        check.put(map[0][0], true);
        dfs1(0, 0, 1);
        System.out.println(max);
//        System.out.println(dfs(0, 0));
    }

    private static int dfs(int r, int c) {
        int count = 0;
        for (int d = 0; d < 4; ++d) {
            int nR = r + dir[d][0];
            int nC = c + dir[d][1];
            if (nR >= 0 && nR < N && nC >= 0 && nC < M && !check.get(map[nR][nC])) {
                check.put(map[nR][nC], true);
                count = Math.max(count, dfs(nR, nC));
            }
        }
        check.put(map[r][c], false);
        return count + 1;
    }

    private static void dfs1(int r, int c, int count) {
        for (int d = 0; d < 4; ++d) {
            int nR = r + dir[d][0];
            int nC = c + dir[d][1];
            if (nR >= 0 && nR < N && nC >= 0 && nC < M && !check.get(map[nR][nC])) {
                check.put(map[nR][nC], true);
                dfs1(nR, nC, count + 1);
            }
        }
        check.put(map[r][c], false);
        if (max < count) max = count;
        return;
    }
}
