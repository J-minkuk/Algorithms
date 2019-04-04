package net.acmicpc.탐색;

import java.util.Scanner;

public class P9663_NQueens_DFS {
    static int N;
    static boolean[] col, slash, bSlash;
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        col = new boolean[N + 1];
        slash = new boolean[2 * N + 1];    // 우상향
        bSlash = new boolean[2 * N + 1];    // 우하향

        count = 0;
        backTracking(1);

        System.out.println(count);
    }

    private static void backTracking(int row) {
        if (row > N) {    // 종료 조건
            ++count;
            return;
        }

        for (int i = 1; i <= N; ++i) {
            // 열, slash, bSlash 체크
            if (!col[i] && !slash[row + i] && !bSlash[N + row - i]) {    // 퀸을 놓을 수 있다면
                // 다음 행 퀸 Try
                col[i] = slash[row + i] = bSlash[N + row - i] = true;
                backTracking(row + 1);
                col[i] = slash[row + i] = bSlash[N + row - i] = false;
            }
        }
    }
}
