import java.io.*;
import java.util.*;

public class Main{
    
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        if(s.equals("NLCS")){
            System.out.print("North London Collegiate School");
        }else if(s.equals("BHA")){
            System.out.print("Branksome Hall Asia");
        }else if(s.equals("KIS")){
            System.out.print("Korea International School");
        }else{
            System.out.print("St. Johnsbury Academy");
        }
    }
}
