package com.algorithm.string.reverse;

import java.util.Stack;

/*
 * 문자열 거꾸로 만들기
 */
public class ReverseString {

  static String reverseString(String s) {
    char[] chars = s.toCharArray();
    StringBuilder sb = new StringBuilder();
    Stack<String> stack = new Stack<>();

    for (char c : chars) {
      stack.push(Character.toString(c));
    }

    while (!stack.empty()) {
      sb.append(stack.pop());
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    String str = "MinGOOD";
    System.out.println(reverseString(str));
  }
}
