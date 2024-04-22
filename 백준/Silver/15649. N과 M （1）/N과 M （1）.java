import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int[] num_check;
	static boolean[] visit_check;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		num_check = new int[M];
		visit_check = new boolean[N];
		
		
		recursion(N, M, 0);
		
		bw.flush();
		bw.close();
		br.close();
		

	}
	private static void recursion(int N, int M, int index) throws IOException {
		if( index == M ) {
			for (int i = 0; i < num_check.length; i++) {
				bw.write(num_check[i]+1+" ");
			}
			bw.write("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			// 방문 안했으면
			if( visit_check[i] == false ) {
				visit_check[i] = true;
				num_check[index] = i;
                // 자식 노드들을 방문하기 위해 재귀호출
				recursion(N, M, index+1);
                // 자식 노드들 다 방문하고 오면 부모노드의 방문하지 않은 상태로 변경
				visit_check[i] = false;
			}
		}
	}

}
