
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String target_channel = br.readLine() ;
		int wrong_button_count = Integer.parseInt(br.readLine());

		ArrayList<Integer> wrong_button_list = new ArrayList<Integer>();
		if( wrong_button_count > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < wrong_button_count; i++){
				wrong_button_list.add(Integer.parseInt(st.nextToken()));
			}

		}

		if( wrong_button_count == 10) {
			System.out.println(Math.abs(Integer.parseInt(target_channel) - 100) );
			return;
		}
		
		
		
		
		// 모든 리모컨 순회하면서 101만번 
		// 타겟 채널의 2배+1만큼 순회
		int min = Integer.MAX_VALUE;
		int target_size = Integer.parseInt(target_channel)*2+1;
		int target_num = Integer.parseInt(target_channel);
		String current_num = "";
		String num = "";
		OUT:
		for (int i = 0; i < 1000001; i++) {
			current_num = String.valueOf(i);
			for (int j = 0; j < current_num.length(); j++) {			
				if( wrong_button_list.contains(Integer.parseInt(current_num.charAt(j)+"")))
				continue OUT;
			}
			if( min > Math.abs(i - target_num)) {
				 min = Math.min(Math.abs(i - target_num), min); 
				 num = current_num;
			}
		}
		min = num.length()+min;
		min = Math.min(Math.abs(target_num-100), min);
		System.out.println(min);
	}	

}
