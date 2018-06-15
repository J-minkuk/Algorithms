package com.algorithm.string.converter.camel;

/*
 * 문자열 Camel 스타일로 바꾸기
 */
public class MakeCamel {

  static String makeCamelFirstLowerCase(String str) {
    String[] sArr = str.toLowerCase().split(" ");
    int sArrSize = sArr.length;
    StringBuilder lowerStr = new StringBuilder();
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < sArrSize; ++i) {
      lowerStr.append(sArr[i]);
    }

    int lowerStrSize = lowerStr.length();
    for (int i = 0; i < lowerStrSize; ++i) {
      char c = lowerStr.charAt(i);
      if (i % 2 == 1) {
        result.append(Character.toString(c).toUpperCase());
      }
      else {
        result.append(c);
      }
    }
    return result.toString();
  }

  static String makeCamelFirstUpperCase(String str) {
    String[] sArr = str.toLowerCase().split(" ");
    int sArrSize = sArr.length;
    StringBuilder upperStr = new StringBuilder();
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < sArrSize; ++i) {
      upperStr.append(sArr[i]);
    }

    int upperStrSize = upperStr.length();
    for (int i = 0; i < upperStrSize; ++i) {
      char c = upperStr.charAt(i);
      if (i % 2 == 0) {
        result.append(Character.toString(c).toUpperCase());
      }
      else {
        result.append(c);
      }
    }
    return result.toString();
  }

  public static void main(String[] args) {
    String str = "Naver Campus Hackday";
    System.out.println(makeCamelFirstLowerCase(str));
    System.out.println(makeCamelFirstUpperCase(str));
  }

}
