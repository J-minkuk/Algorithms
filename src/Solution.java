public class Solution {

  int a;
  static int b;

  void method1() {
    a = 1;
    b = 2;
  }

  static void method2() {
    Solution solution = new Solution();
    solution.a = 3;
    b = 4;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    solution.method1();
    method2();
  }
}
