import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static int[] arr = new int[1000000];
	static int[] temp = new int[1000000];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 1000000; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		quickSort(0, arr.length - 1);
		System.out.println(arr[500000]);
	}

	private static void quickSort(int left, int right) {
		
		if(left < right) {
			int pivot = partition(left, right);
			quickSort(left, pivot - 1);
			quickSort(pivot + 1, right);
		}
	}

	private static int partition(int left, int right) {
		int pivot = arr[left];
		int l = left + 1;
		int r = right;
		
		while (l <= r) {
			while (l <= r && pivot >= arr[l]) l++;
			while (pivot < arr[r]) r--;
			
			if(l < r) {
				int tmp = arr[r];
				arr[r] = arr[l];
				arr[l] = tmp;
			}
		}
		
		int tmp = arr[left];
		arr[left] = arr[r];
		arr[r] = tmp;
		return r;
	}
}
