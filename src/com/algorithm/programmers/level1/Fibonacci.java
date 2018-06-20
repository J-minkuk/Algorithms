package com.algorithm.programmers.level1;

public class Fibonacci {

  public long recursiveFibonacci(int num) {
    long answer = 0;
    if (num <= 1) return num;
    else answer = recursiveFibonacci(num - 1) + recursiveFibonacci(num - 2);
    return answer;
  }

  public long loopFibonacci(int num) {
    long answer = 0;
    int count = 1;
    long a = 0, b = 1;

    if (num <= 1) return num;

    while (count < num) {
      answer = a + b;
      a = b;
      b = answer;
      count++;
    }
    return answer;
  }

  static long[] a = new long[10000];

  public long dpFibonacci(int num) {
    if (a[num] != 0) return a[num];
    if (num == 1 || num == 2) a[num] = 1;
    else a[num] = dpFibonacci(num - 1) + dpFibonacci(num - 2);
    return a[num];
  }

  // 아래는 테스트로 출력해 보기 위한 코드입니다.
  public static void main(String[] args) {
    Fibonacci c = new Fibonacci();
    int testCase = 4;
    System.out.println(c.recursiveFibonacci(testCase));
    System.out.println(c.loopFibonacci(testCase));
    System.out.println(c.dpFibonacci(1000));
  }

}
