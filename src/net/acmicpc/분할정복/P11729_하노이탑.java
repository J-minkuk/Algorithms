package net.acmicpc.분할정복;

import java.util.Scanner;

public class P11729_하노이탑 {
  static int count;
  static StringBuilder sb = new StringBuilder();

  private static void hanoi(int n, int start, int temp, int end) {
    if (n == 0) return;
    hanoi(n - 1, start, end, temp);
    sb.append(start + " " + end + "\n");
    hanoi(n - 1, temp, start, end);
    count++;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    count = 0;
    hanoi(N, 1,2, 3);
    sb.insert(0, count + "\n");
    System.out.println(sb);
  }
}
