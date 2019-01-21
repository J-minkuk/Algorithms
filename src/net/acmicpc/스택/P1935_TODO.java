package net.acmicpc.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P1935_TODO {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());  // 피연산자 수
    String s = br.readLine(); // 후위표기식
    int SIZE = s.length();

    Stack<Character> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < SIZE; ++i) {
      char c = s.charAt(i);

      if (c == '*' || c == '/' || c == '+' || c == '-') {
        if (!stack.isEmpty()) sb.append(stack.pop());
        sb.append(c);
        if (!stack.isEmpty()) sb.append(stack.pop());
        sb = sb.reverse();
      } else {
        stack.push(c);
        System.out.println(i + " " + stack.toString());
      }
    }
    System.out.println(sb);
  }
}
