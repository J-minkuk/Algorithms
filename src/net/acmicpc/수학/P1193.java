package net.acmicpc.수학;

import java.util.Scanner;

/**
 * 분수 찾기
 */
public class P1193 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

    boolean flag = true;
    int standardNum = 1;
    int rotateValue = 1;
    int molecular = 1;    // 분자
    int denominator = 1;  // 분모

    while (flag) {
      int startValue = 1;

      if (n <= standardNum) {
        if (rotateValue % 2 == 0) {
          denominator = rotateValue;
          for (int i = 0; i < rotateValue; ++i) {
            startValue += i;
          }
          for (int i = startValue; i < n; ++i) {
            molecular++;
            denominator--;
          }
        }
        else if (rotateValue % 2 == 1) {
          molecular = rotateValue;
          for (int i = 0; i < rotateValue; ++i) {
            startValue += i;
          }
          for (int i = startValue; i < n; ++i) {
            molecular--;
            denominator++;
          }
        }
        flag = false;
      }
      else {
        standardNum += (++rotateValue);
      }
    }
    System.out.format("%d/%d", molecular, denominator);
  }
}
