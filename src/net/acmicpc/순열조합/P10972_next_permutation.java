package net.acmicpc.순열조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10972_next_permutation {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < N; ++i) {
            num[i] = Integer.parseInt(s[i]);
        }

        if (nextPermutation(num)) {
            for (int i = 0; i < N; ++i) {
                System.out.print(num[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println(-1);
        }
    }

    private static boolean nextPermutation(int[] num) {
        int i = num.length - 1;
        while (i > 0 && num[i - 1] >= num[i]) {
            i -= 1;
        }
        if (i <= 0) return false;

        int j = num.length - 1;
        while (num[j] <= num[i - 1]) {
            j -= 1;
        }

        int temp = num[i - 1];
        num[i - 1] = num[j];
        num[j] = temp;

        j = num.length - 1;
        while (i < j) {
            temp = num[i];
            num[i] = num[j];
            num[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }
}
