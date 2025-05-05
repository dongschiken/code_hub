import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] strs = new String[M];
        StringBuilder[] stbs = new StringBuilder[M];
        for(int i = 0; i < M; i++) {
            stbs[i] = new StringBuilder();
        }
        
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                stbs[j].append(str.charAt(j));
            }
        }
        
        for(int i = 0; i < M; i++) {
            strs[i] = stbs[i].toString();
        }
        
        int left = 0;
        int right = N - 1;
        int answer = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (hasDuplicate(strs, mid)) {
                // 중복이 있으면 더 적은 행을 제거해야 함
                right = mid - 1;
            } else {
                // 중복이 없으면 더 많은 행을 제거할 수 있음
                answer = mid;
                left = mid + 1;
            }
        }
        
        System.out.println(answer);
    }
    
    private static boolean hasDuplicate(String[] columns, int k) {
        HashSet<String> set = new HashSet<>();
        
        for (String column : columns) {
            // k개 행을 제거한 문자열
            String substring = column.substring(k);
            
            // 이미 집합에 있다면 중복
            if (set.contains(substring)) {
                return true;
            }
            
            set.add(substring);
        }
        
        return false;
    }
}