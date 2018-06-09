package array.odd.occurences;

import java.util.HashMap;

@SuppressWarnings("Duplicates")
public class HashMapEx {

    public static int solution(int[] A) {

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int oddValue = 0;

        for (int i = 0; i < A.length; i++) {
            if (map.get(A[i]) == null) map.put(A[i], 1);
            else map.put(A[i], map.get(A[i]) + 1);
        }

        for (int key : map.keySet())
            if (map.get(key) % 2 == 1) oddValue = key;

        return oddValue;
    }

    public static void main(String[] args) {
        int[] A = {9, 3, 9, 3, 9, 7, 9};
        int[] B = {2, 2, 3, 3, 4};
        int[] C = {1, 1, 1, 3, 3, 2, 2};
        int[] D = {1, 1, 2, 2, 4, 4, 4};
        int[] E = {1};
        System.out.println(solution(A));
        System.out.println(solution(B));
        System.out.println(solution(C));
        System.out.println(solution(D));
        System.out.println(solution(E));
    }

}