import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long x = 1;
        long sum = 0;
        long cnt = 1;
        while(true) {
            x++;
            sum += x;
            cnt++;
            if(sum >= N) {
                cnt -= 1;
                break;
            }
        }
        System.out.println(cnt);
    }
}