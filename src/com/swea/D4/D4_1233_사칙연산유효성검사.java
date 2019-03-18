package com.swea.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D4_1233_사칙연산유효성검사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;
        for (int t = 1; t <= T; ++t) {
            int N = Integer.parseInt(br.readLine());
            boolean flag = true;

            for (int i = 1; i <= N / 2; ++i) {
                String[] str = br.readLine().split(" ");
                String value = str[1];
                if (!(value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/"))) flag = false;
            }

            for (int i = N / 2 + 1; i <= N; ++i) {
                String[] str = br.readLine().split(" ");
                String value = str[1];
                if (value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/")) flag = false;
            }

            if (flag) System.out.println("#" + t + " " + 1);
            else System.out.println("#" + t + " " + 0);
        }
    }
}
