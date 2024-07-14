import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 0 이상 N 이하로 나온다면 공격 아니면 공격 x
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 첫번째 개
		int dogOneAttack = Integer.parseInt(st.nextToken());
		int dogOneRest = Integer.parseInt(st.nextToken())+dogOneAttack;
		// 두번째 개
		int dogTwoAttack = Integer.parseInt(st.nextToken());
		int dogTwoRest = Integer.parseInt(st.nextToken())+dogTwoAttack;
		
		int count = 0;
		st = new StringTokenizer(br.readLine());
		int deliveryman = 0;
		while (count < 3) {
			int testcase = 0;
			deliveryman = Integer.parseInt(st.nextToken());
            // 개 공격시간 + 휴식시간과 배달 시간을 나눴을때 그 값이 0보다 크고 
            // 공격시간보다 작다면 공격받고 아니면 공격 x
			if( deliveryman % dogOneRest <= dogOneAttack && deliveryman % dogOneRest > 0) {
				testcase++;
			}
			if( deliveryman % dogTwoRest <= dogTwoAttack && deliveryman % dogTwoRest > 0) {
				testcase++;
			}
			bw.write(testcase+"\n");
			count++;
		}
		bw.flush();
	}

}
