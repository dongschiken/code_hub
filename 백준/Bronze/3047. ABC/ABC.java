import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] tempInt = new int[3];
        String[] str = new String[3];
        String[] temp = new String[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            tempInt[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(tempInt);
        for (int i = 0; i < 3; i++) {
            str[i] = tempInt[i]+"";
        }
        String abc = br.readLine();
        for (int i = 0; i < 3; i++) {
            str[i] = (char)('A'+i)+str[i];
            temp[i] = abc.charAt(i)+"";

        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if( str[j].contains(temp[i])){
                    System.out.print(str[j].substring(1)+" ");
                }
            }
        }
    }
}
