import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        out:
        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int[] A = new int[N];
            int[] B = new int[N];
            int[] C = new int[N];
            int[] D = new int[N];
            int[] AB = new int[N * N];
            int[] CD = new int[N * N];
            input(A, st, N);
            input(B, st, N);
            input(C, st, N);
            input(D, st, N);
            
            int idx = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    AB[idx++] = A[i] + B[j]; 
                }
            }
            
            
            idx = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    CD[idx++] = C[i] + D[j];
                }
            }
            Arrays.sort(CD);
            int minDiff = Integer.MAX_VALUE;
            int bestSum = Integer.MAX_VALUE;
            for(int i = 0; i < AB.length; i++) {
                int cdIdx = Arrays.binarySearch(CD, K - AB[i]);
                
                if(cdIdx < 0) {
                    cdIdx = -(cdIdx + 1);
                    
                    int[] lrIdx = new int[2];
                    if(cdIdx > 0) {
                        lrIdx[0] = cdIdx - 1;
                    }
                    
                    if(cdIdx < CD.length) {
                        lrIdx[1] = cdIdx;
                    }
                    
                    // 두값을 K와 계산
                    for(int j = 0; j < lrIdx.length; j++) {
                        int currentSum = AB[i] + CD[lrIdx[j]];
                        int currDiff = Math.abs(K - currentSum);
                        
                        if(currDiff < minDiff || 
                           (currDiff == minDiff && currentSum < bestSum)) {
                            minDiff = currDiff;
                            bestSum = currentSum;
                        }
                    }
                }else {
                    bestSum = K;
                    break;
                }
            }
            sb.append(bestSum).append("\n");
        }
        System.out.println(sb);
    }
    
    public static void input(int[] arr, StringTokenizer st, int N) throws Exception {
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}