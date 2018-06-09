package array.odd.occurences;

public class Xor {

    public static int solution(int[] A) {
        int result = 0;

        for (int i = 0; i < A.length; i++) {
            result ^= A[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {7, 5, 3, 3, 5, 9, 9, 7, 11, 14, 11, 13, 13, 14, 1};
        System.out.println(solution(A));
    }

}