package net.acmicpc.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1149_RGB거리_DP {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[][] RGB = new int[N][3];
        for (int i = 0; i < N; ++i) {
            String[] c = br.readLine().split(" ");
            RGB[i][0] = Integer.parseInt(c[0]);
            RGB[i][1] = Integer.parseInt(c[1]);
            RGB[i][2] = Integer.parseInt(c[2]);
        }

        for (int i = 1; i < N; ++i) {
            RGB[i][0] = RGB[i][0] + Math.min(RGB[i - 1][1], RGB[i - 1][2]);
            RGB[i][1] = RGB[i][1] + Math.min(RGB[i - 1][0], RGB[i - 1][2]);
            RGB[i][2] = RGB[i][2] + Math.min(RGB[i - 1][0], RGB[i - 1][1]);
        }

        System.out.println(Math.min(RGB[N - 1][0], Math.min(RGB[N - 1][1], RGB[N - 1][2])));
    }
}
