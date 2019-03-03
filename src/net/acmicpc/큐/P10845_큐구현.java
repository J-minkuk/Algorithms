package net.acmicpc.큐;

import java.io.IOException;
import java.util.Scanner;

/**
 * 큐 구현
 */
public class P10845_큐구현 {

  private static class Queue {
    private Node top = null;
    private Node bottom = null;
    private int size = 0;

    private class Node {
      int data;
      Node next;
    }

    public void push(int num) {
      Node node = new Node();
      node.data = num;
      if (size == 0) {
        top = node;
        bottom = node;
      } else {
        Node temp = bottom;
        temp.next = node;
        bottom = node;
      }
      ++size;
    }

    public void pop() {
      if (size == 0) {
        System.out.println(-1);
      } else {
        System.out.println(top.data);
        top = top.next;
        --size;
      }
    }

    public void size() {
      System.out.println(size);
    }

    public void empty() {
      if (size == 0) {
        System.out.println(1);
      } else {
        System.out.println(0);
      }
    }

    public void front() {
      if (size == 0) {
        System.out.println(-1);
      } else {
        System.out.println(top.data);
      }
    }

    public void back() {
      if (size == 0) {
        System.out.println(-1);
      } else {
        System.out.println(bottom.data);
      }
    }

  }

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    Queue queue = new Queue();
    for (int t = 1; t <= T; ++t) {
      String s = sc.next();
      switch (s) {
        case "push":
          int num = sc.nextInt();
          queue.push(num);
          break;
        case "pop":
          queue.pop();
          break;
        case "size":
          queue.size();
          break;
        case "empty":
          queue.empty();
          break;
        case "front":
          queue.front();
          break;
        case "back":
          queue.back();
          break;
      }
    }
  }
}
