package net.acmicpc.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1026_보물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] A = new int[N];
        int[] B = new int[N];
        String[] a = br.readLine().split(" ");
        String[] b = br.readLine().split(" ");
        for (int i = 0; i < N; ++i) {
            A[i] = Integer.parseInt(a[i]);
            B[i] = Integer.parseInt(b[i]);
        }

        Arrays.sort(A);
        int[] result = new int[N];
        Arrays.fill(result, -1);

        int count = 0;
        while (count < N) {
            int max = Integer.MIN_VALUE;
            int idx = -1;

            for (int i = 0; i < N; ++i) {
                if (result[i] == -1 && max < B[i]) {
                    max = B[i];
                    idx = i;
                }
            }

            result[idx] = A[count++] * B[idx];
        }

        int sum = 0;
        for (int v : result) {
            sum += v;
        }
        System.out.println(sum);
    }
}
