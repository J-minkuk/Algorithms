package net.acmicpc.수학;

import java.util.Scanner;

/**
 * 상근이는 정확하게 N kg을 배달해야 한다.
 * 봉지는 3, 5 kg 2 종류가 있다.
 * 상근이는 최대한 적은 봉지를 들고 가려고 한다.
 * 예) 18 kg을 배달해야 할 때, 5kg 3개와 3kg 1개를 사용해서 배달하는게 최적이다.
 * 상근이가 N kg을 배달할 때, 봉지 몇 개를 가져가면 되는지 그 수를 구하여라.
 * (단, 정확하게 N kg을 만들 수 없다면 -1 을 리턴한다.)
 */
@SuppressWarnings("Duplicates")
public class P2839_설탕배달 {

    static final int THREE_KG = 3;
    static final int FIVE_KG = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();    // 3 <= n <= 5,000
        int threeMax = 0;
        int fiveMax = 0;

        // Case 1: 5kg으로만 할당 가능한 경우
        for (int i = (n / FIVE_KG); i >= 1; --i) {
            int modFive = n - (i * FIVE_KG);
            if (modFive == 0) {
                fiveMax = i;
                System.out.format("봉지 수 5kg: %d\n", fiveMax);
                System.out.format("총 봉지 개수: %d\n", fiveMax);
                return;
            }
        }

        // Case 2: 5kg으로 먼저 나누고 3kg으로 나머지를 할당 가능한 경우
        for (int i = (n / FIVE_KG); i >= 1; --i) {
            int modFive = n - (i * FIVE_KG);
            if (modFive != 0) {
                // 5로 나눈 것의 나머지가 3으로 나누어 떨이지는 경우
                if (modFive % 3 == 0) {
                    fiveMax = i;
                    threeMax = modFive / 3;
                    System.out.format("봉지 수 5kg: %d, 3kg: %d\n", fiveMax, threeMax);
                    System.out.format("총 봉지 개수: %d\n", fiveMax + threeMax);
                    return;
                }
            }
        }

        // Case 3: 3kg으로만 할당 가능한 경우
        for (int i = (n / THREE_KG); i >= 1; --i) {
            int modThree = n - (i * THREE_KG);
            if (modThree == 0) {
                threeMax = i;
                System.out.format("봉지 수 3kg: %d\n", threeMax);
                System.out.format("총 봉지 개수: %d\n", threeMax);
                return;
            }
        }

        // Case 4: 정확하게 할당 불가능한 경우
        System.out.println(-1);

    }

}
