package net.acmicpc.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.TreeSet;

public class P1764_듣보잡 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        HashMap<String, Integer> map = new HashMap<>();
        TreeSet<String> set = new TreeSet<>();

        for (int i = 0; i < N + M; ++i) {
            String s = br.readLine().trim();
            if (map.get(s) == null) map.put(s, 1);
            else map.put(s, map.get(s) + 1);
        }

        for (String key : map.keySet()) {
            if (map.get(key) > 1) set.add(key);
        }

        System.out.println(set.size());
        for (String s : set) {
            System.out.println(s);
        }
    }
}
