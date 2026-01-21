import java.io.*;
import java.util.*;


public class Main {
    
    static class Node implements Comparable<Node> {
        int a, b;
        
        @Override
        public int compareTo(Node o) {
            if(o.b == this.b) {
                return (Integer.compare(o.a, o.b));
            }
            return Integer.compare(o.b, this.b);
        }
        
        @Override
        public String toString() {
            return a + " " + b + "\n";
        }
        
        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();
        
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Node(a, b));
        }
        
        Collections.sort(list, Comparator.reverseOrder());
        
        //System.out.println(list);
        int end = list.get(0).b;
        int count = 1;
        for(int i = 1; i < N; i++) {
            if(list.get(i).a >= end) {
                end = list.get(i).b;
                count++;
            }
        }
        System.out.println(count);
    }
}