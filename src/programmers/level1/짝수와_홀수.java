package programmers.level1;

public class 짝수와_홀수 {

  String evenOrOdd(int num) {
    String result = "";
    if (num % 2 == 0) result = "Even";
    else result = "Odd";
    return result;
  }

  public static void main(String[] args) {
    String str = "1 2 3 4";
    짝수와_홀수 짝수와_홀수 = new 짝수와_홀수();
    //아래는 테스트로 출력해 보기 위한 코드입니다.
    System.out.println("결과 : " + 짝수와_홀수.evenOrOdd(3));
    System.out.println("결과 : " + 짝수와_홀수.evenOrOdd(2));
  }

}