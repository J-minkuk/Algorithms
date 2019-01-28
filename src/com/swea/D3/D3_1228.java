package com.swea.D3;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class D3_1228 {
  public static void main(String[] args) throws IOException {
    Scanner sc1 = new Scanner(System.in);
    Scanner sc = new Scanner(new FileReader("C:\\intelliJ_workspaces\\Algorithm\\src\\com\\swea\\D3\\testcase\\1228input.txt"));
    for (int t = 1; t <= 1; ++t) {
      int N = sc.nextInt(); sc.nextLine();
      String[] str = sc.nextLine().split(" ");

      LinkedList<String> list = new LinkedList<>();
      for (int i = 0; i < N; ++i) {
        list.add(str[i]);
      }

      int commandC = sc.nextInt(); sc.nextLine();
      for (int i = 0; i < commandC; ++i) {
        if(sc.next().equals("I")) {
          int idx = sc.nextInt();
          int count = sc.nextInt();
          System.out.println(sc.nextInt());
        }
      }
    }
  }
}
