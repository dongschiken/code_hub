import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException, NumberFormatException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String temp = "Hello World, Judge ";
        for(int i = 0; i < N; i++){
           System.out.println(temp + (i+1) +"!");
        }
    }
    
}