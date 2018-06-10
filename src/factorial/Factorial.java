package factorial;

public class Factorial {

  static int recursiveFactorial(int n) {
    if (n <= 1) return 1;
    else return n * recursiveFactorial(n - 1);
  }

  static int loopFactorial(int n) {
    int result = 1;
    while (n > 1) {
      result *= (n--);
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(recursiveFactorial(10));
    System.out.println(loopFactorial(10));
  }
}
