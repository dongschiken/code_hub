import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        String dna = br.readLine();
        
        int[][] dp = new int[2][N];
        
        // 초기 조건 설정
        if (dna.charAt(0) == 'A') {
            dp[0][0] = 0; // 해당 위치 놔두기
            dp[1][0] = 1; // 스위치
        } else {
            dp[0][0] = 1; // 해당 위치 뒤집기
            dp[1][0] = 0; // 스위치
        }
        
        // DP 배열 채우기
        for (int i = 1; i < N; i++) {
            char current = dna.charAt(i);
            if (current == 'A') {
                dp[0][i] = Math.min(dp[0][i - 1], dp[1][i - 1] + 1);
                dp[1][i] = Math.min(dp[0][i - 1] + 1, dp[1][i - 1] + 1);
            } else {
                dp[0][i] = Math.min(dp[0][i - 1] + 1, dp[1][i - 1] + 1);
                dp[1][i] = Math.min(dp[0][i - 1] + 1, dp[1][i - 1]);
            }
        }
        
        // 결과 출력
        System.out.println(dp[0][N - 1]);
    }
}
