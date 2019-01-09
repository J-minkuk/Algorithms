package net.acmicpc.스택;

import java.util.Scanner;
import java.util.Stack;

/**
 * 괄호
 */
public class P9012 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int testCase = scanner.nextInt();
    String[] parenthesisArr = new String[testCase];
    for (int i = 0; i < testCase; ++i) {
      parenthesisArr[i] = scanner.next();
    }

    for (int i = 0; i < testCase; ++i) {
      boolean flag = true;
      Stack<Character> charStack = new Stack<>();
      int arrLength = parenthesisArr[i].length();

      for (int j = 0; j < arrLength; ++j) {
        char temp = parenthesisArr[i].charAt(j);
        if (temp == '(') charStack.push(temp);
        else if (temp == ')') {
          if (!charStack.isEmpty()) charStack.pop();
          else flag = false;
        }
      }

      if (!charStack.isEmpty()) flag = false;

      if (flag) System.out.println("YES");
      else System.out.println("NO");
    }
  }
}
