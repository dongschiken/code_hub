import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException, NumberFormatException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int count = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < count; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            bw.write(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}