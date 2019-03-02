package net.acmicpc.수학;

import java.util.Scanner;

/**
 * GCD(n, k) = 1
 */
public class P11689_오일러공식 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long pi = n;
        long prime = 2;

        while (prime * prime <= n) {
            if (n % prime == 0) pi = pi / prime * (prime - 1);
            while (n % prime == 0) {    // n에 prime 소인수를 전부 제거
                n = n / prime;
            }
            ++prime;
        }

        // 소인수가 남아있다면
        if (n != 1) pi = pi / n * (n - 1);

        System.out.println(pi);
    }

}
