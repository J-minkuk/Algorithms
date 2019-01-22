package com.swea.D4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class D4_1224 {

  private static int getPriority(char c) {
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

  private static String toPostFix(String infix) {
    StringBuilder sb = new StringBuilder();
    char[] chars = infix.toCharArray();
    Stack<Character> stack = new Stack<>();
    final int SIZE = chars.length;

    char temp;
    for (int i = 0; i < SIZE; ++i) {
      temp = chars[i];
      int w = getPriority(temp);

      if (temp == '*' || temp == '/' || temp == '+' || temp == '-') {
        while (!stack.isEmpty() && getPriority(stack.peek()) >= w) {
          sb.append(stack.pop());
        }
        stack.push(temp);
      } else if (temp == '(') {
        stack.push(temp);
      } else if (temp == ')') {
        while (!stack.isEmpty() && stack.peek() != '(') {
          sb.append(stack.pop());
        }
        stack.pop();
      } else {
        sb.append(temp);
      }
    }
    return sb.toString();
  }

  private static long caculate(String postfix) {
    Stack<Long> stack = new Stack<>();
    char[] chars = postfix.toCharArray();
    char temp;
    final int SIZE = chars.length;
    long value1 = 0;
    long value2 = 0;

    for (int i = 0; i < SIZE; ++i) {
      temp = chars[i];
      if (Character.isDigit(temp)) stack.push(new Long(temp - '0'));
      else {
        value2 = stack.pop();
        value1 = stack.pop();
        switch (temp) {
          case '*':
            stack.push(value1 * value2);
            break;
          case '/':
            stack.push(value1 / value2);
            break;
          case '+':
            stack.push(value1 + value2);
            break;
          case '-':
            stack.push(value1 - value2);
            break;
        }
      }
    }
    return stack.pop();
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
    BufferedReader br = new BufferedReader(new FileReader("C:\\intelliJ_workspaces\\Algorithm\\src\\com\\swea\\D4\\testcase\\1224input.txt"));
    for (int t = 1; t <= 10; ++t) {
      br.readLine();
      System.out.println("#" + t + " " + caculate(toPostFix(br.readLine())));
    }
  }
}
