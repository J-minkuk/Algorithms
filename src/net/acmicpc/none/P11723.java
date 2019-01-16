package net.acmicpc.none;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11723 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] set = new int[21];
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; ++i) {
      String[] s = br.readLine().split(" ");
      int elem = 0;
      if (s.length != 1) elem = Integer.parseInt(s[1]);
      switch (s[0]) {
        case "add":
          if (set[elem] == 0) set[elem] = elem;
          break;
        case "remove":
          if (set[elem] != 0) set[elem] = 0;
          break;
        case "check":
          if (set[elem] == elem) sb.append(1).append("\n");
          else sb.append(0).append("\n");
          break;
        case "toggle":
          if (set[elem] == elem) set[elem] = 0;
          else set[elem] = elem;
          break;
        case "all":
          for (int j = 0; j < 21; ++j) {
            set[j] = j;
          }
          break;
        case "empty":
          for (int j = 0; j < 21; ++j) {
            set[j] = 0;
          }
          break;
      }
    }
    System.out.println(sb);
  }
}
