package net.acmicpc.그리디;

import java.util.Arrays;
import java.util.Scanner;

public class P11508_2플러스1세일 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] ps = new int[N];
        for (int i = 0; i < N; ++i) {
            ps[i] = sc.nextInt();
        }
        Arrays.sort(ps);
//        System.out.println(Arrays.toString(ps));

        int totalPrice = 0;
        int idx = ps.length - 1;
        int loop = 0;
        while (idx >= 0) {
            ++loop;
            if (loop != 3) {
//                System.out.println(loop + " / " + idx + " / " + ps[idx]);
                totalPrice += ps[idx--];
            } else if (loop == 3) {
                loop = 0;
                idx--;
            }
        }
        System.out.println(totalPrice);
    }
}
