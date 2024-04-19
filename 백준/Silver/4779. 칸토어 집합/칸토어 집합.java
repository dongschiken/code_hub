import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {



    static char[] len;

    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = "";
    while( (input = br.readLine()) != null ){
        StringBuilder sb = new StringBuilder();
        int input_int = Integer.parseInt(input);
        int length = (int)Math.pow(3, input_int);
        len = new char[length];

        for (int i = 0; i < length; i++){
            len[i] = '-';
        }

        recursive_canto(0, length);


        for (int i = 0; i < length; i++){
            sb.append(len[i]+"");
        }
        System.out.println(sb);
       }
    }
    public static void recursive_canto(int start, int length){
        if( length == 1)return;
        int newLength = length/3;
        // 9 9 9
        // start 0 length 9
        //
        for (int i = start+newLength; i < start+newLength*2; i++){
            len[i] = ' ';
        }
        recursive_canto(start, newLength);
        recursive_canto( start+newLength*2, newLength);
    }
}