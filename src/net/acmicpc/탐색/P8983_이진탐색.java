package net.acmicpc.탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 사대 정렬
 * 동물 미정렬
 * lower bounds 버전
 */
public class P8983_이진탐색 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int gunCount = Integer.parseInt(st.nextToken());
        int animalCount = Integer.parseInt(st.nextToken());
        int distance = Integer.parseInt(st.nextToken());

        int gun[] = new int[gunCount];

        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < gunCount; ++i) {
            gun[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(gun);

        int answer = 0, x = 0, y = 0;
        for (int i = 0, j = 0; i < animalCount; ++i) { // 동물 기준으로 탐색
            st = new StringTokenizer(br.readLine().trim());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            j = Arrays.binarySearch(gun, x);
            j = (j >= 0) ? j : Math.abs(j) - 1;
            // 위 반복에서 찾은 사대 바로 이전 사대로 가능한지 체크
            // j-1 : 현재 동물보다 이전에 있는 사대 위치
            if (j > 0 && x - gun[j - 1] + y <= distance) {
                ++answer;
                continue;
            }
            // 위 반복에서 찾은 사대로 가능한지 체크
            // j: 현재 동물보다 같거나 다음에 있는 사대 위치이거나 현재 동물 이후에 사대가 없는 경우의 상태값
            if (j < gunCount && gun[j] - x + y <= distance) ++answer;
        }
        System.out.println(answer);
    }
}
