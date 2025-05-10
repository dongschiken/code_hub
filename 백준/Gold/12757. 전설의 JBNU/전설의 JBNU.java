import java.io.*;
import java.util.*;
public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    TreeMap<Integer, Integer> map = new TreeMap<>();
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    for(int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }
    for(int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int command = Integer.parseInt(st.nextToken());
      if(command == 1) {
        map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
      }else if(command == 2) {
        // 조건을 만족하는 키가 있을 때
        int k = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        if(map.containsKey(k)) {
          map.put(k, v);
        } else {
          Integer l = map.floorKey(k);
          Integer r = map.ceilingKey(k);
          
          // 유효한 키가 없는 경우
          if(l == null && r == null) {
            continue;
          }
          
          int leftDist = (l != null) ? k - l : Integer.MAX_VALUE;
          int rightDist = (r != null) ? r - k : Integer.MAX_VALUE;
          
          // 거리가 같은 경우 무시
          if(leftDist == rightDist && leftDist <= K) {
            continue;
          }
          
          // 거리가 K 이하인 경우만 처리
          if(leftDist <= K && leftDist < rightDist) {
            map.put(l, v);
          } else if(rightDist <= K && rightDist < leftDist) {
            map.put(r, v);
          }
        }
      } else { // command == 3
        int k = Integer.parseInt(st.nextToken());
        if(map.containsKey(k)) {
          sb.append(map.get(k));
        } else {
          Integer l = map.floorKey(k);
          Integer r = map.ceilingKey(k);
          
          // 유효한 키가 없는 경우
          if(l == null && r == null) {
            sb.append(-1);
            sb.append("\n");
            continue;
          }
          
          int leftDist = (l != null) ? k - l : Integer.MAX_VALUE;
          int rightDist = (r != null) ? r - k : Integer.MAX_VALUE;
          
          // 거리가 같고 K 이하인 경우 ? 출력
          if(leftDist == rightDist && leftDist <= K) {
            sb.append("?");
          } 
          // 왼쪽이 더 가깝고 K 이하인 경우
          else if(leftDist <= K && leftDist < rightDist) {
            sb.append(map.get(l));
          } 
          // 오른쪽이 더 가깝고 K 이하인 경우
          else if(rightDist <= K && rightDist < leftDist) {
            sb.append(map.get(r));
          } 
          // 모든 키가 K보다 멀리 있는 경우
          else {
            sb.append(-1);
          }
        }
        sb.append("\n");
      }
    }
    System.out.println(sb);
  }
}