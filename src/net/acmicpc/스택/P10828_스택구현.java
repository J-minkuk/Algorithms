package net.acmicpc.스택;

import java.util.Scanner;

/**
 * 스택 구현
 */
public class P10828_스택구현 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int testCase = scanner.nextInt();
    Stack stack = new Stack();
    for (int i = 0; i < testCase; ++i) {
      String s = scanner.next();
      if (s.equals("push")) {
        int n = scanner.nextInt();
        stack.push(n);
      } else if (s.equals("top")) {
        stack.top();
      } else if (s.equals("pop")) {
        stack.pop();
      } else if (s.equals("size")) {
        stack.size();
      } else if (s.equals("empty")) {
        stack.empty();
      }
    }
  }

  private static class Stack {
    private Node top = null;
    private int size = 0;

    private class Node {
      int data;
      Node next;
    }

    public void push(int num) {
      Node node = new Node();
      node.data = num;
      node.next = top;
      top = node;
      size++;
    }

    public void pop() {
      if (size == 0) {
        System.out.println(-1);
      } else {
        System.out.println(top.data);
        top = top.next;
        size--;
      }
    }

    public void empty() {
      if (size == 0) {
        System.out.println(1);
      } else {
        System.out.println(0);
      }
    }

    public void top() {
      if (top == null) {
        System.out.println(-1);
      } else {
        System.out.println(top.data);
      }
    }

    public void size() {
      System.out.println(size);
    }
  }
}
