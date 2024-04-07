import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int problem_count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        
        int count = 0;
        int sum = 0;
        for(int i = 0; i < problem_count; i++){
           count = Integer.parseInt(st.nextToken()) == 1 ? count + 1 : 0;
            sum += count;
        }
        System.out.println(sum);
    }
    
}