package net.acmicpc.큐;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P11728 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    br.readLine();

    PriorityQueue<Integer> q = new PriorityQueue<>();

    StringTokenizer st = new StringTokenizer(br.readLine());
    while (st.hasMoreTokens()) {
      q.add(Integer.parseInt(st.nextToken()));
    }

    st = new StringTokenizer(br.readLine());
    while (st.hasMoreTokens()) {
      q.add(Integer.parseInt(st.nextToken()));
    }

    while(!q.isEmpty()) {
      bw.write(q.poll() + " ");
    }
    bw.flush();
  }
}
