package com.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class 정올_1828_그리디 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        // 입력 각 화학물질의 최소 최대 값
        int[][] matter = new int[n][2];
        String[] data = null;
        for (int i = 0; i < n; ++i) {
            data = br.readLine().split(" ");
            matter[i][0] = Integer.parseInt(data[0]);
            matter[i][1] = Integer.parseInt(data[1]);
        }

        // sorting, 최고 온도 오름차순
        Arrays.sort(matter, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        /**
         * 최고 온도가 제일 작은 물질부터 처리하여 다음 화학 물질의 최저 온도와의 교집합 가능성을 높임.
         * 뒤에 오는 물질들의 최저 온도는 다음 2가지 경우
         * - 1. 앞에 오는 물질의 최고 온도보다 큰 경우: 새 냉장고 필요
         * - 2. 앞에 오는 물질의 죄고 온도보다 같거나 작은 경우:
         *      최고 온도 기준으로 정렬되어 현재 물질의 최고 온도는 앞에 오는 물질의 최고 온도보다 같거나 큰 상황.
         *      그러므로, 현 물질의 최저 온도는 앞에 오는 물질과 결국 겹치는 온도 구간이 존재함.
         */
        int cnt = 1;
        int max = matter[0][1]; // 현 냉장고의 최고 온도 : 최고 온도가 가장 작은 화학 물질부터 냉장고에 넣는 처리.
        for (int i = 1; i < n; ++i) {
            if (matter[i][0] > max) {   // 현 화학 물질의 최저 온도가 냉장고의 최고 온도보다 크다면 새로운 냉장고 필요
                ++cnt;
                max = matter[i][1];
            }
        }

        System.out.println(cnt);
    }

}
