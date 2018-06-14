package array.shift;

import java.util.Arrays;

public class ShiftElement {

  static void leftShiftElement(int[] a) {
    int temp = a[0];
    int size = a.length;
    for (int i = 0; i < size - 1; ++i) {
      a[i] = a[i + 1];
    }
    a[size - 1] = temp;
  }

  static void rightShiftElement(int[] a) {
    int size = a.length;
    int temp = a[size - 1];
    for (int i = size - 2; i >= 0; --i) {
      a[i + 1] = a[i];
    }
    a[0] = temp;
  }

  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    leftShiftElement(a);
    rightShiftElement(a);
    System.out.println(Arrays.toString(a));
  }

}
