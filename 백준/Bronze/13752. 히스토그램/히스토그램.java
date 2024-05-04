import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException, NumberFormatException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < testcase; i++){
            int temp = Integer.parseInt(br.readLine());
            System.out.println("=".repeat(temp));
        }
    }
}