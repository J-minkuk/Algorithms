package coding.test.line.s2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] CB = br.readLine().split(" ");
        int C = Integer.parseInt(CB[0]);
        int B = Integer.parseInt(CB[1]);

        int idx = 0;
        boolean flag = false;
        while (C <= 200000) {
            C += idx;
            if (C < B) break;
            if (go(idx, C, B)) {
                flag = true;
                break;
            }
            ++idx;
        }

        if (flag) System.out.println(idx);
        else System.out.println(-1);
    }

    private static boolean go(int idx, int C, int B) {
        if (idx == 0 && C == B) return true;
        else {
            if (idx == 0) return false;
            else {
                --idx;
                if (C % 2 == 0) return go(idx, C / 2, B);
                else return go(idx, C - 1, B);
            }
        }
    }
}