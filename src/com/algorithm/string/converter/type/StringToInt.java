package com.algorithm.string.converter.type;

/*
 * 형변환
 */
public class StringToInt {

  static int converter(String str) {
    return Integer.parseInt(str);
  }

  static void converter(int v) {
    String s = Integer.toString(v);
    char[] chars = s.toCharArray();
    for (char c : chars) {
      System.out.print(c + " ");
    }
  }

  public static void main(String[] args) {
    System.out.println(converter("1234567890"));
    System.out.println(converter("0123456789"));

    converter(1234567890);
  }
}
