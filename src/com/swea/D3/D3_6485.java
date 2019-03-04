package com.swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D3_6485 {

    static class Node {
        public int a, b;
        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public String toString() {
            return a + " " + b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; ++t) {
            int N = Integer.parseInt(br.readLine());    // 버스 노선
            Node[] arr = new Node[N];
            for (int i = 0; i < N; ++i) {
                String[] s = br.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                arr[i] = new Node(a, b);
            }
//            System.out.println(Arrays.toString(arr));

            int P = Integer.parseInt(br.readLine());
            int[] arrP = new int[P];
            int[] result = new int[P];
            for (int i = 0; i < P; ++i) {
                arrP[i] = Integer.parseInt(br.readLine());
                for (int j = 0; j < N; ++j) {
                    Node node = arr[j];
                    if (arrP[i] >= node.a && arrP[i] <= node.b) ++result[i];
                }
            }
//            System.out.println(Arrays.toString(arrP));

            System.out.print("#" + t + " ");
            for (int v : result) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}
