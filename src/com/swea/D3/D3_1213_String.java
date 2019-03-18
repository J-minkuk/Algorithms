package com.swea.D3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_1213_String {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    BufferedReader br1 = new BufferedReader(new FileReader("C:\\intelliJ_workspaces\\Algorithm\\src\\com\\swea\\D3\\testcase\\1213_input.txt"));

        for (int testCaseNum = 1; testCaseNum <= 10; ++testCaseNum) {
            int tc = Integer.parseInt(br.readLine());
            String input = br.readLine();
            String searchText = br.readLine();

            int inputLength = input.length();
            int count = 0;
            for (int i = 0; i <= searchText.length() - inputLength; ++i) {
                if (searchText.substring(i, i + inputLength).equals(input)) {
                    ++count;
                    i += inputLength - 1;
                }
            }
            System.out.println("#" + tc + " " + count);
        }
    }
}
