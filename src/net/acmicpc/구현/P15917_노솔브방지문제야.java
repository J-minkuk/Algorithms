package net.acmicpc.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P15917_노솔브방지문제야 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(br.readLine());
        int[] arr = new int[Q];
        for (int i = 0; i < Q; ++i) {
            arr[i] = Integer.parseInt(br.readLine().trim());
        }

        for (int i = 0; i < Q; ++i) {
            String s = Integer.toBinaryString(arr[i]);
            int count = 0;
            for (int j = 0; j < s.length(); ++j) {
                if (s.charAt(j) == '1') ++count;
            }
            if (count != 1) System.out.println(0);
            else System.out.println(1);
        }
    }
}
