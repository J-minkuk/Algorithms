package com.swea.D3;

import java.io.*;

public class D3_6718 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("C:\\intelliJ_workspaces\\Algorithm\\src\\com\\swea\\D3\\testcase\\6718_input.txt"));
    BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int t = 1; t <= T; ++t) {
      int temp = Integer.parseInt(br.readLine());
      double dis = temp * 0.001;
      int result = 0;

      if (dis < 0.1) result = 0;
      else if (dis < 1) result = 1;
      else if (dis < 10) result = 2;
      else if (dis < 100) result = 3;
      else if (dis < 1000) result = 4;
      else result = 5;

      System.out.println("#" + t + " " + result);
    }
  }
}
