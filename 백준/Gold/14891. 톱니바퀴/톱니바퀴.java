import java.io.*;
import java.util.*;

public class Main {
    
    static final int RIGHT = 2;
    static final int LEFT = 6;
    static int[] rollArr = new int[5];
    static char[][] magnetics = new char[5][8];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 1; i <= 4; i++) {
            magnetics[i] = br.readLine().toCharArray();
        }
        
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int magneticIdx = Integer.parseInt(st.nextToken());
            int rollDirection = Integer.parseInt(st.nextToken());
            whetherRoll(magneticIdx, rollDirection);
            doRoll();
        }
        
        int sum = 0;
        int[] weights = {0, 1, 2, 4, 8};
        for (int i = 1; i <= 4; i++) {
            if (magnetics[i][0] == '1') { // S극은 1로 처리
                sum += weights[i];
            }
        }
        System.out.println(sum);
    }
    
    public static void doRoll() {
        for (int i = 1; i <= 4; i++) {
            if (rollArr[i] == 0) continue;
            char[] temp = Arrays.copyOf(magnetics[i], 8);
            for (int k = 0; k < 8; k++) {
                int newIdx = (k + (rollArr[i] == 1 ? 1 : 7)) % 8;
                magnetics[i][newIdx] = temp[k];
            }
        }
    }
    
    public static void whetherRoll(int magneticIdx, int rollDirection) {
        Arrays.fill(rollArr, 0);
        rollArr[magneticIdx] = rollDirection;

        for (int i = magneticIdx; i < 4; i++) {
            if (magnetics[i][RIGHT] != magnetics[i + 1][LEFT]) {
                rollArr[i + 1] = -rollArr[i];
            } else {
                break;
            }
        }

        for (int i = magneticIdx; i > 1; i--) {
            if (magnetics[i][LEFT] != magnetics[i - 1][RIGHT]) {
                rollArr[i - 1] = -rollArr[i];
            } else {
                break;
            }
        }
    }
}
