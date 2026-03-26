import java.io.*;
import java.util.*;

public class Main {
    
    public static class Time implements Comparable<Time> {
        int s, e;
        public Time(int s, int e) {
            this.s = s;
            this.e = e;
        }
        @Override
        public int compareTo(Time t) {
            if(this.s == t.s) {
                return Integer.compare(this.e, t.e);
            } else {
                return Integer.compare(this.s, t.s);
            }
        }
        @Override
        public String toString() {
            return this.s + " " + this.e;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Time> times = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            times.add(new Time(s, e));
        }

        Collections.sort(times);
        //System.out.println(times);
        pq.offer(times.get(0).e);
        int count = 1;
        for(int i = 1; i < N; i++) {
            int first = pq.peek();
            if(times.get(i).s >= first) {
                pq.poll();
            } else {
                count++;
            }
            pq.offer(times.get(i).e);
        }
        System.out.print(count);
    }
}