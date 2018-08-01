package com.algorithm.baekjoon.problem.chap6;

import java.util.Scanner;

/**
 * 단어의 개수
 */
public class P1152 {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    // 앞 뒤 공백 제거를 위해 trim() 사용
    String str = scanner.nextLine().trim();

    // 입력이 공백인 경우를 처리하기 위해 isEmpty() 사용
    if (str.isEmpty()) {
      System.out.println(0);
    }
    else {
      String[] arr = str.split(" ");
      System.out.println(arr.length);
    }

  }

}
