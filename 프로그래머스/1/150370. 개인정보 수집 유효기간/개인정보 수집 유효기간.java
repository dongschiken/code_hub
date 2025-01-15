import java.util.*;
import java.time.*;
import java.time.format.*;

class Solution {


  public int[] solution(String today, String[] terms, String[] privacies) {
    int[] answer = {};
    StringTokenizer st;
    // 현재 날짜 ld로 바꾸기
    // privacies의 날짜 ld로 바꾸기
    // privacies를 굳이 맵으로 안바꾸고 StringToken으로 꺼내서 날짜 변환 + A -> 함수 실행
    LocalDate todayLd = LocalDate.parse(today, DateTimeFormatter.ofPattern("yyyy.MM.dd"));
    Map<String, Integer> termsMap = new HashMap<>();
    for(String s : terms) {
      st = new StringTokenizer(s);
      termsMap.put(st.nextToken(), Integer.parseInt(st.nextToken()));
    }
    List<Integer> list = new ArrayList<>();

    for(int i = 0; i < privacies.length; i++) {
      st = new StringTokenizer(privacies[i]);
      LocalDate privaciesLd = LocalDate.parse(st.nextToken(), DateTimeFormatter.ofPattern("yyyy.MM.dd"));
      if(isExpired(todayLd, privaciesLd, termsMap.get(st.nextToken()))) {
        list.add(i + 1);
      }
    }
    Collections.sort(list);
    answer = new int[list.size()];
    for(int i = 0; i < list.size(); i++) {
        answer[i] = list.get(i);
    }
    return answer;
  }

  public static boolean isExpired(LocalDate today, LocalDate privacie, int term) {
    
    if(today.isEqual(privacie.plusMonths(term)) || today.isAfter(privacie.plusMonths(term))) { 
        return true;
    }
      return false;
  }

}