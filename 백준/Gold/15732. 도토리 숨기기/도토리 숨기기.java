import java.util.*;
import java.io.*;

public class Main {
    
    public static class Box {
        int s, e, w;
        public Box(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = 1;
        int r = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        List<Box> boxs = new ArrayList<>();
        
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            boxs.add(new Box(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        
        while(l <= r) {
            int mid = (r + l) / 2;
            
            long sum = 0;
            for(Box box : boxs) {
                // 범위 안에 들어있는지
                if(box.s <= mid && box.e >= mid) {
                    sum += ((mid - box.s) / box.w) + 1;
                } else if(box.e <= mid) {
                    sum += ((box.e - box.s) / box.w) + 1;
                }
            }

            if(sum < D) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println(l);
    }
}