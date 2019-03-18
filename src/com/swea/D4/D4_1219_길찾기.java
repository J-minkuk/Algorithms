package com.swea.D4;

import java.util.Scanner;

public class D4_1219_길찾기 {
    static int[] arr1;
    static int[] arr2;
    static boolean flag;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = 10;
        for (int t = 1; t <= T; ++t) {
            int tNum = sc.nextInt();
            int length = sc.nextInt();
            arr1 = new int[100];
            arr2 = new int[100];
            for (int i = 0; i < length; ++i) {
                int idx = sc.nextInt();
                int value = sc.nextInt();
                if (arr1[idx] == 0) arr1[idx] = value;
                else arr2[idx] = value;
            }

            flag = false;
            dfs(0);
            if (flag) System.out.println("#" + tNum + " " + 1);
            else System.out.println("#" + tNum + " " + 0);
        }
    }

    private static void dfs(int index) {
        if (arr1[index] == 99 || arr2[index] == 99) flag = true;
        else {
            if (arr1[index] != 0) dfs(arr1[index]);
            if (arr2[index] != 0) dfs(arr2[index]);
        }
    }
}
