package net.acmicpc.시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P14647 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[][] map = new int[n][m];
        for (int i = 0; i < n; ++i) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < m; ++j) {
                map[i][j] = Integer.parseInt(s[j]);
            }
//            System.out.println(Arrays.toString(map[i]));
        }

        int[] r = new int[n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                String s1 = String.valueOf(map[i][j]);
                if (s1.length() == 1 && s1.equals("9")) r[i]++;
                else {
                    for (int k = 0; k < s1.length(); ++k) {
                        if (s1.charAt(k) == '9') r[i]++;
                    }
                }
            }
        }

        int[] c = new int[m];
        for (int j = 0; j < m; ++j) {
            for (int i = 0; i < n; ++i) {
                String s2 = String.valueOf(map[i][j]);
                if (s2.length() == 1 && s2.equals("9")) c[j]++;
                else {
                    for (int k = 0; k < s2.length(); ++k) {
                        if (s2.charAt(k) == '9') c[j]++;
                    }
                }
            }
        }
//        System.out.println(Arrays.toString(r));
//        System.out.println(Arrays.toString(c));

        int max = -1;
        int idx = 0;
        for (int i = 0; i < n; ++i) {
            if (max < r[i]) {
                max = r[i];
                idx = i;
            }
        }

        boolean flag = false;
        for (int j = 0; j < m; ++j) {
            if (max < c[j]) {
                max = c[j];
                idx = j;
                flag = true;
            }
        }

        if (flag) {
            int sum = 0;
            for (int j = 0; j < m; ++j) {
                if (j == idx) continue;
                sum += c[j];
            }
            System.out.println(sum);
        } else {
            int sum = 0;
            for (int i = 0; i < n; ++i) {
                if (i == idx) continue;
                sum += r[i];
            }
            System.out.println(sum);
        }
    }
}
