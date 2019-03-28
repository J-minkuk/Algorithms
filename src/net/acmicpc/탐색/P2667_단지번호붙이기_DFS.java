package net.acmicpc.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class P2667_단지번호붙이기_DFS {
    static int N, count = 0;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; ++i) {
            String s = br.readLine();
            for (int j = 0; j < N; ++j) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        list = new ArrayList<>();
        visited = new boolean[N][N];
        for (int r = 0; r < N; ++r) {
            for (int c = 0; c < N; ++c) {
                if (!visited[r][c] && map[r][c] == 1) list.add(dfs(r, c));
                count = 0;
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (int v : list) {
            System.out.println(v);
        }
    }

    private static int dfs(int r, int c) {
        visited[r][c] = true;
        ++count;

        for (int d = 0; d < 4; ++d) {
            int nR = r + dir[d][0];
            int nC = c + dir[d][1];
            if (nR >= 0 && nR < N && nC >= 0 && nC < N &&
                    !visited[nR][nC] && map[nR][nC] == 1) dfs(nR, nC);
        }
        return count;
    }
}
