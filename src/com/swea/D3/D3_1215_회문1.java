package com.swea.D3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_1215_회문1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("C:\\intelliJ_workspaces\\Algorithm\\src\\com\\swea\\D3\\testcase\\1215_input.txt"));

        for (int t = 1; t <= 10; ++t) {
            int L = Integer.parseInt(br.readLine());
            char[][] ch = new char[8][8];

            // 배열 채우기
            for (int i = 0; i < 8; ++i) {
                String s = br.readLine();
                for (int j = 0; j < 8; ++j) {
                    ch[i][j] = s.charAt(j);
                }
            }

            int count = 0;
            for (int s = 0; s < 8 - L + 1; ++s) {
                for (int i = 0; i < 8; ++i) {
                    // 가로
                    boolean hFlag = true;
                    for (int j = 0; j < L / 2; ++j) {
                        if (ch[i][s + j] != ch[i][s + L - 1 - j]) {
                            hFlag = false;
                            break;
                        }
                    }
                    if (hFlag) ++count;

                    boolean vFlag = true;
                    for (int j = 0; j < L / 2; ++j) {
                        if (ch[s + j][i] != ch[s + L - 1 - j][i]) {
                            vFlag = false;
                            break;
                        }
                    }
                    if (vFlag) ++count;
                }
            }

            System.out.println("#" + t + " " + count);
        }
    }
}
