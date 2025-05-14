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
    
    public static boolean isMakeCardPack(Set<Integer> set, int[] arr, int mid, int M) {
        // 카드팩(result)이 M개가 되면 true 반환하고 탈출
        set.clear();
        int result = 0;
        int count = 0;
        int l = 0;
        int r = 0;
        while(r < arr.length) {
            if(!set.contains(arr[r])) {
                set.add(arr[r]);
                r++;
                count++;
            }else {
                while(arr[l] != arr[r]) {
                    l++;
                }
                l++;
                r = l;
                count = 0;
                set.clear();
            }
            
             if(count == mid) {
                count = 0;
                l = r;
                set.clear();
                result++;
            }
            if(result == M) {
                return true;
            }  
        }
        return false;
    }
}