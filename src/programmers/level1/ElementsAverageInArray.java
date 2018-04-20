package programmers.level1;

public class ElementsAverageInArray {

  public int getMean(int[] array) {
    int average, sum = 0;

    for (int i = 0; i < array.length; ++i) {
      sum += array[i];
    }
    average = sum / array.length;
    return average;
  }

  public static void main(String[] args) {
    int x[] = {5, 4, 3};
    ElementsAverageInArray getMean = new ElementsAverageInArray();
    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    System.out.println("평균값 : " + getMean.getMean(x));
  }

}
