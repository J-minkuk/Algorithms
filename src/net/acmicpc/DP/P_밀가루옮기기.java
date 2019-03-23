package net.acmicpc.DP;

import java.util.Scanner;

public class P_밀가루옮기기 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; ++t) {
            int target = sc.nextInt();      // 목표 무게
            int count = sc.nextInt();       // 봉지 개수
            int[] weights = new int[count];
            int[] DP = new int[target + 1];

            for (int i = 0; i < count; ++i) {
                weights[i] = sc.nextInt();
                // 해당 봉지의 무게 동적 테이블에 해당 봉지 1로 초기화
                if (weights[i] <= target) DP[weights[i]] = 1;
            }

            // 첫번째 봉지부터 마지막 봉지까지 처리
            for (int i = 0; i < count; ++i) {
                // 각 봉지의 무게+1 부터 시도
                for (int nW = weights[i] + 1; nW <= target; ++nW) {
                    int dpWeight = nW - weights[i];
                    // 남은 무게 만큼을 사용할수 있는 봉투의 개수가 존재하면
                    if (DP[dpWeight] != 0) {
                        // 기존에 메모된 결과가 없다면
                        if (DP[nW] == 0) DP[nW] = DP[dpWeight] + 1;
                        // 기존에 메모된 결과가 있다면
                        else if (DP[dpWeight] + 1 < DP[nW]) DP[nW] = DP[dpWeight] + 1;
                    }
                }
            }
            System.out.println("#" + t + " " + (DP[target] == 0 ? -1 : DP[target]));
        }
    }
}
