import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] ch = new char[N];
        //int[] alpa = new int[26];
        for(int i = 0; i < N; i++) {
            ch[i] = br.readLine().charAt(0);
        }
        StringBuilder sb = new StringBuilder();
        int left = 0;
        int right = N - 1;
        while(left < right) {
            int minus = ch[left] - ch[right];
            
            if(minus > 0) {
                sb.append(ch[right]).append("");
                right--;
            }else if(minus < 0) {
                sb.append(ch[left]).append("");
                left++;
            }else {
                int newLeft = left;
                int newRight = right;
                boolean check = true;
                while(newLeft < newRight) {
                    newLeft++;
                    newRight--;
                    if(ch[newLeft] < ch[newRight]) {
                        check = true;
                        break;
                    }else if(ch[newLeft] > ch[newRight]) {
                        check = false;
                        break;
                    }
                }
                
                if(check) {
                    sb.append(ch[left]).append("");
                    left++;
                }else {
                    sb.append(ch[right]).append("");
                    right--;
                }
                
            }
        }
        sb.append(ch[left]).append("");
        for(int i = 0; i < sb.length(); i++) {
            System.out.print(sb.charAt(i));
            if(i % 80 == 79) {
                System.out.println();
            }
        }
    }
}