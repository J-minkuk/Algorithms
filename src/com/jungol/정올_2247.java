package com.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/*
4
3 6
1 3
3 8
12 17

 */
public class 정올_2247 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] times = new int[N][2];
        for (int i = 0; i < N; ++i) {
            String[] s = br.readLine().split(" ");
            times[i][0] = Integer.parseInt(s[0]);
            times[i][1] = Integer.parseInt(s[1]);
        }

        // 들어온 시간 순서대로 정렬
        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[] personTime = times[0];
        int[] nonePersonTime = new int[2];
        int existTime = 0;  // 사람이 이용하는 가장 긴 시간
        int noneExistTime = 0;  // 사람이 이용하지 않는 가장 긴 시간

        for (int i = 1; i < N; ++i) {
            if (personTime[1] < times[i][0]) {  // 시간이 겹치지 않을 경우
                nonePersonTime[0] = personTime[1];
                nonePersonTime[1] = times[i][0];

                existTime = Math.max(existTime, personTime[1] - personTime[0]);
                noneExistTime = Math.max(noneExistTime, nonePersonTime[1] - nonePersonTime[0]);

                personTime = times[i];
            } else {    // 시간이 겹치는 경우
                if (times[i][1] > personTime[1]) personTime[1] = times[i][1];
            }
        }
        existTime = Math.max(existTime, personTime[1] - personTime[0]);

        System.out.println(existTime + " " + noneExistTime);
    }
}
