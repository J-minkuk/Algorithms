package com.swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class D3_5986 {
    static ArrayList<Integer> primeList;
    static int totalCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; ++t) {
            int N = Integer.parseInt(br.readLine());
            totalCount = 0;
            getPrimeList(N);
            int SIZE = primeList.size();

            for (int i = 0; i < SIZE; ++i) {
                int x = primeList.get(i);
                for (int j = i; j < SIZE; ++j) {
                    int y = primeList.get(j);
                    if (x + y >= N) break;
                    for (int k = j; k < SIZE; ++k) {
                        int z = primeList.get(k);
                        if (x + y + z > N) break;
                        if (x + y + z == N) ++totalCount;
                        System.out.println(x + " " + y + " " + z);
                    }
                }
            }
            System.out.println("#" + t + " " + totalCount);
        }
    }

    // 2 ~ N까지 소수 구하기
    private static List<Integer> getPrimeList(int N) {
        boolean[] primeCheck = new boolean[N + 1];
        for (int i = 2; i <= N; ++i) {
            primeCheck[i] = true;
        }
        for (int i = 2; (i * i) <= N; ++i) {
            if (primeCheck[i]) {
                for (int j = (i * i); j <= N; j += i) {
                    primeCheck[j] = false;
                }
            }
        }

        primeList = new ArrayList<>();
        int size = primeCheck.length;
        for (int i = 2; i < size; ++i) {
            if (primeCheck[i]) primeList.add(i);
        }
        return primeList;
    }
}
