package net.acmicpc.구현;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 평균은 넘겠지
 */
public class P4344_평균은넘겠지 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();

        ArrayList<Integer> arrayList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        double average = 0;

        for (int i = 0; i < testCase; ++i) {
            int studentCount = scanner.nextInt();
            int sum = 0;
            int count = 0;

            for (int j = 0; j < studentCount; ++j) {
                int score = scanner.nextInt();
                arrayList.add(score);
                sum += score;
                average = sum / studentCount;
            }

            for (int value : arrayList) {
                if (value > average) {
                    count++;
                }
            }

            double percent = 100.0 * count / studentCount;
            sb.append(String.format("%.3f%%", percent)).append("\n");
            arrayList.clear();
        }
        System.out.println(sb.toString());

    }

}
