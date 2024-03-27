import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int repeat = Integer.parseInt(br.readLine());
		int[] recur_arr = new int[2];
		for (int i = 0; i < repeat; i++) {
			String s = br.readLine();
			recur_arr = isPalindrome(s, recur_arr);
			bw.write(recur_arr[0] + " " +recur_arr[1] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
		
		
		
	}


	public static int[] recursion(String s, int l, int r, int[] recur_arr){
		if(l >= r) {
			recur_arr[0] = 1;
			return recur_arr;
		}
		else if(s.charAt(l) != s.charAt(r)) {
			recur_arr[0] = 0;
			return recur_arr;
		}
		else {
			recur_arr[1]++;
			return recursion(s, l+1, r-1, recur_arr);
		}
	}
	public static int[] isPalindrome(String s, int[] recur_arr){
		recur_arr[1] = 1;
		return recursion(s, 0, s.length()-1, recur_arr);
	}

}



