
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	static int[] sort;
	static int count = 0;
	static int target = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		5 7
//		4 5 1 3 2
		// 가운데를 기준으로 2개의 index로 잘라서 1개가 남을때 까지 나눈다.
		// 1개 남으면 그때 서로 비교하면서 병합을 진행
		StringTokenizer st = new StringTokenizer(br.readLine());
		int length = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());
		
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		merge_sort(arr);
		
	}
	private static void merge_sort(int[] arr) {
		
		
		
		sort = new int[arr.length];
		divide(arr, 0, arr.length-1);
		//System.out.println(Arrays.toString(sort));
		sort = null;
		if( target > count ) {
			System.out.println(-1);
		}
	}

	private static void divide(int[] arr, int left, int right) {
		
		
		if( left == right ) return;
		
		int mid = (left + right) / 2;
		
		divide(arr, left, mid);
		divide(arr, mid+1, right);
		
		merge(arr, left, mid, right);
		
	}
	private static void merge(int[] arr, int left, int mid, int right) {
		//System.out.printf("left : %d \n right : %d \n mid : %d \n", left, right, mid);
		int l_element = left;
		int r_element = mid+1;
		int index = left;
		
		
		
		while ( l_element <= mid && r_element <= right ) {
			
			if( arr[l_element] <= arr[r_element] ) {
				sort[index] = arr[l_element];
				index++;
				l_element++;
			}else {
				sort[index] = arr[r_element];
				index++;
				r_element++;
			}
		}
		
		if( l_element > mid ) {
			while (r_element <= right) {
				sort[index] = arr[r_element];
				index++;
				r_element++;
			}
		} else {
			while (l_element <= mid) {
				sort[index] = arr[l_element];
				index++;
				l_element++;
			}
		}
		
		for (int i = left; i <= right; i++) {
			count++;
			arr[i] = sort[i];
			if(count == target) {
				System.out.println(sort[i]);
			}
		}
		
	}

}
