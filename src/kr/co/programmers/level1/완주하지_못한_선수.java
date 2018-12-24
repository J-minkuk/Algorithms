package kr.co.programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 완주하지_못한_선수 {

  public static String solution1(String[] participant, String[] completion) {
    Map<String, Integer> participantMap = new HashMap<>();
    Map<String, Integer> completionMap = new HashMap<>();

    for (String key : participant) {
      if (participantMap.get(key) == null) {
        participantMap.put(key, 0);
      } else {
        participantMap.put(key, participantMap.get(key) + 1);
      }
    }

    for (String key : completion) {
      if (completionMap.get(key) == null) {
        completionMap.put(key, 0);
      } else {
        completionMap.put(key, completionMap.get(key) + 1);
      }
    }

    String answer = "";
    for (String key : participant) {
      if (participantMap.get(key) != completionMap.get(key)) {
        answer = key;
      }
    }

    return answer;
  }

  public static String solution2(String[] participant, String[] completion) {
    String answer = "";
    Arrays.sort(participant);
    Arrays.sort(completion);

    int size = completion.length;
    for (int i = 0; i < size; ++i) {
      if (!participant[i].equals(completion[i])) {
        return participant[i];
      }
      answer = participant[i];
    }

    return answer;
  }

  public static void main(String[] args) {
    String[] participant = {"mislav", "stanko", "ana", "gitflow"};
    String[] completion = {"stanko", "mislav", "ana"};

    solution1(participant, completion);
    solution2(participant, completion);
  }

}
