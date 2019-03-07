package net.acmicpc.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class P11651_Comparator {
    static class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] arr = new Node[N];
        for (int i = 0; i < N; ++i) {
            String[] s = br.readLine().split(" ");
            arr[i] = new Node(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        }

        Arrays.sort(arr, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.y != o2.y) return o1.y - o2.y;
                else return o1.x - o2.x;
            }
        });

        for (Node n : arr) {
            System.out.println(n.x + " " + n.y);
        }
    }
}
