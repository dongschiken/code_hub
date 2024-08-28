import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
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
		mergeSort(0, arr.length - 1);
		System.out.println(arr[500000]);
		
	}

	private static void mergeSort(int left, int right) {
		
		if(left < right) {
			
			int mid = (left + right) >>> 1;
			mergeSort(left, mid);
			mergeSort(mid + 1, right);
			merge(left, mid, right);
		}
	}

	private static void merge(int left, int mid, int right) {
		
		int l = left;
		int r = mid + 1;
		int idx = left;
		
		while (l <= mid && r <= right) {
			if(arr[l] <= arr[r]) {
				temp[idx++] = arr[l++];
			}else {
				temp[idx++] = arr[r++];
			}
		}
		
		if(l > mid) {
			while (r <= right) {
				temp[idx++] = arr[r++];
			}
		}else {
			while (l <= mid) {
				temp[idx++] = arr[l++];
			}
		}
		
		for (int i = left; i <= right; i++) {
			arr[i] = temp[i];
		}
		
	}
}
