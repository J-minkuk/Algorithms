package net.acmicpc.배열;

import java.util.Scanner;

public class P3052 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] mods = new int[42];
    for (int i = 0; i < 10; ++i) {
      int num = sc.nextInt() % 42;
      mods[num]++;
    }

    int count = 0;
    for (int i = 0; i < mods.length; ++i) {
      if (mods[i] > 0) count++;
    }
    System.out.println(count);
  }
}
