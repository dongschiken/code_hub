import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int num = Integer.parseInt(br.readLine());
        
        if( num % 2 == 0 ){
            System.out.println("Duck");
        }else{
            System.out.println("Goose");
        }
    }
}