package coding.test.line.s2019;

import java.util.Scanner;

public class Solution1 {
    static long N;
    static long tempN;
    static long min = Long.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextLong();
        tempN = (long) Math.sqrt(N);

        for (long i = tempN; i > 0; --i) {
            boolean flag = false;
            for (long j = N / tempN; j <= N; ++j) {
                if (i * j == N) {
                    min = Math.min(min, Math.abs(i - j));
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }
        System.out.println(min);
    }
}
