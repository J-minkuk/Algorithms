package com.swea.D1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class D1_2072_홀수만더하기 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("C:\\intelliJ_workspaces\\Algorithm\\src\\com\\swea\\D1\\testcase\\2072input.txt"));
        Scanner sc1 = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 1; t <= T; ++t) {
            int sum = 0;
            for (int i = 0; i < 10; ++i) {
                int num = sc.nextInt();
                if (num % 2 == 1) sum += num;
            }
            System.out.println("#" + t + " " + sum);
        }
    }
}
