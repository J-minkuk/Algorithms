package net.acmicpc.시뮬레이션;

import java.util.Scanner;

/**
 * 숫자의 개수
 */
public class P2577_숫자의개수 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int multiple = a * b * c;
        String str = String.valueOf(multiple);
        int[] numbers = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (int i = 0; i < str.length(); ++i) {
            int temp = Integer.parseInt(String.valueOf(str.charAt(i)));
            numbers[temp]++;
        }

        for (int value : numbers) {
            System.out.println(value);
        }

    }

}
