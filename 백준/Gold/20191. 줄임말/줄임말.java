import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        
        // 각 알파벳이 T의 각 위치에서 다음에 나타나는 위치를 미리 계산
        int[][] nextPos = new int[T.length() + 1][26];
        
        // 초기화: -1은 해당 문자가 나타나지 않음을 의미
        for (int i = 0; i <= T.length(); i++) {
            Arrays.fill(nextPos[i], -1);
        }
        
        // 뒤에서부터 계산
        for (int i = T.length() - 1; i >= 0; i--) {
            // 다음 위치의 정보를 상속
            for (int j = 0; j < 26; j++) {
                nextPos[i][j] = nextPos[i + 1][j];
            }
            
            // 현재 위치의 문자에 대한 정보 업데이트
            nextPos[i][T.charAt(i) - 'a'] = i;
        }
        
        int tIdx = 0;  // T에서의 현재 위치
        int repeatCount = 1;  // T 반복 횟수
        
        for (int i = 0; i < S.length(); i++) {
            int sIdx = S.charAt(i) - 'a';
            
            // 현재 T에서 다음 위치 찾기
            if (tIdx < T.length() && nextPos[tIdx][sIdx] != -1) {
                tIdx = nextPos[tIdx][sIdx] + 1;  // 찾은 위치 다음으로 이동
            } else {
                // 현재 T에서 찾을 수 없는 경우 다음 T로 넘어감
                repeatCount++;
                
                // T의 처음부터 다시 찾기
                if (nextPos[0][sIdx] == -1) {  // T 전체에 해당 문자가 없으면 불가능
                    System.out.println(-1);
                    return;
                }
                
                tIdx = nextPos[0][sIdx] + 1;
            }
        }
        
        System.out.println(repeatCount);
    }
}