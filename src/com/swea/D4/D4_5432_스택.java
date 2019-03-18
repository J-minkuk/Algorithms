package com.swea.D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class D4_5432_스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; ++t) {
            int count = 0;
            char[] ch = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();

            stack.push(ch[0]);
            for (int i = 1; i < ch.length; ++i) {
                char c = ch[i];
                if (c == '(') stack.push(c);
                else {
                    stack.pop();
                    if (ch[i - 1] == '(' && ch[i] == ')') count += stack.size();
                    else count += 1;
                }
            }
            System.out.println("#" + t + " " + count);
        }
    }
}
