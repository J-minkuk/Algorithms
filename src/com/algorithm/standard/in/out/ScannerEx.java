package com.algorithm.standard.in.out;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ScannerEx {

    static void preTest(int value) {

        char[] c = Integer.toString(value).toCharArray();
        StringBuilder result = new StringBuilder();

        Map<Character, String> map = new HashMap<>();
        map.put('2', "이");	map.put('3', "삼"); 	map.put('4', "사");
        map.put('5', "오");	map.put('6', "육"); 	map.put('7', "칠");
        map.put('8', "팔");	map.put('9', "구");

        for(int i=0; i < c.length; ++i) {
            if (c[i] == '0') result.append("");
            else if ( (c.length - i) == 5 ) {
                if(c[i] == '1') result.append("만");
                else result.append(map.get(c[i])).append("만");
            }
            else if ( (c.length - i) == 4 ) {
                if(c[i] == '1') result.append("천");
                else result.append(map.get(c[i])).append("천");
            }
            else if ( (c.length - i) == 3 ) {
                if(c[i] == '1') result.append("백");
                else result.append(map.get(c[i])).append("백");
            }
            else if ( (c.length - i) == 2 ) {
                if(c[i] == '1') result.append("십");
                else result.append(map.get(c[i])).append("십");
            }
            else if ( (c.length - i) == 1 ) {
                if(c[i] == '1') result.append("일");
                else result.append(map.get(c[i]));
            }
        }
        System.out.println("한글 구음: "+ result);
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("1 ~ 99999 사이의 정수를 입력하세요: ");
        int value = scan.nextInt();

        System.out.println("입력받은 수: " +value);

        preTest(value);

    }

}