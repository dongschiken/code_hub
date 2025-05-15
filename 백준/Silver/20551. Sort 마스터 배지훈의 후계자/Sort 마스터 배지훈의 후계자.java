import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        long[] arr = new long[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        
        Arrays.sort(arr);
        
        for(int i = 0; i < M; i++) {
            long target = Long.parseLong(br.readLine());
            
            // 하나의 이진 검색으로 처리
            int index = findFirstOccurrence(arr, target);
            if (index < N && arr[index] == target) {
                sb.append(index).append("\n");
            } else {
                sb.append(-1).append("\n");
            }
        }
        
        System.out.print(sb);
    }
    
    // target과 같거나 큰 첫 번째 요소의 인덱스를 찾는 함수
    public static int findFirstOccurrence(long[] arr, long target) {
        int left = 0;
        int right = arr.length - 1;
        int result = arr.length; // 기본값은 배열 범위 밖
        
        while (left <= right) {
            int mid = left + (right - left) / 2; // 오버플로우 방지
            
            if (arr[mid] >= target) {
                result = mid; // 가능한 결과 저장
                right = mid - 1; // 더 작은 인덱스 탐색
            } else {
                left = mid + 1;
            }
        }
        
        return result;
    }
}