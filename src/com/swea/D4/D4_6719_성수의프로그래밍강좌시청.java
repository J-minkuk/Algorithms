package com.swea.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D4_6719_성수의프로그래밍강좌시청 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; ++t) {
            String[] NK = br.readLine().split(" ");
            int N = Integer.parseInt(NK[0]);
            int K = Integer.parseInt(NK[1]);

            int[] numbers = new int[N];
            String[] Vs = br.readLine().split(" ");
            for (int i = 0; i < N; ++i) {
                numbers[i] = Integer.parseInt(Vs[i]);
            }
            Arrays.sort(numbers);

            double R = 0;
            for (int i = N - K; i < N; ++i) {
                R = (R + numbers[i]) / 2;
            }
            System.out.printf("#%d %.6f\n", t, R);
        }
    }
}
