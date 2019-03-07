package com.swea.D3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D3_1244_DFS {
    static int N, result;
    static char[] chars;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; ++t) {
            result = 0;
            String[] s = br.readLine().split(" ");
            chars = s[0].toCharArray();
            N = Integer.parseInt(s[1]);

            dfs(0, 0);

            System.out.println("#" + t + " " + result);
        }
    }

    private static void dfs(int index, int count) {
        if (count == N) {
            result = Math.max(result, Integer.parseInt(String.valueOf(chars)));
            return;
        }

        for (int i = index; i < chars.length; ++i) {
            for (int j = i + 1; j < chars.length; ++j) {
                if (chars[j] >= chars[i]) {
                    swap(i, j);
                    dfs(i, count + 1);
                    swap(i, j);
                }
            }
        }
    }

    private static void swap(int a, int b) {
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }
}