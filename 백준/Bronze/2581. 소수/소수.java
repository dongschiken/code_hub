
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int start = Integer.parseInt(br.readLine());
		int end = Integer.parseInt(br.readLine());
		int[] prime = new int[end+1];
		for (int i = 1; i < prime.length-1; i++) {
			prime[i+1] = 1;
		}
		OUT :
		for (int i = 2; i <= prime.length; i++) {
			for (int j = i+i; j < prime.length; j +=i) {
				if( prime[i] == 0 )continue;
				if( j % i == 0 ) {
					prime[j] = 0;
				}
			}
		}
		int sum = 0;
		int min = Integer.MAX_VALUE;
		for (int i = start; i <= end; i++) {
			if( prime[i] == 1 ) {
				min = Math.min(i, min);
				sum += i;
			}
		}
		
		if( sum == 0 || end == 0 ) {
			System.out.println(-1);
			return;
		}
		System.out.println(sum);
		System.out.println(min);
		
	}

}
