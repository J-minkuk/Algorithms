package net.acmicpc.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1931_회의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] seT = new int[N][2];
        int count = 0;
        int endTime = 0;
        for (int i = 0; i < N; ++i) {
            String[] t = br.readLine().split(" ");
            seT[i][0] = Integer.parseInt(t[0]);
            seT[i][1] = Integer.parseInt(t[1]);
        }

        Arrays.sort(seT, (seT1, seT2) ->
                seT1[1] == seT2[1] ? seT1[0] - seT2[0] : seT1[1] - seT2[1]);

        for (int i = 0; i < N; ++i) {
            if (seT[i][0] >= endTime) {
                ++count;
                endTime = seT[i][1];
            }
        }
        System.out.println(count);
    }
}
