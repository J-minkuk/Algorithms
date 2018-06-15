package com.algorithm.codility.odd.occurrence;

import java.util.Arrays;

/*
 * 홀수번 들어있는 요소 찾아내기
 */
@SuppressWarnings("Duplicates")
public class ArrayEx {

  public static int solution(int[] A) {

    Arrays.sort(A);
    int count = 1;
    int oddValue = 0;
    int preValue = A[0];

    if (A.length == 1) return preValue;                     // 배열 길이가 1 인 경우

    // 배열 길이가 1보다 큰 경우 검사 시작
    for (int i = 1; i < A.length; ++i) {
      if (preValue == A[i]) count++;                        // preValue(이전값)과 현재값이 같으면 count 증가
      else {                                                // 아니면
        if (count % 2 == 1) oddValue = preValue;            // count가 홀수일 경우, oddValue 갱신
        preValue = A[i];                                    // preValue 값 갱신
        count = 1;                                          // count 1로 초기화

        if (i == A.length - 1) return A[i];                 // 1개인 것이 맨 끝에 있는 경우
      }
    }

    if (count >= 3 && count % 2 == 1) return preValue;      // 홀수개인 수가 배열 마지막에 나열된 경우

    return oddValue;
  }

  public static void main(String[] args) {
    int[] A = {9, 3, 9, 3, 9, 7, 9};
    int[] B = {2, 2, 3, 3, 4};
    int[] C = {1, 1, 1, 3, 3, 2, 2};
    int[] D = {1, 1, 2, 2, 4, 4, 4};
    int[] E = {1};
    System.out.println(solution(A));
    System.out.println(solution(B));
    System.out.println(solution(C));
    System.out.println(solution(D));
    System.out.println(solution(E));
  }
}