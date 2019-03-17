package coding.test.line.s2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] chars = s.toCharArray();
        int size = chars.length;

        int criteria = -1;
        for (int i = 0; i < size; ++i) {
            if (chars[i] >= 65 && chars[i] <= 90) continue;
            if (chars[i] >= 97 && chars[i] <= 122) continue;
            criteria = i;
            break;
        }

        ArrayList<String> sList = new ArrayList<>();
        for (int i = 0; i <= criteria - 1; ++i) {
            StringBuilder sb = new StringBuilder();
            if (i == criteria - 1) {
                sb.append(chars[i]);
                sList.add(sb.toString());
            } else if (chars[i + 1] >= 97 && chars[i + 1] <= 122) {
                sb.append(chars[i]).append(chars[i + 1]);
                sList.add(sb.toString());
                ++i;
            } else {
                sb.append(chars[i]);
                sList.add(sb.toString());
            }
        }
//        System.out.println(sList);

        ArrayList<String> nList = new ArrayList<>();
        for (int i = criteria; i <= size - 1; ++i) {
            StringBuilder sb = new StringBuilder();
            if (i == size - 1) {
                sb.append(chars[i]);
                nList.add(sb.toString());
            } else if (chars[i] == '1' && chars[i + 1] == '0') {
                sb.append(chars[i]).append(chars[i + 1]);
                nList.add(sb.toString());
                ++i;
            } else {
                sb.append(chars[i]);
                nList.add(sb.toString());
            }
        }
//        System.out.println(nList);

        if (sList.size() != nList.size()) {
            System.out.println("error");
            return;
        }

        int SIZE = nList.size();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < SIZE; ++i) {
            result.append(sList.get(i));
            if (!nList.get(i).equals("1")) result.append(nList.get(i));
        }
        System.out.println(result.toString());
    }
}
