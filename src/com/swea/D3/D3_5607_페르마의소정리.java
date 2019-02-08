package com.swea.D3;

import java.io.*;
import java.util.StringTokenizer;

/**
 * (a + b) % P = ((a % P) + (b % P)) % P
 * (a - b) % P = ((a % P) - (b % P)) % P
 * (a * b) % P = ((a % P) * (b % P)) % P
 */

/*
TESTCASE
1
10 2
 */

public class D3_5607_페르마의소정리 {
  private static final int P = 1234567891;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = null;

    int T = Integer.parseInt(br.readLine());
    for (int t = 1; t <= T; ++t) {
      String str = br.readLine();
      st = new StringTokenizer(str);
      int N = Integer.parseInt(st.nextToken());
      int R = Integer.parseInt(st.nextToken());

      long[] fact = new long[N + 1];
      long temp = 1;
      for (int i = 1; i <= N; ++i) {
        temp  = (temp * i) % P;
        fact[i] = temp;
      }
      long mo = (fact[N - R] * fact[R]) % P;
      long tResult = fermat(mo, P - 2);
      long result = (fact[N] * tResult) % P;

      bw.write("#" + t + " " + result + "\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }

  private static long fermat(long a, int p) {
    long result = 1;
    for (int i = p; i > 0; i = i / 2) {
      if (i % 2 == 1) result = (result * a) % P;
      a = (a * a) % P;
    }
    return result;
  }
}
