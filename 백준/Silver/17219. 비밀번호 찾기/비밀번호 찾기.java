import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int user_count = Integer.parseInt(st.nextToken());
		int found_user_pwd_count= Integer.parseInt(st.nextToken());
		// 비밀번호 찾을 회원을 담을 문자열 배열
		String[] found_users = new String[found_user_pwd_count];
		found_users[0] = "noj.am";
		
		LinkedHashMap<String, String> user_infoMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < user_count; i++) {
			st = new StringTokenizer(br.readLine());
			user_infoMap.put(st.nextToken(), st.nextToken());
		}
		for (int i = 0; i < found_user_pwd_count; i++) {
			st = new StringTokenizer(br.readLine());
			bw.write(user_infoMap.get(st.nextToken())+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
