package com.swea.D4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class D4_1222 {

  private static String toPostFix(String infix) {
    StringBuilder postfix = new StringBuilder();
    char[] chars = infix.toCharArray();
    Stack<Character> stack = new Stack<>();
    char temp;
    for (int i = 0; i < chars.length; ++i) {
      temp = chars[i];
      if (i == 0) postfix.append(temp);
      else if (temp == '+') stack.push(temp);
      else if (Character.isDigit(temp)) {
        postfix.append(temp);
        postfix.append(stack.pop());
      }
    }
    return postfix.toString();
  }

  private static int calculate(String postfix) {
    Stack<Integer> stack = new Stack<>();
    char[] chars = postfix.toCharArray();
    char temp;
    int value1 = 0;
    int value2 = 0;
    for (int i = 0; i < chars.length; ++i) {
      temp = chars[i];
      if (Character.isDigit(temp)) stack.push(new Integer(temp - '0'));
      else {
        value2 = stack.pop();
        value1 = stack.pop();
        stack.push(value1  +value2);
      }
    }
    return stack.pop();
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
    BufferedReader br = new BufferedReader(new FileReader("C:\\intelliJ_workspaces\\Algorithm\\src\\com\\swea\\D4\\testcase\\1222input.txt"));
    for (int t = 1; t <= 10; ++t) {
      int SIZE = Integer.parseInt(br.readLine());
      System.out.println("#" + t + " " + calculate(toPostFix(br.readLine())));
    }
  }
}
