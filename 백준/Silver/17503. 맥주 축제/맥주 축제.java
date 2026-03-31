import java.io.*;
import java.util.*;

public class Main {
    
    static class Beer implements Comparable<Beer> {
        int v, c;
        public Beer(int v, int c) {
            this.v = v; // 맥주 선호도
            this.c = c; // 맥주 알콜 수치
        }
        
        @Override
        public int compareTo(Beer o1) {
            return Integer.compare(o1.v, this.v);
        }
        
        @Override
        public String toString() {
            return this.v + " " + this.c;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 축제 전체 날짜
        int M = Integer.parseInt(st.nextToken()); // 선호도의 합
        int K = Integer.parseInt(st.nextToken()); // 맥주 수
        List<Beer> beers = new ArrayList<>();
        long end = -1; // 간 레벨 이분탐색용
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            end = Math.max(end, c);
            beers.add(new Beer(v, c));
        }
        
        Collections.sort(beers);
        //System.out.println(beers);
        long start = 0;
        boolean check = false;
        while(start <= end) {
            long mid = (start + end) / 2;
            
            int count = 0;
            long sum = 0;
            for(int i = 0; i < K; i++) {
                if(beers.get(i).c <= mid) {
                    sum += beers.get(i).v;
                    count++;
                }
                if(count >= N) break;
            }
            
            if(sum >= M && count >= N) {
                check = true;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        // System.out.println(start + " " + end);
        if(check) {
            System.out.println(start);
        } else {
            System.out.println(-1);
        }
    }
}