import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int pCount = 0;
        int max = -1;
        for(int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pCount -= Integer.parseInt(st.nextToken());
            pCount += Integer.parseInt(st.nextToken());
            max = Math.max(pCount, max);
        }
        System.out.println(max);
    }
}