import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] positions = new int[M];
        for (int i = 0; i < M; i++) {
            positions[i] = Integer.parseInt(st.nextToken());
        }
        
        int left = 1; 
        int right = N;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (canCoverAll(mid, positions, N)) {

                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        System.out.println(left); 
    }
    
    private static boolean canCoverAll(int h, int[] positions, int N) {
        // 첫 번째 가로등이 굴다리 시작점을 비추는지 확인
        if (positions[0] - h > 0) {
            return false; 
        }
        
        // 연속된 가로등 사이의 거리가 2*h 이하인지 확인
        for (int i = 1; i < positions.length; i++) {
            if (positions[i] - positions[i-1] > 2 * h) {
                return false;
            }
        }
        
        // 마지막 가로등이 굴다리 끝점을 비추는지 확인
        if (N - positions[positions.length - 1] > h) {
            return false;
        }
        
        return true;
    }
}