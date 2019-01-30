package com.swea.D3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class D3_1240 {
  public static void main(String[] args) throws IOException {
    BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
    BufferedReader br = new BufferedReader(new FileReader("C:\\intelliJ_workspaces\\Algorithm\\src\\com\\swea\\TODO\\testcase\\1240input_1.txt"));
    Map<String, Integer> map = new HashMap<>();
    map.put("0001101", 0);
    map.put("0011001", 1);
    map.put("0010011", 2);
    map.put("0111101", 3);
    map.put("0100011", 4);
    map.put("0110001", 5);
    map.put("0101111", 6);
    map.put("0111011", 7);
    map.put("0110111", 8);
    map.put("0001011", 9);

    int T = Integer.parseInt(br.readLine());
    for (int t = 1; t <= T; ++t) {
      String[] NM = br.readLine().split(" ");
      int N = Integer.parseInt(NM[0]);
      int M = Integer.parseInt(NM[1]);
      char[][] chars = new char[N][M];
      for (int i = 0; i < N; ++i) {
        String str = br.readLine();
        for (int j = 0; j < M; ++j) {
          chars[i][j] = str.charAt(j);
        }
      }

      // 암호 코드 추출하기 (암호코드 마지막이 다 '1'이다.)
      int idx = 0;
      boolean flag = true;
      String row = null;
      for (int i = 0; i < N; ++i) {
        for (int j = 0; j < M; ++j) {
          row = String.valueOf(chars[i]);
          idx = row.lastIndexOf('1');
          if (idx != -1) {
            flag = false;
            break;
          }
        }
        if (!flag) break;
      }

      // 암호 코드 유효성 판단을 위한 배열 저장
      String[] code = new String[8];
      int codeIdx = 0;
      for (int i = (idx - 56) + 1; i <= idx; i += 7) {
        String temp = row.substring(i, i + 7);
        code[codeIdx++] = temp;
      }

      int oddSum = 0;   // 홀수
      int evenSum = 0;  // 짝수
      for (int i = 0; i < code.length; ++i) {
        // 인덱스로 구분하기 때문에 나머지 0이 홀수번째
        if (i % 2 == 0) oddSum += map.get(code[i]);
        else evenSum += map.get(code[i]);
      }

      System.out.print("#" + t + " ");
      int result = (oddSum * 3) + evenSum;
      if (result % 10 == 0) System.out.print(oddSum + evenSum);
      else System.out.print(0);
      System.out.println();
    }
  }
}
