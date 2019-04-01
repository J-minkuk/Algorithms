package com.swea.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
1
9
1 1 3 2 0 0 0 0 0
3 2 5 2 0 0 0 0 0
2 3 3 1 0 0 0 0 0
0 0 0 0 4 5 5 3 1
1 2 5 0 3 6 4 2 1
2 3 6 0 2 1 1 4 2
0 0 0 0 4 2 3 1 1
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
 */
public class D4_1258_행렬찾기_DFS {
    static int N;
    static int[][] map;
    static ArrayList<Matrix> list;

    static class Matrix {
        int r, c;

        public Matrix(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; ++t) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            for (int i = 0; i < N; ++i) {
                String[] s = br.readLine().split(" ");
                for (int j = 0; j < N; ++j) {
                    map[i][j] = Integer.parseInt(s[j]);
                }
//                System.out.println(Arrays.toString(map[i]));
            }

            list = new ArrayList<>();
            for (int r = 0; r < N; ++r) {
                for (int c = 0; c < N; ++c) {
                    if (map[r][c] != 0) {
                        dfs(r, c);
                    }
                }
            }
            Collections.sort(list, new Comparator<Matrix>() {
                @Override
                public int compare(Matrix o1, Matrix o2) {
                    int s1 = o1.c * o1.r;
                    int s2 = o2.c * o2.r;
                    if (s1 != s2) return s1 - s2;
                    else return o1.r - o2.r;
                }
            });

            System.out.print("#" + t + " " + list.size() + " ");
            for (Matrix m : list) {
                System.out.print(m.r + " " + m.c + " ");
            }
            System.out.println();
        }
    }

    private static void dfs(int r, int c) {
        int height = 0;
        int width = 0;
        for (int i = r; i < N; ++i) {
            if (map[i][c] == 0) {
                height = i - 1;
                break;
            }
            if (i == N - 1) height = i;
        }

        for (int i = c; i < N; ++i) {
            if (map[r][i] == 0) {
                width = i - 1;
                break;
            }
            if (i == N - 1) width = i;
        }

        for (int i = r; i <= height; ++i) {
            for (int j = c; j <= width; ++j) {
                map[i][j] = 0;
            }
        }

//        System.out.println();
//        for (int i = 0; i < N; ++i) {
//            System.out.println(Arrays.toString(map[i]));
//        }

//        System.out.println(height + " " + r + " " + width + " " + c);

        list.add(new Matrix(height - r + 1, width - c + 1));
    }
}
