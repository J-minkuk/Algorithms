package net.acmicpc.수학;

import java.util.Scanner;

/**
 * 더하기 사이클
 */
public class P1110_더하기사이클 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        int fixValue = value;
        boolean flag = true;
        int count = 0;

        while (flag) {
            int left = value / 10;
            int right = value % 10;
            int newRight = (left + right) % 10;
            value = (right * 10) + newRight;
            if (fixValue == value) {
                flag = false;
            }
            count++;
        }
        System.out.println(count);

    }

}
