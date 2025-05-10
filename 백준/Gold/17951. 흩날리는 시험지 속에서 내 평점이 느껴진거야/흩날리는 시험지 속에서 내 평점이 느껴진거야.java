import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());  // K개의 그룹으로 나눔

    int[] scores = new int[N];
    st = new StringTokenizer(br.readLine());
    int right = 0;  // 가능한 최대 점수
    for(int i = 0; i < N; i++) {
      scores[i] = Integer.parseInt(st.nextToken());
      right += scores[i];  // 모든 문제 점수의 합
    }

    int left = 0;
    int answer = 0;

    // 이진 탐색으로 각 그룹의 최소 점수를 찾음
    while(left <= right) {
      int mid = (left + right) / 2;  // 각 그룹의 최소 점수
      
      int groups = 0;  // 만들어진 그룹 수
      int sum = 0;     // 현재 그룹의 점수 합
      
      // 각 그룹의 점수 합이 mid 이상이 되도록 그룹을 나눔
      for(int i = 0; i < N; i++) {
        sum += scores[i];
        if(sum >= mid) {  // 현재 그룹의 점수 합이 mid 이상이면 그룹 완성
          groups++;
          sum = 0;
        }
      }
      
      if(groups >= K) {  // K개 이상의 그룹을 만들 수 있다면
        answer = mid;    // 현재 mid가 가능한 답
        left = mid + 1;  // 더 큰 점수로 시도
      } else {
        right = mid - 1; // 더 작은 점수로 시도
      }
    }
    
    System.out.println(answer);
  }
}