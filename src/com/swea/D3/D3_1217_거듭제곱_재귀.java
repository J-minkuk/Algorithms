package com.swea.D3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class D3_1217_거듭제곱_재귀 {
    static int N;
    static long result;
    static long count;

    private static long multiply(int limit) {
        if (count == limit) return result *= N;
        else {
            result *= N;
            return multiply(--limit);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc1 = new Scanner(new FileReader("C:\\intelliJ_workspaces\\Algorithm\\src\\com\\swea\\D4\\testcase\\1217input.txt"));
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; ++i) {
            result = 1;
            count = 1;
            int t = sc.nextInt();
            N = sc.nextInt();
            int M = sc.nextInt(); // 곱하는 횟수

            result = multiply(M);
            System.out.println("#" + t + " " + result);
        }
    }
}
