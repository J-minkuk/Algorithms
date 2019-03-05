package net.acmicpc.탐색;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 사대, 동물 정렬 활용
 */
public class P8983_정렬 {

    static class Point implements Comparable<Point> {
        int x, y;

        public Point(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            return this.x - o.x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int gunCount = Integer.parseInt(st.nextToken());
        int animalCount = Integer.parseInt(st.nextToken());
        int distance = Integer.parseInt(st.nextToken());

        int gun[] = new int[gunCount];
        Point animal[] = new Point[animalCount];

        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < gunCount; ++i) {
            gun[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < animalCount; ++i) {
            st = new StringTokenizer(br.readLine().trim());
            animal[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // step1 : 사대 위치 정렬, 동물 x위치 기준 정렬
        Arrays.sort(gun);
        Arrays.sort(animal);

        int answer = 0;
        // step2: 동물 기준으로 탐색 (사대 기준으로 탐색하면 같은 동물이 여러 사대에서 count 될 수 있음)
        for (int i = 0, j = 0; i < animalCount; ++i) {
            // step3: 현 동물 기준으로 같거나 다음 위치에 있는 사대 위치 탐색
            // 동물이 정렬이 되어 있으므로 사대는 이전 반복 사대부터 탐색하면 됨
            // 어차피, 현 동물은 이전 동물보다 거리상 뒤에 있으므로 첫 번째 사대부터 다시 탐색할 필요 없음.
            while (j < gunCount && gun[j] < animal[i].x) ++j;   // 마지막 사대 위치를 벗어나지 않으면서 기준동물의 x좌표보다 같거나 큰 사대를 만날때까지 반복

            // step4-1 : 위 반복에서 찾은 사대를 이용하여 현 동물이 바로 이전 사대의 사정 거리 범위 안인지 체크해서 가능하다면 카운트 증가 후 다음 동물로
            // j-1 : 현재 동물보다 이전에 있는 사대 위치
            if (j > 0 && animal[i].x - gun[j - 1] + animal[i].y <= distance) {
                ++answer;
                continue;
            }
            // step4-2: 위 반복에서 찾은 사대를 이용하여 현 동물이 현 사대의 사정거리 범위 안인지 체크해서 가능하다면 카운트 증가 후 다음 동물로
            // j: 현재 동물보다 같거나 다음에 있는 사대 위치이거나 현재 동물 이후에 사대가 없는 경우 (j == gunCount)
            // j == gunCount 이면 현 동물을 처리할 사대는 없음
            if (j < gunCount && gun[j] - animal[i].x + animal[i].y <= distance) ++answer;
        }
        System.out.println(answer);
    }
}
