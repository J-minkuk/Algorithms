package com.swea.SW;

import java.util.Scanner;

/*
10
10 40 100 300
0 0 2 9 1 5 0 0 0 0 0 0
10 100 50 300
0 0 0 0 0 0 0 0 6 2 7 8
10 70 180 400
6 9 7 7 7 5 5 0 0 0 0 0
10 70 200 550
0 0 0 0 8 9 6 9 6 9 8 6
10 80 200 550
0 8 9 15 1 13 2 4 9 0 0 0
10 130 360 1200
0 0 0 15 14 11 15 13 12 15 10 15
10 180 520 1900
0 18 16 16 19 19 18 18 15 16 17 16
10 100 200 1060
12 9 11 13 11 8 6 12 8 7 15 6
10 170 500 1980
19 18 18 17 15 19 19 16 19 15 17 18
10 200 580 2320
12 28 24 24 29 25 23 26 26 28 27 22

 */
public class SW모의_P1952_수영장_DFS {
    static int day, month1, month3, year, min;
    static int[] plan;

    public static void dfs(int idx, int sum) {
        if (idx > 13) return;
        if (idx == 13) {
            if (min > sum && sum != 0) min = sum;
            return;
        }
        dfs(idx + 1, sum + plan[idx] * day);
        dfs(idx + 1, sum + month1);
        dfs(idx + 3, sum + month3);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; ++t) {
            day = sc.nextInt();
            month1 = sc.nextInt();
            month3 = sc.nextInt();
            year = sc.nextInt();

            plan = new int[13];
            for (int i = 1; i < 13; ++i) {
                plan[i] = sc.nextInt();
            }

            min = year;
            dfs(0, 0);
            System.out.println("#" + t + " " + min);
        }
    }
}