import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		        String check = "NO";
		        String mobis = br.readLine();
		        String[] mobis_arr = {"M", "O", "B", "I", "S"};

		        for(int i = 0; i < mobis_arr.length; i++){
		            if(mobis.contains(mobis_arr[i])){
		                check = "YES";
		            }else{
		                check = "NO";
		                break;
		            }
		        }
		        System.out.print(check);
    }
        
}