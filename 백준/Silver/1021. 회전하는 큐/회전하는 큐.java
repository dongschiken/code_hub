import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// 무조건 첫번째 위치의 원소만 뽑을 수 있다.
		ArrayList<Integer> rotation_list = new ArrayList();
		ArrayList<Integer> rotation_list_temp = new ArrayList();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
//		10 
//		1 2 3
		StringTokenizer st = new StringTokenizer(br.readLine());
		int list_size = Integer.parseInt(st.nextToken());
		int testcase = Integer.parseInt(st.nextToken());
		
		
		
		for (int i = 1; i <= list_size; i++) {
			rotation_list.add(i);
			rotation_list_temp.add(i);
		}
		
		
		//  
		// count가 더 작은 list를 더 큰 list를 copy
		st = new StringTokenizer(br.readLine());
		int count = 0;
		int min = 0;
		int sum = 0;
//		10 10
//		1 6 3 2 7 9 8 4 10 5
		while (testcase > 0) {
			int found_number = Integer.parseInt(st.nextToken());
			int temp = 0;
            // 로테이션 리스트가 비어있으면 stop
				while (!rotation_list.isEmpty()) {
					temp = rotation_list.remove(0);
                    // 숫자 찾았으면 break;
					if( temp == found_number ) break; 
                    // 여기서 rotation_list.size()-1이 아닌 
                    // rotation_list.size() 이게 되야하는 이유는 맨 뒤에 추가해야해서
					rotation_list.add(rotation_list.size(), temp);
					count++;
				}
				temp = 0;
                    // rotation_list와 반대의 경우
				while (!rotation_list_temp.isEmpty()) {					
					temp = rotation_list_temp.remove(rotation_list_temp.size()-1);
					rotation_list_temp.add(0, temp);
					min++;
					//System.out.println(rotation_list_temp);
					if( temp == found_number ) {
						rotation_list_temp.remove(0);
						break; 
					}
			}
            // 위에서 몇번돌렸는지 체크해서 비교
			if( count <= min ) {
				rotation_list_temp.removeAll(rotation_list_temp);
				rotation_list_temp.addAll(rotation_list);
				//System.out.println(count);
				sum += count;
			}else {
				rotation_list.removeAll(rotation_list);
				rotation_list.addAll(rotation_list_temp);
				sum += min;
			}
			min = 0;
			count = 0;
			
			// 1 2 3 4 5 6 7 8 9 10
			// 2 9 5
			
			testcase--;
		}
		
		System.out.println(sum);
	}

}
