package com.swea.D4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class D4_1223 {

  private static int priority(char c) {
    switch (c) {
      case '*':
        return 1;
      case '+':
        return 0;
    }
    return -1;
  }

  private static String toPostFix(String infix) {
    StringBuilder sb = new StringBuilder();
    char[] chars = infix.toCharArray();
    Stack<Character> stack = new Stack<>();
    char temp;
    for (int i = 0; i < chars.length; ++i) {
      temp = chars[i];
      int w = priority(temp);

      if (temp == '*' || temp == '+') {
        while (!stack.isEmpty() && priority(stack.peek()) >= w) sb.append(stack.pop());
        stack.push(temp);
      } else {
        sb.append(temp);
      }
    }
    while (!stack.isEmpty()) sb.append(stack.pop());
    return sb.toString();
  }

  private static long calculate(String postfix) {
    Stack<Long> stack = new Stack<>();
    char[] chars = postfix.toCharArray();
    char temp;
    long value1 = 0;
    long value2 = 0;
    for (int i = 0; i < chars.length; ++i) {
      temp = chars[i];
      if (Character.isDigit(temp)) stack.push(new Long(temp - '0'));
      else {
        value2 = stack.pop();
        value1 = stack.pop();
        switch (temp) {
          case '+':
            stack.push(value1 + value2);
            break;
          case '*':
            stack.push(value1 * value2);
            break;
        }
      }
    }
    return stack.pop();
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
    BufferedReader br = new BufferedReader(new FileReader("C:\\intelliJ_workspaces\\Algorithm\\src\\com\\swea\\D4\\testcase\\1223input.txt"));
    for (int t = 1; t <= 10; ++t) {
      int SIZE = Integer.parseInt(br.readLine());
//      System.out.println(toPostFix("3+4+5*6+7"));
      System.out.println("#" + t + " " + calculate(toPostFix(br.readLine())));
    }
  }
}
