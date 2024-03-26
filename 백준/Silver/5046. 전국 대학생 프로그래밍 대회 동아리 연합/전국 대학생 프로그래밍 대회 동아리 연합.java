import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int member = Integer.parseInt(st.nextToken());
		// 현재 예산
		int budget = Integer.parseInt(st.nextToken());
		// 입력받을 호텔의 수
		int hotel  = Integer.parseInt(st.nextToken());
		// 입력받을 주의 수
		int week   = Integer.parseInt(st.nextToken());
		int week_check = 0;
		int hotel_price = 0;
		// 기존의 멤버 * price 가격을 넣어놓을 변수
		int temp_budget = budget;
		// 다음의 멤버 * price 가격을 넣어놓을 변수
		int next_budget = budget;
		while (hotel > 0) {
			hotel_price = Integer.parseInt(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int i = 0; i < week; i++) {
				week_check = Integer.parseInt(st2.nextToken());
				if(week_check >= member) {
					next_budget = member*hotel_price;
					break;
				}
			}
			temp_budget = Math.min(temp_budget, next_budget);
			hotel--;
		}
		// 마지막 입력을 받아왔을때 temp_budget이 Integer.MAX_VALUE이면 값이 들어간적 없는거니까 stay_home을 출력
		if( temp_budget == budget) {
			System.out.println("stay home");
		}else {
			System.out.println(temp_budget);
		}
		
		
	}

}
