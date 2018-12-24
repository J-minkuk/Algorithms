package kakao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * KAKAO CODE FESTIVAL NEWLINE
 * 상금 헌터
 */
public class A2018 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int testCase = scanner.nextInt();
    int rankBefore[] = new int[testCase];
    int rankNow[] = new int[testCase];

    Map<Integer, Integer> priceBefore = new HashMap<>();
    priceBefore.put(1, 500);
    priceBefore.put(2, 300);
    priceBefore.put(3, 200);
    priceBefore.put(4, 50);
    priceBefore.put(5, 30);
    priceBefore.put(6, 10);

    Map<Integer, Integer> priceNow = new HashMap<>();
    priceNow.put(1, 512);
    priceNow.put(2, 256);
    priceNow.put(3, 128);
    priceNow.put(4, 64);
    priceNow.put(5, 32);

    int before[] = { 1, 3, 6, 10, 15, 21 };
    int now[] = { 1, 3, 7, 15, 31 };

    for (int i = 0; i < testCase; ++i) {
      rankBefore[i] = scanner.nextInt();
      rankNow[i] = scanner.nextInt();
    }

    for (int i = 0; i < testCase; ++i) {
      int reward = 0;
      for (int j = 0; j < before.length; ++j) {
        if (rankBefore[i] <= before[j]) {
          if (rankBefore[i] == 0) {
            reward += 0;
          }
          else {
            reward += priceBefore.get(j + 1);
            break;
          }
        }
      }
      for (int j = 0; j < now.length; ++j) {
        if (rankNow[i] <= now[j]) {
          if (rankNow[i] == 0) {
            reward += 0;
          }
          else {
            reward += priceNow.get(j + 1);
            break;
          }
        }
      }
      System.out.println(reward * 10000);
    }
  }
}
