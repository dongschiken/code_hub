import java.io.*;
import java.util.*;

public class Main {

    static List<Node> list;
    static int[] parent;
    static class Node {
        int a, b, w;
        public Node(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int lengthMax = -1;
        list = new ArrayList<>();
        
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            lengthMax = Math.max(lengthMax, w);
            list.add(new Node(a, b, w));
        }
        st = new StringTokenizer(br.readLine());
        int targetS = Integer.parseInt(st.nextToken());
        int targetE = Integer.parseInt(st.nextToken());
        int left = 0;
        int right = lengthMax;
        parent = new int[N + 1]; 
        int max = -1;
        while(left <= right) {
            int mid = (left + right) / 2;
            for(int i = 0; i <= N; i++) {
                parent[i] = i;
            }
            
            for(int i = 0; i < M; i++) {
                if(list.get(i).w >= mid) {
                    union(list.get(i).a, list.get(i).b);
                }
            }
            if(isConnected(targetS, targetE)) {
                max = Math.max(max, mid);
                left = mid + 1;
            }else {
                right = mid - 1;
                    
            }
        }
        System.out.println(max);
    }
    
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if(a == b) return;
        
        if(a > b) {
            parent[a] = b;
        }else {
            parent[b] = a;
        }
    }
    
    public static int find(int a) {
        if(a == parent[a]) {
            return a;
        }
        
        return parent[a] = find(parent[a]);
    }
    
    public static boolean isConnected(int a, int b) {
        return find(a) == find(b);
    }
}