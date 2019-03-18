package com.swea.D3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class D3_1225_암호생성기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\sts_projects\\Algorithm\\src\\com\\swea\\D3\\testcase\\1225input.txt"));
        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));

        int[] subs = {1, 2, 3, 4, 5};
        int size = subs.length;
        int T = 10;

        for (int t = 1; t <= T; ++t) {
            br.readLine();

            Queue<Integer> q = new LinkedList<>();
            String[] s = br.readLine().split(" ");
            for (int i = 0; i < s.length; ++i) {
                q.offer(Integer.parseInt(s[i]));
            }

            boolean flag = true;
            while (flag) {
                for (int j = 0; j < size; ++j) {
                    int temp = q.poll() - subs[j];
                    if (temp <= 0) {
                        q.offer(0);
                        flag = false;
                        break;
                    } else q.offer(temp);
                }
                if (!flag) break;
            }

            System.out.print("#" + t + " ");
            for (int v : q) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}
