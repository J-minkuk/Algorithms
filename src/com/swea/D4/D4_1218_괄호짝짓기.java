package com.swea.D4;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class D4_1218_괄호짝짓기 {
    static char[] QS = {'(', ')', '[', ']', '{', '}', '<', '>'};

    public static void main(String[] args) throws IOException {
        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("C:\\intelliJ_workspaces\\Algorithm\\src\\com\\swea\\D4\\testcase\\1218input.txt"));
        for (int t = 1; t <= 10; ++t) {
            br.readLine();
            String s = br.readLine();

            Map<Character, Integer> map = new HashMap<>();
            int length = s.length();
            for (int i = 0; i < length; ++i) {
                char c = s.charAt(i);
                if (map.get(c) == null) map.put(c, 1);
                else map.put(c, map.get(c) + 1);
            }

            boolean flag = true;
            for (int i = 0; i < QS.length - 1; i = i + 2) {
                if (map.get(QS[i]) != map.get(QS[i + 1])) {
                    flag = false;
                    break;
                }
            }

            if (flag) System.out.println("#" + t + " " + 1);
            else System.out.println("#" + t + " " + 0);
        }
    }
}
