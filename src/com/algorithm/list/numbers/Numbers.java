package com.algorithm.list.numbers;

import java.util.ArrayList;
import java.util.List;

/*
 * 숫자가 들어있는 리스트 만들기
 */
public class Numbers {

  static List<Integer> list = new ArrayList<>();

  static void makeList1(int num) {
    if (num < 0) return;
    else {
      list.add(num--);
      makeList1(num);
    }
  }

  static List<Integer> makeList2(int num) {
    List<Integer> list2 = new ArrayList<>();
    for (int i = 0; i <= num; ++i) {
      list2.add(i);
    }
    return list2;
  }

  public static void main(String[] args) {
    makeList1(9);
    for (int i = 0; i < list.size(); ++i) {
      System.out.print(list.get(i)+ " ");
    }
    System.out.println();
    System.out.println(makeList2(9).toString());
  }

}
