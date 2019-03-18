package com.swea.D2;

import java.util.Scanner;

public class D2_2007_패턴마디의길이 {
    static int length;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for (int t = 1; t <= T; ++t) {
            length = 0;
            String input = sc.nextLine();
            for (int i = 2; i < input.length(); ++i) {
                String temp1 = input.substring(0, i);
                String temp2 = input.substring(i, i + i);
                if (temp1.equals(temp2)) {
                    length = temp1.length();
                    break;
                }
            }
            System.out.println("#" + t + " " + length);
        }
    }
}
