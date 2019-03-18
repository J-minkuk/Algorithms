package com.swea.D3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_5549_홀수일까짝수일까 {
    public static void main(String[] args) throws IOException {
        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("C:\\intelliJ_workspaces\\Algorithm\\src\\com\\swea\\D3\\testcase\\5549input.txt"));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; ++t) {
            String n = br.readLine();
            int end = n.length() - 1;
            char c = n.charAt(end);
            int value = Character.getNumericValue(c);
            if (value % 2 == 0) System.out.println("#" + t + " Even");
            else if (value % 2 == 1) System.out.println("#" + t + " Odd");
        }
    }
}
