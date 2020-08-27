package programmers.level2;

import java.util.HashMap;
import java.util.Map;

/**
 * 설명 : N/A
 *
 * @author Minkuk Jo / mingood92@gmail.com / https://velog.io/@mingood
 * @since 2020. 08. 28.
 */
@SuppressWarnings("NonAsciiCharacters")
public class 위장 {

    public static int solution(String[][] clothes) {
        Map<String, Integer> countMap = new HashMap<>();
        int sum = 1;
        for (String[] clothe : clothes) {
            countMap.put(clothe[1], countMap.getOrDefault(clothe[1], 0) + 1);
        }

        for (int count : countMap.values()) {
            sum *= (count + 1);
        }
        return sum - 1;
    }

    public static void main(String[] args) {
        String[][] arr1 = {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"},
        };

        String[][] arr2 = {
                {"crow_mask", "face"},
                {"blue_sunglasses", "face"},
                {"smoky_makeup", "face"},
        };
        System.out.println(solution(arr1));
        System.out.println(solution(arr2));
    }
}
