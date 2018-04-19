package binary;

/*
    이진수 1과 1 사이 0의 개수의 최댓값 리턴
 */

public class BinaryGap {

    static public int solution(int N) {
        char[] str = Integer.toBinaryString(N).toCharArray();
        int count = 0;
        int binaryGap = 0;

        for(Character c : str) {
            if(c.equals('0')) count++;
            if(c.equals('1')) {
                if(count > binaryGap) binaryGap = count;
                count = 0;
            }

        }
        return binaryGap;
    }

    public static void main(String[] args) {
        System.out.println(solution(1041));
    }

}