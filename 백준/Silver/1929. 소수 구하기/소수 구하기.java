import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 소수 : 약수가 자신과 1밖에 없는 숫자
		// 11 ==> 1, 11		  ( 소수 o )
		// 10 ==> 1, 2, 5, 10 ( 소수 x )
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
        
		int s_number = Integer.parseInt(st.nextToken());
		int e_number = Integer.parseInt(st.nextToken());
		int[] num_arr = new int[e_number+1];
		for (int i = 2; i <= e_number; i++) {
			num_arr[i] = i;
		} 
        // 2부터 시작해서 배열의 방이 0이면 continue
        // i+i가 j의 배수라면 j인덱스에 있는 숫자값을 0으로 바꾼다.
		for (int i = 2; i <= Math.sqrt(e_number); i++) {
			if(num_arr[i] == 0) continue;
			for (int j = i+i; j <= e_number; j += i) {
				num_arr[j] = 0;
			}
		}
        // 시작점은 s_number부터 e_number까지로 설정
		for (int i = s_number; i <= e_number; i++) {
			if(num_arr[i] != 0) {
				bw.write(num_arr[i]+"\n");
			}
		}
        bw.flush();
        bw.close();
        br.close();
	}
}

