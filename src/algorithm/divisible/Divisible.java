package algorithm.divisible;

import java.util.Arrays;

/*
   int divisor로 나누어 떨어지는 것들만 들어있는 배열을 리턴
 */

public class Divisible {

    public static void main(String[] args) {
        Divisible div = new Divisible();
        int[] array = {5, 9, 7, 10};
        System.out.println( Arrays.toString( div.divisible(array, 5) ));
    }

    public int[] divisible(int[] array, int divisor) {
        int count = 0;
        int retIndex = 0;

        for(int i=0; i < array.length; ++i){
            if(array[i] % divisor == 0) count++;
        }

        int[] ret = new int[count];

        for(int i=0; i < array.length; ++i){
            if(array[i] % divisor == 0) {
                ret[retIndex] = array[i];
                retIndex++;
            }
        }
        return ret;
    }
}