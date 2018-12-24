package net.acmicpc.array;

import java.util.Scanner;

/**
 * 음계
 */
public class P2920 {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    String str = scanner.nextLine().trim();

    String[] strArr = str.split(" ");
    String[] music = { null, "c", "d", "e", "f", "g", "a", "b", "C" };
    StringBuilder sb = new StringBuilder();

    for (String s : strArr) {
      int idx = Integer.parseInt(s);
      sb.append(music[idx]);
    }

    if (sb.toString().equals("cdefgabC")) {
      System.out.println("ascending");
    }
    else if (sb.toString().equals("Cbagfedc")) {
      System.out.println("descending");
    }
    else {
      System.out.println("mixed");
    }

  }

}
