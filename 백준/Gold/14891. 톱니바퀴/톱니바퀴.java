import java.util.*;
import java.io.*;

public class Main {
    
    static int[] rollArr = new int[5];
    static char[][] magnetics = new char[5][8];
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        for(int i = 1; i <= 4; i++) {
            char[] chs = br.readLine().toCharArray();
            for(int j = 0; j < 8; j++) {
                if(chs[j] == '0') {
                    magnetics[i][j] = 'N';
                }else {
                    magnetics[i][j] = 'S';
                }
            }
        }
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int magneticIdx = Integer.parseInt(st.nextToken());
            int rollDirection = Integer.parseInt(st.nextToken());
            whetherRoll(magneticIdx, rollDirection);
            doRoll();
        }
        int sum = 0;
        int[] weights = {0, 1, 2, 4, 8};
        for (int i = 1; i <= 4; i++) {
        	if(magnetics[i][0] == 'S') {
        		sum += weights[i];
        	}
		}
        System.out.println(sum);
    }
    
    public static void doRoll() {
        char[] temp = new char[8];
        for(int i = 1; i <= 4; i++) {
            for(int j = 0; j < 8; j++) {
                temp[j] = magnetics[i][j];    
            }
            if(rollArr[i] == 1) {
                for(int k = 0; k < 8; k++) {
                    magnetics[i][(k+1)%8] = temp[k];
                }
            }else if(rollArr[i] == -1) {
                for(int k = 0; k < 8; k++) {
                    magnetics[i][k] = temp[(k+1)%8];
                }
            }
        }
    }
    
    public static void whetherRoll(int magneticIdx, int rollDirection) {
        Arrays.fill(rollArr, 0);
        if(magneticIdx == 1) {
            rollArr[1] = rollDirection;
            if(magnetics[1][2] != magnetics[2][6]) {
                rollArr[2] = -rollArr[1];
            }else return;
            if(magnetics[2][2] != magnetics[3][6]) {
                rollArr[3] = rollArr[1];
            }else return;
            if(magnetics[3][2] != magnetics[4][6]) {
                rollArr[4] = -rollArr[1];
            }
        }else if(magneticIdx == 2) {
            rollArr[2] = rollDirection;
            if(magnetics[2][6] != magnetics[1][2]) {
                rollArr[1] = -rollArr[2];
            }
            if(magnetics[2][2] != magnetics[3][6]) {
                rollArr[3] = -rollArr[2];
            }else return;
            if(magnetics[4][6] != magnetics[3][2]) {
                rollArr[4] = rollArr[2];
            }
        }else if(magneticIdx == 3) {
            rollArr[3] = rollDirection;
            if(magnetics[3][2] != magnetics[4][6]) {
                rollArr[4] = -rollArr[3];
            }
            if(magnetics[3][6] != magnetics[2][2]){
                rollArr[2] = -rollArr[3];
            }else return;
            if(magnetics[2][6] != magnetics[1][2]) {
                rollArr[1] = rollArr[3];
            }
        }else {
            rollArr[4] = rollDirection;
            if(magnetics[4][6] != magnetics[3][2]) {
                rollArr[3] = -rollArr[4];
            }else return;
            if(magnetics[3][6] != magnetics[2][2]) {
                rollArr[2] = rollArr[4];
            }else return;
            if(magnetics[2][6] != magnetics[1][2]) {
                rollArr[1] = -rollArr[4];
            }
        }
    }
}