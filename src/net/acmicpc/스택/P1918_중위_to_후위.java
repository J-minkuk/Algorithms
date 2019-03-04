package net.acmicpc.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 중위를 후위로 변환
 */
public class P1918_중위_to_후위 {

  private static int priority(char c) {
    switch (c) {
      case '*':
      case '/':
        return 1;
      case '+':
      case '-':
        return 0;
    }
    return -1;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s = br.readLine();
    int SIZE = s.length();

    Stack<Character> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < SIZE; ++i) {
      char c = s.charAt(i);
      int w = priority(c);

      if (c == '*' || c == '/' || c == '+' || c == '-') {
        while (!stack.isEmpty() && priority(stack.peek()) >= w) {
          sb.append(stack.pop());
        }
        stack.push(c);
      } else if (c == '(') {
        stack.push(c);
      } else if (c == ')') {
        while (!stack.isEmpty() && stack.peek() != '(') {
          sb.append(stack.pop());
        }
        stack.pop();
      } else {
        sb.append(c);
      }
    }
    while (!stack.isEmpty()) sb.append(stack.pop());
    System.out.println(sb);
  }
}
