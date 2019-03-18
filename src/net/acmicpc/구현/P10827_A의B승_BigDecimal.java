package net.acmicpc.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class P10827_A의B승_BigDecimal {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        BigDecimal a = new BigDecimal(s[0]);
        BigDecimal b = new BigDecimal(s[1]);

        BigDecimal result = BigDecimal.ONE;
        while (b != BigDecimal.ZERO) {
            result = result.multiply(a);
            b = b.subtract(BigDecimal.ONE);
        }
        System.out.println(result.toPlainString());
    }
}
