package net.acmicpc.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1476_날짜계산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int E = Integer.parseInt(str[0]); // 1 ~ 15
        int S = Integer.parseInt(str[1]); // 1 ~ 28
        int M = Integer.parseInt(str[2]); // 1 ~ 19

        int[] arr = {1, 1, 1};
        int year = 1;

        while (true) {
            if (E == arr[0] && S == arr[1] && M == arr[2]) {
                System.out.println(year);
                break;
            } else {
                ++year;
                arr[0] = arr[0] % 15 + 1;
                arr[1] = arr[1] % 28 + 1;
                arr[2] = arr[2] % 19 + 1;
            }
        }
    }
}
