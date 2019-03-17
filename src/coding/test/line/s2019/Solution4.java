package coding.test.line.s2019;

import java.util.Scanner;

public class Solution4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.nextLine();

        int[] arr = new int[N];
        for (int i = 0; i < N; ++i) {
            arr[i] = scan.nextInt();
        }

        int result = 0;
        int tempA = 0;
        int tempB = 0;

        for (int i = 0; i < N; ++i) {
            int x1 = arr[i];

            for (int j = i + 1; j < N; ++j) {
                int x2 = arr[j];
                if (tempA < x1 && tempA < x2) result = Math.max(result, j - i);
                tempB = x2;
                if (tempB > tempA) tempA = tempB;
            }

            tempA = 0;
            tempB = 0;
        }
        System.out.println(result);
    }
}