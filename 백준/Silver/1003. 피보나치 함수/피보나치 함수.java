
import java.io.*;

public class Main {

    static int[][] fibo = new int[41][2];

    public static void main(String[] args) throws IOException, NumberFormatException, IOException {

        fibo[0][0] = 1;
        fibo[0][1] = 0;
        fibo[1][0] = 0;
        fibo[1][1] = 1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testcase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testcase; i++){
            int number = Integer.parseInt(br.readLine());
            fibonacci(number);
            bw.write(fibo[number][0] + " " + fibo[number][1]);
            bw.write("\n");
        }
        bw.flush();

    }

    private static void fibonacci(int number) {
        for (int i = 2; i <= number; i++) {
            if (fibo[i][0] == 0 && fibo[i][1] == 0) {
                fibo[i][0] = fibo[i - 1][0] + fibo[i - 2][0];
                fibo[i][1] = fibo[i - 1][1] + fibo[i - 2][1];
            }
        }

    }

}
