package com.estsoft;

public class 상반기_2019_2번 {
  static int[] check;

  private static int dfs(int[] A, int idx) {
    int result = 1;
    if (check[A[idx]] == 0) {
      check[A[idx]] = 1;
      result += dfs(A, A[idx]);
    }
    return result;
  }

  private static int solution(int[] A) {
    check = new int[100001];
    int answer = 0;
    int ASize = A.length;
    for (int i = 0; i < ASize; ++i) {
      answer = Math.max(dfs(A, i), answer);
    }
    return answer - 1;
  }

  public static void main(String[] args) {
    int[] A = {5, 4, 0, 3, 1, 6, 2};
    System.out.println(solution(A));
  }
}
