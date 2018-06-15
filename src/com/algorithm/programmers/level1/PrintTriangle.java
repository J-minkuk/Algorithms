package com.algorithm.programmers.level1;

public class PrintTriangle {
  public String printTriangle(int num) {
    StringBuilder builder = new StringBuilder();

    for (int i = 1; i <= num; ++i) {
      for (int j = 1; j <= i; ++j) {
        builder.append("*");
      }
      builder.append("\n");
    }

    return builder.toString();
  }

  // 아래는 테스트로 출력해 보기 위한 코드입니다.
  public static void main(String[] args) {
    PrintTriangle pt = new PrintTriangle();
    System.out.println(pt.printTriangle(3));
  }
}