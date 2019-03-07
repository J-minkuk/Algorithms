package net.acmicpc.수학;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 에라토스테네스의 체 활용
 */
public class P2960 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        List<Boolean> numbers = new ArrayList<>();
        numbers.add(false);
        numbers.add(false);

        // 2부터 n까지의 모든 정수 true
        for (int i = 2; i <= n; ++i) {
            numbers.add(i, true);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2; (i * i) <= n; ++i) {
            if (numbers.get(i)) {
                list.add(i);
                for (int j = (i * i); j <= n; j += i) {
                    numbers.set(j, false);
                    if (!list.contains(j)) list.add(j);
                }
            }
        }

        for (int i = 2; i < numbers.size(); ++i) {
            if (numbers.get(i) && !list.contains(i)) list.add(i);
        }
        System.out.println(list.get(k - 1));
    }
}
