package programmers.remote.contest;

/**
 * 완벽하게 풀지 못함
 * 47.6
 */
public class Solution3 {

  public int[] solution(int[] healths, int[][] items) {
    int[] answer = new int[healths.length];
    int maxH = Integer.MIN_VALUE;
    for (int i = 0; i < healths.length; ++i) {
      if (maxH < healths[i]) maxH = healths[i];
    }

    for (int i = 0; i < items.length; ++i) {
      if (maxH - items[i][1] < 100) {
        items[i][0] = 0;
        items[i][1] = 0;
      }
    }

    for (int i = 0; i < items.length; ++i) {
      if (items[i][1] != 0) answer[i] = i + 1;
    }
    int count = 0;
    for (int i = 0; i < answer.length; ++i) {
      if (answer[i] != 0) ++count;
    }

    int[] result = new int[count];
    int idx = 0;
    for (int i = 0; i < answer.length; ++i) {
      if (answer[i] != 0) result[idx++] = answer[i];
    }

    return result;
  }

  public static void main(String[] args) {
    Solution3 temp = new Solution3();
    int[] h = {200, 120, 150};
    int[][] items = {{30, 100}, {500, 30}, {100, 400}};
    temp.solution(h, items);
  }
}
