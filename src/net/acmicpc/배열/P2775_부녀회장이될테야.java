package net.acmicpc.배열;

import java.util.Scanner;

/**
 * 부녀회장이 될테야
 */
public class P2775_부녀회장이될테야 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int testCase = scanner.nextInt();
    for (int i = 0; i < testCase; ++i) {
      int floor = scanner.nextInt();
      int roomNumber = scanner.nextInt();
      int[][] apart = new int[floor + 1][roomNumber];

      // 층 J
      for (int j = 0; j <= floor; ++j) {
        // 호 K
        for (int k = 0; k < roomNumber; ++k) {
          if (j == 0) {
            apart[0][k] = k + 1;
          }
          else {
            apart[j][0] = 1;
            if (k >= 1) {
              apart[j][k] = apart[j][k - 1] + apart[j - 1][k];
            }
          }
        }

      }
      // System.out.println(Arrays.deepToString(apart));
      System.out.println(apart[floor][roomNumber - 1]);
    }
  }
}
