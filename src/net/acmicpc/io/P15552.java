package net.acmicpc.io;

import java.io.*;
import java.util.ArrayList;

/**
 * 빠른 A+B
 */
public class P15552 {

  public static void main(String[] args) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    int t = Integer.parseInt(bufferedReader.readLine());
    ArrayList<Integer> arrayList = new ArrayList();

    for (int i = 0; i < t; ++i) {
      String[] arr = bufferedReader.readLine().split(" ");
      arrayList.add(Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]));
    }

    for (int value : arrayList) {
      bufferedWriter.write(String.valueOf(value));
      bufferedWriter.newLine();
    }
    bufferedWriter.flush();

  }

}
