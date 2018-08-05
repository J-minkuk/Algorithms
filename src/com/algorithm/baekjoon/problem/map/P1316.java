package com.algorithm.baekjoon.problem.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 그룹 단어 체커
 */
public class P1316 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int testCase = scanner.nextInt();
    String[] strings = new String[testCase];
    for (int i = 0; i < testCase; ++i) {
      strings[i] = scanner.next().toLowerCase();
    }

    int count = 0;

    Map<String, Boolean> map = new HashMap<>();
    map.put("a", null); map.put("b", null); map.put("c", null); map.put("d", null); map.put("e", null);
    map.put("f", null); map.put("g", null); map.put("h", null); map.put("i", null); map.put("j", null);
    map.put("k", null); map.put("l", null); map.put("m", null); map.put("n", null); map.put("o", null);
    map.put("p", null); map.put("q", null); map.put("r", null); map.put("s", null); map.put("t", null);
    map.put("u", null); map.put("v", null); map.put("w", null); map.put("x", null); map.put("y", null);
    map.put("z", null);

    for (int i = 0; i < testCase; ++i) {
      for (int j = 0; j < strings[i].length(); ++j) {
        String s = String.valueOf(strings[i].charAt(j));
        if (map.get(s) == null) {
          map.put(s, true);
        }
        else {
          if (map.get(s) == true && s.equals(String.valueOf(strings[i].charAt(j - 1))) == false) {
            map.put(s, false);
          }
        }
      }

      boolean flag = true;

      for (int j = 0; j < strings[i].length(); ++j) {
        String s = String.valueOf(strings[i].charAt(j));
        flag &= map.get(s);
      }
      if (flag == true) count++;

      for (String s : map.keySet()) {
        map.put(s, null);
      }
    }
    System.out.println(count);
  }
}
