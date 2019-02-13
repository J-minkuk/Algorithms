package net.acmicpc;

import java.util.Scanner;

/**
 * ACM 호텔
 *
 * 이 문제는 W 라는 값이 의미가 없는 것 같은데 ?
 */
public class P10250 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int testCase = scanner.nextInt();
    for (int i = 0; i < testCase; ++i) {
      int height = scanner.nextInt();
      int width = scanner.nextInt();
      int nth = scanner.nextInt();

      int quotient = nth / height;
      int mod = nth % height;
      String strQuotient = String.valueOf(quotient);
      StringBuilder sb = new StringBuilder();
      if (mod == 0 && strQuotient.length() == 1) {
        sb.append(height).append("0").append(quotient);
      }
      else if (mod == 0 && strQuotient.length() != 1) {
        sb.append(height).append(quotient);
      }
      else if (mod != 0 && strQuotient.length() == 1) {
        if (quotient == 9) {
          sb.append(mod).append(quotient + 1);
        }
        else {
          sb.append(mod).append("0").append(quotient + 1);
        }
      }
      else if (mod != 0 && strQuotient.length() != 1) {
        sb.append(mod).append(quotient + 1);
      }
      System.out.println(sb.toString());
    }
  }
}
