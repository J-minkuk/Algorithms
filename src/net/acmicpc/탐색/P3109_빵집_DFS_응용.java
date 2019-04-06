package net.acmicpc.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P3109_빵집_DFS_응용 {
    static int R, C, ans;
    static char[][] map;
    static boolean flag;
    static boolean[][] visited;
    static int[][] dir = {{-1, 1}, {0, 1}, {1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] RC = br.readLine().split(" ");
        R = Integer.parseInt(RC[0]);
        C = Integer.parseInt(RC[1]);
        map = new char[R][C];
        for (int i = 0; i < R; ++i) {
            map[i] = br.readLine().toCharArray();
        }

        visited = new boolean[R][C];
        ans = 0;
        for (int i = 0; i < R; ++i) {
            flag = false;
            dfs(i, 0);
        }
        System.out.println(ans);
    }

    private static void dfs(int r, int c) {
        visited[r][c] = true;
        if (c == C - 1) {
            ans++;
            flag = true;
            return;
        }

        for (int d = 0; d < 3; ++d) {
            int nR = r + dir[d][0];
            int nC = c + dir[d][1];
            if (nR >= R || nC >= C || nR < 0 || nC < 0) continue;
            if (map[nR][nC] == 'x') continue;
            if (!visited[nR][nC] && map[nR][nC] == '.') {
                if (flag) return;
                dfs(nR, nC);
            }
        }
    }
}
