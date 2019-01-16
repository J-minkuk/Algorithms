package com.swea.D4;

import java.io.*;
import java.util.Stack;

public class D4_1218_Stack {
  public static void main(String[] args) throws IOException {
    BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
    BufferedReader br = new BufferedReader(new FileReader("C:\\intelliJ_workspaces\\Algorithm\\src\\com\\swea\\D4\\testcase\\1218input.txt"));
    for (int t = 1; t <= 10; ++t) {
      Stack<Character> stack = new Stack<>();
      br.readLine();
      String s = br.readLine();
      boolean flag = true;
      for (int i = 0; i < s.length(); ++i) {
        char c = s.charAt(i);
        if (c == '(' || c == '[' || c == '{' || c == '<') stack.push(c);
        else {
          if (stack.isEmpty()) {
            flag = false;
            break;
          }
          char top = stack.pop();
          if (top == '(' && c != ')') flag = false;
          else if (top == '[' && c != ']') flag = false;
          else if (top == '{' && c != '}') flag = false;
          else if (top == '<' && c != '>') flag = false;

          if (!flag) break;
        }
      }
      if (flag) System.out.println("#" + t + " " + 1);
      else System.out.println("#" + t + " " + 0);
    }
  }
}
