package programmers.level1;

class Fibonacci {

//    public long fibonacci(int num) {
//        long answer = 0;
//        if (num <= 1) return num;
//        else answer = fibonacci(num - 1) + fibonacci(num - 2);
//        return answer;
//    }

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String[] args) {
        Fibonacci c = new Fibonacci();
        int testCase = 3;
        System.out.println(c.fibonacci(testCase));
    }

    public long fibonacci(int num) {
        long answer = 0;
        int count = 1;
        long a = 0, b = 1;

        while(count < num) {
            answer = a + b;
            a = b;
            b = answer;
            count++;
        }
        return answer;
    }
}
