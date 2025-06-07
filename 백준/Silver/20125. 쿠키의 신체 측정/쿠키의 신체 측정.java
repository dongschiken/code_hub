import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] board = new char[N][N];
        
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }
        
        // 심장
        int heartRow = -1, heartCol = -1;
        outer: for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == '*') {
                    heartRow = i + 1;
                    heartCol = j;
                    break outer;
                }
            }
        }
        
        // 왼쪽 팔
        int leftArm = 0;
        for (int j = heartCol - 1; j >= 0; j--) {
            if (board[heartRow][j] == '*') {
                leftArm++;
            } else {
                break;
            }
        }
        
        // 오른쪽 팔
        int rightArm = 0;
        for (int j = heartCol + 1; j < N; j++) {
            if (board[heartRow][j] == '*') {
                rightArm++;
            } else {
                break;
            }
        }
        
        // 허리
        int waist = 0;
        int waistEnd = heartRow;
        for (int i = heartRow + 1; i < N; i++) {
            if (board[i][heartCol] == '*') {
                waist++;
                waistEnd = i;
            } else {
                break;
            }
        }
        
        // 왼쪽 다리
        int leftLeg = 0;
        for (int i = waistEnd + 1; i < N; i++) {
            if (board[i][heartCol - 1] == '*') {
                leftLeg++;
            } else {
                break;
            }
        }
        
        // 오른쪽 다리
        int rightLeg = 0;
        for (int i = waistEnd + 1; i < N; i++) {
            if (board[i][heartCol + 1] == '*') {
                rightLeg++;
            } else {
                break;
            }
        }
        
        System.out.println((heartRow + 1) + " " + (heartCol + 1));
        System.out.println(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);
    }
}