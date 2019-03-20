package com.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/*
3
001111000000011100

5
011111000000111111000000111111

5
111010111101101001100100011100
HGFED
*/
public class 정올_1239_비밀편지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        String[] arr = new String[N];

        HashMap<String, String> map = new HashMap<>();
        map.put("000000", "A");
        map.put("001111", "B");
        map.put("010011", "C");
        map.put("011100", "D");
        map.put("100110", "E");
        map.put("101001", "F");
        map.put("110101", "G");
        map.put("111010", "H");

        String s = br.readLine().trim();
        for (int i = 0; i < N; ++i) {
            arr[i] = s.substring(i * 6, (i * 6) + 6);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; ++i) {
            String temp = map.get(arr[i]);

            if (temp != null) sb.append(temp);
            else if (temp == null) {
                for (String key : map.keySet()) {
                    int count = 0;
                    for (int j = 0; j < 6; ++j) {
                        if (key.charAt(j) != arr[i].charAt(j)) ++count;
                    }
                    if (count == 1) {
                        temp = map.get(key);
                        break;
                    }
                }
                if (temp == null) {
                    System.out.println(i + 1);
                    return;
                } else sb.append(temp);
            }
        }

        System.out.println(sb.toString());
    }
}
