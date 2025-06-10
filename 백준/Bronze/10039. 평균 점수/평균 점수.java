import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        for(int i = 0; i < 5; i++) {
            int a = Integer.parseInt(br.readLine());
            a = a <= 40 ? 40 : a;
            sum += a;
        }
        System.out.println(sum / 5);
    }
}