package kr.co.programmers.level1;

public class 서울에서_김서방_찾기 {
  public String findKim(String[] seoul) {
    //x에 김서방의 위치를 저장하세요.
    int x = 0;
    for (int i = 0; i < seoul.length; ++i)
      if (seoul[i].equals("Kim")) x = i;
    return "김서방은 " + x + "에 있다";
  }

  // 실행을 위한 테스트코드입니다.
  public static void main(String[] args) {
    서울에서_김서방_찾기 kim = new 서울에서_김서방_찾기();
    String[] names = {"Queen", "Tod", "Kim"};
    System.out.println(kim.findKim(names));
  }
}
