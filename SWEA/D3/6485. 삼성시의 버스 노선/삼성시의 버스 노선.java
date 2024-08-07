import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		List<int[]> list;
		Map<Integer, Integer> map;
		StringTokenizer st;
		
		for (int i = 1; i <= T; i++) {
			list = new ArrayList<>();
			map = new HashMap<>();
			int N = Integer.parseInt(br.readLine());
			
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				list.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
			}
			
			int P = Integer.parseInt(br.readLine());
			int[] arr = new int[P];
			for (int j = 0; j < P; j++) {
				int num = Integer.parseInt(br.readLine());
				arr[j] = num;
				map.put(num, 0);
				for (int k = 0; k < list.size(); k++) {
					int[] tmp = list.get(k);
					if(tmp[0] <= num && num <= tmp[1]) {
						map.compute(num, 
								(K, V) -> V == null ? 1 : ++V);
					}
				}
			}
			bw.write("#"+i);
			for (int j = 0; j < P; j++) {
				bw.write(" "+map.get(arr[j]));
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}