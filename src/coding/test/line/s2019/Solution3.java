package coding.test.line.s2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Solution3 {
    static class Row {
        String c1 = "NULL";
        String c2 = "NULL";
        String c3 = "NULL";
        String c4 = "NULL";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N1 = Integer.parseInt(br.readLine());

        String[] h1 = br.readLine().split(" ");
        ArrayList<String> header = new ArrayList<>();
        for (String s : h1) {
            header.add(s);
        }

        ArrayList<Integer> idList = new ArrayList<>();
        HashMap<Integer, Row> map = new HashMap<>();
        for (int i = 1; i < N1; ++i) {
            String[] col = br.readLine().split(" ");
            int id = Integer.parseInt(col[0]);
            Row row = new Row();
            row.c1 = col[1];
            row.c2 = col[2];
            map.put(id, row);
            idList.add(id);
        }

        int N2 = Integer.parseInt(br.readLine());
        String[] h2 = br.readLine().split(" ");
        for (int i = 1; i < h2.length; ++i) {
            header.add(h2[i]);
        }

        for (int i = 1; i < N2; ++i) {
            String[] col = br.readLine().split(" ");
            int id = Integer.parseInt(col[0]);
            if (map.containsKey(id)) {
                Row row = map.get(id);
                row.c3 = col[1];
                row.c4 = col[2];
            }
        }

        Collections.sort(idList);

        for (String h : header) {
            System.out.print(h + " ");
        }
        System.out.println();
        for (int id : idList) {
            Row row = map.get(id);
            System.out.println(row.c1 + " " + row.c2 + " " + row.c3 + " " + row.c4);
        }
    }
}