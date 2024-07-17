import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 참외의 갯수
		int N = Integer.parseInt(br.readLine());
		List<int[]> list = new LinkedList<int[]>();
		StringTokenizer st;
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new int[] {
					Integer.parseInt(st.nextToken())
					, Integer.parseInt(st.nextToken())});
		}
		
		while (true) {
			if(!(list.get(0)[0] == list.get(2)[0] && list.get(1)[0] == list.get(3)[0])) {
				list.add(list.remove(0));
			}else {
				// break 되는 순간 리스트의 형태가 우리가 원하는 형태로 맞춰짐 
				// (0)[0]과 (2)[0]이 같고 (1)[0]과 (3)[0]이 같은 시점 424231 / 313142 / 232314 
				break;
			}
		}
		
		System.out.println((list.get(4)[1]*list.get(5)[1] - list.get(1)[1]*list.get(2)[1])*N);
	}

}
