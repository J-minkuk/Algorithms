package com.algorithm.baekjoon.problem.string;

import java.util.Scanner;

/**
 * 크로아티아 알파벳
 */
public class P2941 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String s = scanner.nextLine();

    String[] croatia = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

    for (int i = 0; i < croatia.length; ++i) {
      s = s.replace(croatia[i], " ");
    }

    System.out.println(s.length());


  }
}
