import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        Set<Integer> set = new HashSet<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        //System.out.println(Arrays.toString(arr));
        int l = 1;
        int r = N;
        while(l <= r) {
            int mid = (r + l) / 2;
            
            if(isMakeCardPack(set, arr, mid, M)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(r);
    }
    
    public static boolean isMakeCardPack(Set<Integer> set, int[] arr, int size, int M) {
        int packCount = 0;
        int left = 0;
        Map<Integer, Integer> lastIndex = new HashMap<>();  // 각 카드 번호의 마지막 인덱스를 저장
    
        for (int right = 0; right < arr.length; right++) {
            // 현재 카드가 이미 현재 윈도우에 있고, 그 위치가 left 이후라면
            if (lastIndex.containsKey(arr[right]) && lastIndex.get(arr[right]) >= left) {
                // 중복된 카드의 이전 위치 다음으로 left 이동
                left = lastIndex.get(arr[right]) + 1;
            }
        
            // 현재 카드의 위치 저장
            lastIndex.put(arr[right], right);
        
            // 윈도우 크기가 size와 같아지면 카드팩 완성
            if (right - left + 1 == size) {
                packCount++;
                left++; // 다음 카드팩을 위해 왼쪽 포인터 이동
            
            if (packCount == M) {
                return true;
            }
            }
        }
    
        return false;
    }
}