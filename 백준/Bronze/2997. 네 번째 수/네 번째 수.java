
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] arr = new int[3];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 3; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);

		
		int temp = 0;
		int x = arr[1] - arr[0] ;
		int y = ( arr[2] - arr[1] );
		temp = Math.abs(x - y);
		if( temp == 0 ) {
			System.out.println(arr[2] + x); //
		}else {
			if( x > y ) {
				System.out.println(arr[0] + y);
			}else {
				System.out.println(arr[1] + x);
			}
		}
	
		
	}

}
