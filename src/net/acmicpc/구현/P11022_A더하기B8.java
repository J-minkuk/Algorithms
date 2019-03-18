package net.acmicpc.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11022_A더하기B8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; ++t) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            System.out.println("Case #" + t + ": " + a + " + " + b + " = " + (a + b));
        }
    }
}
