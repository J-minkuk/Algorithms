package com.swea.D3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D3_4466_최대성적표만들기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("C:\\intelliJ_workspaces\\Algorithm\\src\\com\\swea\\D3\\testcase\\4466input.txt"));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; ++t) {
            String[] str = br.readLine().split(" ");
            int N = Integer.parseInt(str[0]);
            int K = Integer.parseInt(str[1]);

            int[] scores = new int[N];
            String[] s = br.readLine().split(" ");
            for (int i = 0; i < N; ++i) {
                scores[i] = Integer.parseInt(s[i]);
            }

            Arrays.sort(scores);
            int[] result = Arrays.copyOfRange(scores, N - K, N);
            int sum = 0;
            for (int v : result) sum += v;
            System.out.println("#" + t + " " + sum);
        }
    }
}
