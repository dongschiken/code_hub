import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testcase = Integer.parseInt(br.readLine());
        String temp = "";
        for(int i = 0; i < testcase; i++ ){
            temp = br.readLine();
            if( temp.length() >= 6 && temp.length() <= 9 ){
                bw.write("yes"+"\n");
            }else{
                bw.write("no"+"\n");
            }
        }
        bw.flush();
    }
}