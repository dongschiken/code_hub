import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for(int i = 0 ; i < arr.length; i++){
           System.out.print(arr[i]+" ");
        }
    }
}