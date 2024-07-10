import java.util.*;
import java.io.*;

public class Main {
	
	static int[] temp;
	
	public static void main(String[] args) throws IOException, NumberFormatException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<Integer> list = new ArrayList<Integer>();
		int[] height = new int[9];
		temp = new int[9];
		int sum = 0;
		for (int i = 0; i < height.length; i++) {
			height[i] = Integer.parseInt(br.readLine());
			sum += height[i];
		}
		OUT:
		for (int i = 0; i < 8; i++) {
			for (int j = i+1; j < 9; j++) {
				if( sum - height[i] - height[j] == 100) {
					height[i] = 0;
					height[j] = 0;
					break OUT;
				}
			}
		}
		
		mergeSort(height);
		for (int i = 2; i < height.length; i++) {
			bw.write(temp[i]+"\n");
		}
		bw.flush();
		bw.close();
		
	}

	private static void mergeSort(int[] height) {
		
		division(0, 8, height);
		
	}

	private static void division(int start, int end, int[] height) {
		if(start == end) return;
		int middle = (start + end)/2;
		
		division(start, middle, height);
		division(middle+1, end, height);
		merge(start, middle, end, height);
		
	}

	private static void merge(int start, int middle, int end, int[] height) {
		int l = start;
		int r = middle+1;
		int now_index = start;
		while (l <= middle && r <= end) {
			if(height[l] <= height[r]) {
				temp[now_index] = height[l];
				l++;
				now_index++;
			}else {
				temp[now_index] = height[r];
				r++;
				now_index++;
			}
		}
		
		if(l > middle) {
			while (r <= end) {
				temp[now_index] = height[r];
				r++;
				now_index++;
			}
		}else {
			while (l <= middle) {
				temp[now_index] = height[l];
				l++;
				now_index++;
			}
		}
		
		for (int i = start; i <= end; i++) {
			height[i] = temp[i];
		}
		
	}

}
