package com.estsoft;

public class 상반기_2019_3번 {
  private final static int[] dr = {-1, -1, -1};
  private final static int[] dc = {-1, 0, 1};
  private static char[][] area;
  private static int N;

  private static int dfs(int r, int c) {
    int result = 0;

    for (int i = 0; i < 3; ++i) {
      int nr = r + dr[i];
      int nc = c + dc[i];
      if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
      if (i == 1) {
        if (area[nr][nc] == '.') result = Math.max(result, dfs(nr, nc));
      } else {
        int nnr = nr + dr[i];
        int nnc = nc + dc[i];
        if (area[nr][nc] == 'X') {
          if (nnr >= 0 && nnc >= 0 && nnr < N && nnc < N && area[nnr][nnc] != 'X') {
            result = Math.max(result, dfs(nnr, nnc) + 1);
          }
        } else result = Math.max(result, dfs(nr, nc));
      }
    }
    return result;
  }

  private static int solution(String[] B) {
    int sr = 0;
    int sc = 0;
    N = B.length;
    area = new char[N][N];

    for (int i = 0; i < N; ++i) {
      for (int j = 0; j < N; ++j) {
        area[i][j] = B[i].charAt(j);
        if (area[i][j] == 'O') {
          sr = i;
          sc = j;
        }
      }
    }
    return dfs(sr, sc);
  }


  public static void main(String[] args) {
    String[] ranks = new String[6];

    ranks[0] = "..X...";
    ranks[1] = "......";
    ranks[2] = "....X.";
    ranks[3] = ".X....";
    ranks[4] = "..X.X.";
    ranks[5] = "...O..";
    System.out.println(solution(ranks));
  }
}