package programmers.remote.contest;

import java.util.Arrays;

public class 상반기_2019_2번 {

  public int solution(int[] people, int[] tshirts) {
    int answer = 0;
    Arrays.sort(people);
    Arrays.sort(tshirts);

    int pIdx = 0;
    int tIdx = 0;

    while (pIdx < people.length && tIdx < tshirts.length) {
      if (people[pIdx] <= tshirts[tIdx]) {
        ++pIdx;
        ++tIdx;
        ++answer;
      } else {
        ++tIdx;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    상반기_2019_2번 temp = new 상반기_2019_2번();
    int[] p = {3, 2};
    int[] t = {1, 2, 3};
    System.out.println(temp.solution(p, t));
  }
}
