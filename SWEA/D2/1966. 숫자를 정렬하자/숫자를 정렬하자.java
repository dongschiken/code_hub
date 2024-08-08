import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[] arr;
		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			arr = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr.length; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			insertionSort(arr);
			bw.write("#"+i);
			for (int j : arr) {
				bw.write(" "+j);
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int data = arr[i];
			int j;
			// arr[j] 가 데이터보다 크면이라는 조건을 for문에 넣으면 if else 구문 안넣어도 된다.
			for ( j = i-1; j >= 0 && arr[j] > data; j--) {
				arr[j+1] = arr[j];
			}
			arr[j+1] = data;
		}
	}
}
