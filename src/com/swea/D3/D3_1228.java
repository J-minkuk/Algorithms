package com.swea.D3;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class D3_1228 {
  public static void main(String[] args) throws IOException {
    Scanner sc1 = new Scanner(System.in);
    Scanner sc = new Scanner(new FileReader("D:\\sts_projects\\Algorithm\\src\\com\\swea\\D3\\testcase\\1228input.txt"));
    for (int t = 1; t <= 10; ++t) {
      int N = sc.nextInt(); sc.nextLine();
      String[] str = sc.nextLine().split(" ");

      LinkedList<Integer> list = new LinkedList<>();
      for (int i = 0; i < N; ++i) {
        list.add(Integer.parseInt(str[i]));
      }

      int commandC = sc.nextInt(); sc.nextLine();
      for (int i = 0; i < commandC; ++i) {
        LinkedList<Integer> tempList = new LinkedList<>();

        if(sc.next().equals("I")) {
          int idx = sc.nextInt();
          int count = sc.nextInt();
          for (int j = 0; j < count; ++j) {
            tempList.add(sc.nextInt());
          }
          list.addAll(idx, tempList);
        }
      }
      List<Integer> result = list.subList(0, 10);
      System.out.print("#" + t + " ");
      for (int value : result) {
        System.out.print(value + " ");
      }
      System.out.println();
    }
  }
}
