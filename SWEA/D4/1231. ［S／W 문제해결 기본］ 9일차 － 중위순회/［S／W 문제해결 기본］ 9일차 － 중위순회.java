import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static char[] ch;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
//		Queue[] queue;
		
		int T = 10;
		for (int i = 1; i <= T; i++) {
			
			int N = Integer.parseInt(br.readLine());
//			queue = new ArrayDeque[N+1];
			ch = new char[N+1];
			for (int j = 1; j < ch.length; j++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				ch[j] = st.nextToken().charAt(0);
			}
			System.out.print("#"+i+" ");
			inorder(1);
			System.out.println();
		}
		
	}
	static void inorder(int node) {
		
		if(node >= ch.length) return;
		inorder(node * 2);
		System.out.print(ch[node]);
		inorder(node * 2 + 1);
		
	}
	
}
