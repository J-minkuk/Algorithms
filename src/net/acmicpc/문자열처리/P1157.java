package net.acmicpc.문자열처리;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 단어 공부
 */
public class P1157 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String s = scanner.nextLine().trim().toLowerCase();

    Map<String, Integer> map = new HashMap<>();
    int maxCount = 0;
    int maxCountValue = 0;

    for (int i = 0; i < s.length(); ++i) {
      String str = String.valueOf(s.charAt(i));
      if (map.containsKey(str)) {
        map.put(str, map.get(str) + 1);
      }
      else {
        map.put(str, 1);
      }
    }

    for (int count : map.values()) {
      if (maxCount < count) {
        maxCount = count;
      }
    }

    for (int value : map.values()) {
      if (value == maxCount) {
        maxCountValue++;
      }
    }

    if (maxCountValue > 1) {
      System.out.println("?");
    }
    else {
      for (String key : map.keySet()) {
        if (map.get(key) == maxCount) {
          System.out.println(key.toUpperCase());
        }
      }
    }


  }
}
