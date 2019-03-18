package com.swea.D4;

import java.io.IOException;
import java.util.Scanner;

public class D4_3459_승자예측하기 {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; ++t) {
            long N = in.nextLong();
            System.out.println("#" + t + " " + play(N));
        }
        in.close();
    }

    // 목표값이 내 차례 순서이면 값 작게(2x), 상대 순서이면 값 크게(2x+1)
    private static String play(long n) {
        int step = (int) (Math.log(n) / Math.log(2));   // 이진 트리로 생각하여 n이 포함된 시작 2^step 값 구하기
        int order = 1;  // 앨리스부터 시작
        long temp = 1;
        while (true) {
            temp *= 2;  // 무조건 2x 시도 후 상황에 따라 +1 처리
            if (temp > n) return order % 2 == 0 ? "Alice" : "Bob";  // 2x값이 n을 초과하면 게임 종료(현재가 bob(짝수)면 승자는 앨리스)
            if (order % 2 != step % 2) temp += 1;   // 내 턴에 안걸리면 2x+1;
            order++;
        }
    }
}
