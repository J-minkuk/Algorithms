package net.acmicpc.수학;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 완전제곱수
 */
public class P1977_완전제곱수 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        double sqrtM = Math.sqrt(m);
        double sqrtN = Math.sqrt(n);
        int castSqrtM = (int) Math.ceil(sqrtM);
        int castSqrtN = (int) Math.floor(sqrtN);
        int sum = 0;

        List<Integer> squares = new ArrayList<>();
        for (int i = castSqrtM; i <= castSqrtN; ++i) {
            int square = i * i;
            squares.add(square);
        }

        for (int value : squares) {
            sum += value;
        }

        Collections.sort(squares);

        if (squares.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(squares.get(0));
        }
    }
}
