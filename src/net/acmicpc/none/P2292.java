package net.acmicpc.none;

import java.util.Scanner;

/**
 * 벌집
 */
public class P2292 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

    System.out.println(findLeastCount(n));
  }

  private static int findLeastCount(int num) {
    int standardNum = 1;
    int rotateNum = 6;
    int leastCount = 0;
    boolean flag = true;

    while (flag) {
      if (num <= standardNum) {
        flag = false;
        leastCount++;
      }
      else {
        standardNum += rotateNum * (++leastCount);
      }
    }
    return leastCount;
  }
}
