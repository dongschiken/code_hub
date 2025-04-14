import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int bMax = Integer.parseInt(st.nextToken());
        int wMin = Integer.parseInt(st.nextToken());
        List<int[]> list = new ArrayList<>();
        // B, W
        list.add(new int[]{0, 0});
        String str = br.readLine();
        for(int i = 0; i < N; i++) {
            int b = list.get(i)[0];
            int w = list.get(i)[1];
            if(str.charAt(i) == 'W') {
                w++;
            }else {
                b++;
            }
            list.add(new int[]{b, w});
        }
        
        int left = 0;
        int right = 1;
        int length = 0;
        while(left <= N && right <= N) {
            int bc = list.get(right)[0] - list.get(left)[0];
            int wc = list.get(right)[1] - list.get(left)[1];
            if(bc <= bMax && wc >= wMin) {
                length = Math.max(length, right - left);
            }
            
            if(bc > bMax) {
                left++;
            }else {
                right++;
            }
        }
        System.out.println(length);
    }
}