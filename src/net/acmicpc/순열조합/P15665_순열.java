package net.acmicpc.순열조합;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class P15665_순열 {
  static int M;
  static int N;
  static int[] numbers;
  static int[] result;
  static LinkedHashSet<String> set;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String[] NM = br.readLine().split(" ");
    N = Integer.parseInt(NM[0]);
    M = Integer.parseInt(NM[1]);

    numbers = new int[N];
    result = new int[M];
    StringBuilder sb = new StringBuilder();
    set = new LinkedHashSet<>();

    String[] num = br.readLine().split(" ");
    for (int i = 0; i < N; ++i) {
      numbers[i] = Integer.parseInt(num[i]);
    }
    Arrays.sort(numbers);
    permutation(0);

    for (String s : set) {
      sb.append(s).append("\n");
    }
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }

  private static void permutation(int index) {
    if (index == M) {
      StringBuilder temp = new StringBuilder();
      for (int v : result) {
        temp.append(v).append(" ");
      }
      set.add(temp.toString());
      return;
    }
    for (int i = 0; i < N; ++i) {
      result[index] = numbers[i];
      permutation(index + 1);
    }
  }
}
