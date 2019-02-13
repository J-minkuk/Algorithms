package programmers.level1;

class 약수의_합 {
  public int sumDivisor(int num) {
    int answer = 0;

    for (int i = 1; i <= num; ++i) {
      if (num % i == 0) answer += i;
    }
    return answer;
  }

  // 아래는 테스트로 출력해 보기 위한 코드입니다.
  public static void main(String[] args) {
    약수의_합 c = new 약수의_합();
    System.out.println(c.sumDivisor(12));
  }
}
