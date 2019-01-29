package com.swea.D3;

import java.util.ArrayList;

/**
 * 에라토스테네스의 체
 */
public class D3_3131 {
  public static void main(String[] args) {
    int N = 1000000;
    ArrayList<Boolean> list = new ArrayList<>();
    list.add(false);  // 0번째 인덱스
    list.add(false);  // 1번째 인덱스

    // 일단 true로 저장
    for (int i = 2; i <= N; ++i) {
      list.add(i, true);
    }

    // 2, 3, 4 ... 의 배수 false로 마킹
    for (int i = 2; (i * i) <= N; ++i) {
      if (list.get(i)) {
        for (int j = (i * i); j <= N; j += i) {
          list.set(j, false);
        }
      }
    }

    ArrayList<Integer> result = new ArrayList<>();
    for (int i = 2; i <= N; ++i) {
      if (list.get(i)) {
        result.add(i);
      }
    }

    for (int v : result) {
      System.out.print(v + " ");
    }
  }
}
