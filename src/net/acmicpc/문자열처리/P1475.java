package net.acmicpc.문자열처리;

import java.util.*;

/**
 * 방 번호
 * 6은 9를 뒤집어서 이용할 수 있고, 9는 6을 뒤집어서 이용할 수 있다.
 */
public class P1475 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int input = scanner.nextInt();
    String roomNumber = String.valueOf(input);

    int[] countArr = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    for (int i = 0; i < roomNumber.length(); ++i) {
      String temp = String.valueOf(roomNumber.charAt(i));
      if (roomNumber.charAt(i) == '9') {
        countArr[6]++;
      }
      else {
        countArr[Integer.parseInt(temp)]++;
      }
    }

    countArr[6] = (countArr[6] / 2) + (countArr[6] % 2);
    Arrays.sort(countArr);
//    System.out.println(Arrays.toString(countArr));
    System.out.println(countArr[countArr.length - 1]);
  }
}
