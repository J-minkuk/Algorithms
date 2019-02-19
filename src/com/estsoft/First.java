package com.estsoft;

public class First {
//  private static int solution(int[] ranks) {
//    int count = 0;
//    int size = ranks.length;
//
//    for (int i = 0; i < size - 1; ++i) {
//      for (int j = i + 1; j < size; ++j) {
//        if (ranks[i] == ranks[j] + 1) {
//          ++count;
//          break;
//        } else if (ranks[i] == ranks[j] - 1) {
//          ++count;
//          break;
//        }
//      }
//    }
//    return count;
//  }

  private static int solution(int[] ranks) {
    int[] count = new int[100001];
    int answer = 0;
    int rSize = ranks.length;
    for (int i = 0; i < rSize; ++i) {
      ++count[ranks[i]];
    }

    for (int i = 0; i < 100000; ++i) {
      if (count[i] == 0) continue;
      if (count[i + 1] > 0) answer += count[i];
    }
    return answer;
  }

  public static void main(String[] args) {
    int[] ranks = {4, 4, 3, 3, 1, 0};
    System.out.println(solution(ranks));
  }
}
