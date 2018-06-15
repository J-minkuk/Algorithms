package com.algorithm.programmers.level1;

public class Factorial {

  static int recursiveFactorial(int n) {
    if (n <= 1) return 1;
    else return n * recursiveFactorial(n - 1);
  }

//  static int factorialTailRec(int n, int res) {
//    if (n <= 1) return res;
//    else return factorialTailRec(n - 1, n * res);
//  }
//
//  static int factorialTail(int n) {
//    return factorialTailRec(n, 1);
//  }

  static int loopFactorial(int n) {
    int result = 1;
    while (n > 1) {
      result *= (n--);
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(recursiveFactorial(10));
    System.out.println(loopFactorial(10));
//    System.out.println(factorialTail(100000));
  }
}
