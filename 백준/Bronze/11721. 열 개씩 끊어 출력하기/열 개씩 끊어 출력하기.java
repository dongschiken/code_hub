import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException  {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String str = br.readLine();
    	for (int i = 0; i < str.length(); i += 10) {
    		if((int)Math.floor(i+10) >= str.length()) {
    			System.out.println(str.substring(i)); 
    		}else {
    			System.out.println(str.substring(i, i+10)); 
    		}
		}
    }
}
