package com.algorithm.standard.in.out;

public class StringBuilderEx {

    public static void main(String[] args) {
        String[] unit = { "", "십", "백", "천", "만" };
        String[] number = { "", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구" };

        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < args[0].length(); ++i) {
            int current = Character.getNumericValue(args[0].charAt(i));
            if(current == 0) continue;
            builder.append((current != 1 ||
                            args[0].length() == 1 ||
                            (i+1) == args[0].length() ? number[current] : ""))
                    .append(unit[args[0].length() - (i+1)]);
        }
        System.out.println(builder.toString());
    }

}
