package com.swea.D3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D3_1208_Flatten {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    BufferedReader br = new BufferedReader(new FileReader("C:\\intelliJ_workspaces\\Algorithm\\src\\com\\swea\\D3\\testcase\\1208input.txt"));

        for (int i = 0; i < 10; ++i) {
            int dumpsCount = Integer.parseInt(br.readLine());

            String[] temp = br.readLine().split(" ");
            int[] boxHeights = new int[temp.length];
            for (int j = 0; j < temp.length; ++j) {
                boxHeights[j] = Integer.parseInt(temp[j]);
            }
            Arrays.sort(boxHeights);

            for (int count = 0; count < dumpsCount; ++count) {
                if (boxHeights[boxHeights.length - 1] == boxHeights[0]) break;
                boxHeights[boxHeights.length - 1]--;
                boxHeights[0]++;
                Arrays.sort(boxHeights);
            }
            int result = boxHeights[boxHeights.length - 1] - boxHeights[0];
            System.out.println("#" + (i + 1) + " " + result);
        }
    }
}
