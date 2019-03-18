package net.acmicpc.문자열처리;

import java.util.Scanner;

/**
 * 상수
 */
public class P2908_상수 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        String strA = reverseString(String.valueOf(a));
        String strB = reverseString(String.valueOf(b));

        if (Integer.parseInt(strA) > Integer.parseInt(strB)) {
            System.out.println(strA);
        } else {
            System.out.println(strB);
        }

    }

    static String reverseString(String str) {
        StringBuilder sb = new StringBuilder();
        return sb.append(str).reverse().toString();
    }
}
