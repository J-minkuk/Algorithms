package net.acmicpc.DisJointSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1976_DisJointSet {
    static int[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 도시의 수
        int M = Integer.parseInt(br.readLine());    // 여행 계획에 속한 도시의 수
        int[][] city = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; ++i) {
            String[] s = br.readLine().split(" ");
            for (int j = 1; j < N + 1; ++j) {
                city[i][j] = Integer.parseInt(s[j - 1]);
            }
        }

        check = new int[N + 1];
        for (int i = 1; i < N + 1; ++i) {
            check[i] = i;
        }

        for (int i = 1; i < N + 1; ++i) {
            for (int j = 1; j < N + 1; ++j) {
                if (city[i][j] == 1 && find(i) != find(j)) union(i, j);
            }
        }

        String[] s = br.readLine().split(" ");
        int flag = find(Integer.parseInt(s[0]));
        for (int i = 1; i < s.length; ++i) {
            if (flag != find(Integer.parseInt(s[i]))) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    private static int find(int v) {
        if (check[v] == v) return v;
        else return check[v] = find(check[v]);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        check[b] = a;
    }
}
