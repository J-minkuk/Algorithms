package net.acmicpc.순열조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10972_TODO {
  static int N;
  static boolean[] checked;
  static int[] numbers;
  static int flag;
  static String str;
  static StringBuilder sb;

  private static void permutation(int index) {
    if (flag == 1) return;
    if (index == N) {
      StringBuilder temp = new StringBuilder();
      for (int value : numbers) {
        temp.append(value + " ");
      }

      if (flag == 0) {
        sb.append(temp.toString().trim());
        flag = 1;
        return;
      }

      if (str.equals(temp.toString().trim())) flag = 0;
      return;
    }

    for (int i = 1; i <= N; ++i) {
      if (!checked[i]) {
        numbers[index] = i;
        checked[i] = true;
        permutation(index + 1);
        checked[i] = false;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    str = br.readLine();

    checked = new boolean[N + 1];
    numbers = new int[N];
    sb = new StringBuilder();
    flag = -1;
    permutation(0);

    if (sb.toString().isEmpty()) System.out.println(-1);
    else System.out.println(sb);
  }
}
