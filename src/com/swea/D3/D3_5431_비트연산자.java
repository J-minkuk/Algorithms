package com.swea.D3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.Scanner;

public class D3_5431_비트연산자 {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner sc = new Scanner(new FileReader("C:\\intelliJ_workspaces\\Algorithm\\src\\com\\swea\\D3\\testcase\\0110input.txt"));
    int T = sc.nextInt();
    for (int t = 1; t <= T; ++t) {
      int N = sc.nextInt();
      int P = sc.nextInt();

      BigInteger a = BigInteger.ZERO;
      // 과제 한 사람 체크
      for (int i = 1; i <= P; ++i) {
        int stu = sc.nextInt();
        a = a.or(BigInteger.ONE.shiftLeft(stu));
      }

      // 과제 제출 X 출력
      System.out.print("#" + t + " ");
      for (int i = 1; i <= N; ++i) {
        if (a.and(BigInteger.ONE.shiftLeft(i)).equals(BigInteger.ZERO)) {
          System.out.print(i + " ");
        }
      }
      System.out.println();
    }
  }
}
