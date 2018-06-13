package programmers.level1;

public class Fibonacci {

  public long recursiveFibonacci(int num) {
    long answer = 0;
    if (num <= 1) return num;
    else answer = recursiveFibonacci(num - 1) + recursiveFibonacci(num - 2);
    return answer;
  }

  public long loopFibonacci(int num) {
    long answer = 0;
    int count = 1;
    long a = 0, b = 1;

    if (num <= 1) return num;

    while (count < num) {
      answer = a + b;
      a = b;
      b = answer;
      count++;
    }
    return answer;
  }

  // 아래는 테스트로 출력해 보기 위한 코드입니다.
  public static void main(String[] args) {
    Fibonacci c = new Fibonacci();
    int testCase = 3;
    System.out.println(c.recursiveFibonacci(testCase));
    System.out.println(c.loopFibonacci(testCase));
  }

}
