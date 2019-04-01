package net.acmicpc.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P14888_연산자끼워넣기_DFS {
    static int N, min, max;
    static int[] num;
    static int[] operator;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < N; ++i) {
            num[i] = Integer.parseInt(s[i]);
        }

        operator = new int[4];
        String[] o = br.readLine().split(" ");
        for (int i = 0; i < 4; ++i) {
            operator[i] += Integer.parseInt(o[i]);
        }

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        dfs(1, num[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int n, int sum) {
        // 0+ 1- 2* 3/
        for (int i = 0; i < 4; ++i) {
            if (operator[i] != 0) {
                --operator[i];
                switch (i) {
                    case 0:
                        dfs(n + 1, sum + num[n]);
                        break;
                    case 1:
                        dfs(n + 1, sum - num[n]);
                        break;
                    case 2:
                        dfs(n + 1, sum * num[n]);
                        break;
                    case 3:
                        dfs(n + 1, sum / num[n]);
                        break;
                }
                ++operator[i];
            }
        }
        if (n == N) {
            if (min > sum) min = sum;
            if (max < sum) max = sum;
        }
    }
}
