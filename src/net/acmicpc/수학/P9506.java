package net.acmicpc.수학;

import java.util.ArrayList;
import java.util.Scanner;

public class P9506 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int N = sc.nextInt();
            if (N == -1) break;

            ArrayList<Integer> list = new ArrayList<>();
            int sum = 0;
            for (int i = 1; i < N; ++i) {
                if (N % i == 0) {
                    sum += i;
                    list.add(i);
                }
            }

            if (sum == N) {
                System.out.print(sum + " = ");
                for (int i = 0; i < list.size(); ++i) {
                    if (i == list.size() - 1) System.out.println(list.get(i));
                    else System.out.print(list.get(i) + " + ");
                }
            } else System.out.println(N + " is NOT perfect.");
        }
    }
}
