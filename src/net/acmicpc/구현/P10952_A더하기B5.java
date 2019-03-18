package net.acmicpc.구현;

import java.util.Scanner;

public class P10952_A더하기B5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == 0 && b == 0) break;
            System.out.println(a + b);
        }
    }
}
