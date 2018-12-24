package net.acmicpc.rules;

import java.util.Scanner;

/**
 * 더하기 사이클
 * String을 활용하면 시간 초과
 */
public class P1110_String {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int value = scanner.nextInt();
    boolean flag = true;

    // 입력 받은 값을 문자열로 변환
    String strValue = Integer.toString(value);

    char left;
    char right;
    int count = 0;

    while (flag) {
      StringBuilder sb = new StringBuilder();

      if (strValue.length() == 2) {
        left = strValue.charAt(0);
        right = strValue.charAt(1);
      }
      else {
        left = '0';
        right = strValue.charAt(0);
      }

      int temp = Integer.parseInt(String.valueOf(left)) + Integer.parseInt(String.valueOf(right));
      String strTemp = String.valueOf(temp);

      if (strTemp.length() == 2) {
        sb.append(right).append(strTemp.charAt(1));
      }
      else {
        sb.append(right).append(strTemp);
      }

      if (sb.toString().equals("0" + Integer.toString(value))) {
        flag = false;
      }
      strValue = sb.toString();
      count++;
    }
    System.out.println(count);
  }

}
