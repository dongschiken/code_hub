import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	 public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringBuilder sb = new StringBuilder();
	        StringTokenizer st;
	        int T = Integer.parseInt(br.readLine());
	        for(int t = 0; t < T; t++) {
	            st = new StringTokenizer(br.readLine());
	            int N = Integer.parseInt(st.nextToken());
	            int M = Integer.parseInt(st.nextToken());
	            int K = Integer.parseInt(st.nextToken());
	            int[] homes = new int[N+M - 1];
	            st = new StringTokenizer(br.readLine());
	            for(int i = 0; i < N; i++) {
	            	homes[i] = Integer.parseInt(st.nextToken());
	            }
	            for(int i = 0; i < M - 1; i++) {
	            	homes[i+N] = homes[i];
	            }
	           
	            int result = slidingWindow(homes, N, M, K);
	            sb.append(result).append("\n");
	        }
	        System.out.println(sb);
	    }

	private static int slidingWindow(int[] homes, int N, int M, int K) {
		int count = 0;
		if(N == M) {
			int total = 0;
			for (int i = 0; i < N; i++) {
				total += homes[i];
			}
			if(total < K) {
				count++;
			}
			return count;
		}
		long sum = 0;
		for(int i = 0; i < M; i++) {
			sum += homes[i];
		}
		if(sum < K) {
			count++;
		}
		
		for(int i = 0; i < N - 1; i++) {
			sum = sum - homes[i] + homes[i + M];
			if(sum < K) count++;
		}
		return count;
	}
}
