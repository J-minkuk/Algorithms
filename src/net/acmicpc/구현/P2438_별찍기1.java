package net.acmicpc.구현;

import java.util.Scanner;

/**
 * 별찍기 - 1
 */
public class P2438_별찍기1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();

        for (int i = 1; i <= a; ++i) {
            for (int j = 1; j <= i; ++j) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

}
