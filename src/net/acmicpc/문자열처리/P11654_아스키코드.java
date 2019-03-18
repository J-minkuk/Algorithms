package net.acmicpc.문자열처리;

import java.util.Scanner;

/**
 * 아스키 코드
 */
public class P11654_아스키코드 {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    String str = scanner.next();

    System.out.println(((int) str.charAt(0)));

  }

}
