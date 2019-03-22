package com.swea.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
1
0 1 1 0 0 0 0 0 1 0
128

3
0 1 1 0 0 1 0 0 0 0
60
1 1 1 1 1 1 1 1 1 1
128
0 1 0 1 0 1 0 1 0 1
128
 */
public class D4_1808_지희의고장난계산기 {
    static boolean[] activeNumbers;
    static int count;
    static String X;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; ++t) {
            String[] str = br.readLine().split(" ");
            activeNumbers = new boolean[10];

            for (int i = 0; i < 10; ++i) {
                if (Integer.parseInt(str[i]) == 1) activeNumbers[i] = true;
            }
            X = br.readLine();
            list = new ArrayList<>();
            count = 1;  // 계산 1번 무조건 포함

            for (int i = 1; i <= X.length(); ++i) {
                int[] arr = new int[i];
                permutation(0, i, arr);
            }

            while (true) {
                if (perfect()) {
                    count += X.length();
                    break;
                }

                boolean flag = false;
                for (int i = list.size() - 1; i >= 0; --i) {
                    int x = Integer.parseInt(X);
                    int v = list.get(i);

                    if (v != 1 && v != 0 && x % v == 0) {
//                        System.out.println(list.get(i));
                        x = x / v;
                        X = String.valueOf(x);
                        count += String.valueOf(v).length();
                        ++count;
                        flag = true;
                        break;
                    }
                }

                if (!flag) {
                    count = -1;
                    break;
                }
            }

            System.out.println("#" + t + " " + count);
        }
    }

    private static boolean perfect() {
        boolean flag = true;
        for (int i = 0; i < X.length(); ++i) {
            if (!activeNumbers[X.charAt(i) - '0']) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    private static void permutation(int count, int n, int[] arr) {
        if (count == n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; ++i) {
                sb.append(arr[i]);
            }
//            System.out.println(sb.toString());
            list.add(Integer.parseInt(sb.toString()));
            return;
        }

        for (int i = 0; i < 10; ++i) {
            if (activeNumbers[i]) {
                arr[count] = i;
                permutation(count + 1, n, arr);
            }
        }
    }
}
