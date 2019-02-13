package net.acmicpc.순열조합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class P15666_순열 {
  static int M;
  static int N;
  static int[] numbers;
  static int[] result;
  static ArrayList<String> list;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] NM = br.readLine().split(" ");
    N = Integer.parseInt(NM[0]);
    M = Integer.parseInt(NM[1]);

    numbers = new int[N];
    result = new int[M];
    list = new ArrayList<>();

    String[] num = br.readLine().split(" ");
    for (int i = 0; i < N; ++i) {
      numbers[i] = Integer.parseInt(num[i]);
    }
    Arrays.sort(numbers);
    permutation(0);

    for (String s : list) {
      System.out.println(s);
    }
  }

  private static void permutation(int index) {
    if (index == M) {
      boolean flag = true;
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < result.length - 1; ++i) {
        if (result[i] > result[i + 1]) flag = false;
      }

      if (flag) {
        for (int v : result) {
          sb.append(v + " ");
        }
        if (!list.contains(sb.toString())) list.add(sb.toString());
      }
      return;
    }
    for (int i = 0; i < N; ++i) {
      result[index] = numbers[i];
      permutation(index + 1);

    }
  }
}
