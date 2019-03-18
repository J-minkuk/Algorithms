package com.swea.D4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D4_1210_Ladder1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("D:\\sts_projects\\Algorithm\\src\\com\\swea\\D4\\testcase\\1211_input.txt"));

        for (int testCase = 0; testCase < 10; ++testCase) {
            int testCaseNum = Integer.parseInt(br.readLine());
            int[][] arr = new int[100][100];
            int startCol = 0;
            int startRow = 0;

            // 입력값 2차원 배열로 만들기
            for (int x = 0; x < 100; ++x) {
                int inputsIdx = 0;
                String[] inputs = br.readLine().split(" ");
                for (int y = 0; y < 100; ++y) {
                    arr[x][y] = Integer.parseInt(inputs[inputsIdx++]);
                    if (arr[x][y] == 2) {
                        startCol = x;
                        startRow = y;
                    }
                }
            }

            while (startCol > 0) {
                arr[startCol][startRow] = 0;  // 방문 표시
                if ((startRow - 1) >= 0 && arr[startCol][startRow - 1] == 1) startRow--;  // 좌
                else if ((startRow + 1) < 100 && arr[startCol][startRow + 1] == 1) startRow++;  // 우
                else if ((startCol - 1) >= 0 && arr[startCol - 1][startRow] == 1) startCol--;
            }
            System.out.println("#" + testCaseNum + " " + startRow);
        }
    }
}
