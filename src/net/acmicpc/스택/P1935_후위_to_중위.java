package net.acmicpc.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P1935_후위_to_중위 {
    static Stack<Double> stack;
    static double result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 피연산자 수
        double[] value = new double[N];
        char[] chars = br.readLine().toCharArray();
        int L = chars.length;

        for (int i = 0; i < N; ++i) {
            value[i] = Double.parseDouble(br.readLine());
        }

        stack = new Stack<>();
        for (int i = 0; i < L; ++i) {
            char c = chars[i];
            switch (c) {
                case '+':
                    double b1 = stack.pop();
                    double a1 = stack.pop();
                    result = a1 + b1;
                    stack.push(result);
                    break;
                case '-':
                    double b2 = stack.pop();
                    double a2 = stack.pop();
                    result = a2 - b2;
                    stack.push(result);
                    break;
                case '*':
                    double b3 = stack.pop();
                    double a3 = stack.pop();
                    result = a3 * b3;
                    stack.push(result);
                    break;
                case '/':
                    double b4 = stack.pop();
                    double a4 = stack.pop();
                    result = a4 / b4;
                    stack.push(result);
                    break;
                default:
                    stack.push(value[c - 'A']);
                    break;
            }
        }

        System.out.printf("%.2f", stack.peek());
        System.out.println();
//        System.out.println(Character.getNumericValue('A')); // 10
//        System.out.println(Character.getNumericValue('Z')); // 35
    }
}
