import java.util.*;
import java.io.*;

public class Main {

    static int[][] tables = new int[5][8];
    static int[][] temp;
    static boolean[] visited;
    static int RIGHT = 2;
    static int LEFT = 6;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i = 1; i < 5; i++) {
            String str = br.readLine();
            for(int j = 0; j < str.length(); j++) {
                tables[i][j] = str.charAt(j) - '0';
            }
        }
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            temp = new int[5][8];
            visited = new boolean[5];
            st = new StringTokenizer(br.readLine());
            roll(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            for(int i = 1; i < 5; i++) {
                if(visited[i]) {
                    for(int j = 0; j < 8; j++) {
                        tables[i][j] = temp[i][j];
                    }
                }
            }
        }
        int sum = 0;
        int[] arr = {1, 2, 4, 8};
        for(int i = 1; i < 5; i++) {
            sum += tables[i][0] * arr[i - 1];
        }
        System.out.println(sum);
    }

    public static void roll(int num, int d) {
        // 1로 들어왔을 때
        if(num == 1) {
            doRoll(num, d);
            for(int i = 1; i < 4; i++) {
                if(tables[i][RIGHT] != tables[i+1][LEFT]) {
                    doRoll(i+1, d *= -1);
                }else{
                    break;
                }
            }
        }else if(num == 2) {
            doRoll(num, d);
            if(tables[num][LEFT] != tables[num-1][RIGHT]) {
                doRoll(num-1, d * -1);
            }
            for(int i = 2; i < 4; i++) {
                if(tables[i][RIGHT] != tables[i+1][LEFT]) {
                    doRoll(i+1, d *= -1);
                }else{
                    break;
                }
            }
        }else if(num == 3) {
            doRoll(num, d);
            if(tables[num][RIGHT] != tables[num+1][LEFT]) {
                doRoll(num-1, d * -1);
            }
            for(int i = 3; i > 1; i--) {
                if(tables[i][LEFT] != tables[i-1][RIGHT]) {
                    doRoll(i-1, d *= -1);
                }else{
                    break;
                }
            }
        }else if (num == 4) {
            doRoll(num, d);
            for(int i = 4; i > 1; i--) {
                if(tables[i][LEFT] != tables[i-1][RIGHT]) {
                    doRoll(i-1, d *= -1);
                }else{
                    break;
                }
            }
        }
    }

    public static void doRoll(int num, int d) {
        visited[num] = true;
        if(d == 1) {
            temp[num][0] = tables[num][7];
            for(int i = 1; i < 8; i++) {
                temp[num][i] = tables[num][i-1];
            }
        }else {
            temp[num][7] = tables[num][0];
            for(int i = 1; i < 8; i++) {
                temp[num][i-1] = tables[num][i];
            }
        }
    }
}