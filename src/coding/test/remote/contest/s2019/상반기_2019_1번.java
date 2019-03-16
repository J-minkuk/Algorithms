package coding.test.remote.contest.s2019;

import java.util.ArrayList;
import java.util.List;

public class 상반기_2019_1번 {
  static int[] result = new int[3];
  static int totalCount;
  static List<Integer> primeList;

  public int solution(int n) {
    getPrimeList(n);
    combination(0, 0, n);
    int answer = totalCount;
    return answer;
  }

  private List<Integer> getPrimeList(int n) {
    List<Boolean> numbers = new ArrayList<>();
    numbers.add(false);
    numbers.add(false);

    for (int i = 2; i <= n; ++i) {
      numbers.add(i, true);
    }

    for (int i = 2; (i * i) <= n; ++i) {
      if (numbers.get(i)) {
        for (int j = (i * i); j <= n; j += i) {
          numbers.set(j, false);
        }
      }
    }

    primeList = new ArrayList<>();
    for (int i = 2; i < numbers.size(); ++i) {
      if (numbers.get(i)) {
        primeList.add(i);
      }
    }
    return primeList;
  }

  private void combination(int count, int valueIndex, int n) {
    if (count == 3) {
      int sum = 0;
      for (int i = 0; i < 3; ++i) {
        sum += result[i];
      }
      if (sum == n) ++totalCount;
      return;
    }
    for (int i = valueIndex; i < primeList.size(); ++i) {
      result[count] = primeList.get(i);
      combination(count + 1, i + 1, n);
    }
  }

  public static void main(String[] args) {
    상반기_2019_1번 temp = new 상반기_2019_1번();
    System.out.println(temp.solution(9));
  }
}
