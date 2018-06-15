package com.algorithm.standard.in.out;

public class Ex01 {

    public static void main(String[] args) {
        String[] unit = { "", "십", "백", "천", "만" };
        String[] value = { "", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구" };

        for(int i=0; i < args[0].length(); ++i) {
            int currentV = Character.getNumericValue(args[0].charAt(i));

            if((args[0].length() - i) != 1) {
                if(currentV == 0) System.out.print("");
                else if(currentV == 1) System.out.print(unit[args[0].length() - (i+1)]);
                else System.out.print(value[currentV]+""+unit[args[0].length() - (i+1)]);
            }
            else System.out.print(value[currentV]);
        }
    }

}