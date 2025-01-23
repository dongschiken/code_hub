import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		Map<Integer, Integer> map = new HashMap<>();
		StringTokenizer st;
		
		for(int i = 1; i <= 20; i++) {
			map.put(i, 0);
		}
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
			case "add":
				map.put( Integer.parseInt(st.nextToken()), 1);
				break;
			case "remove":
				map.replace( Integer.parseInt(st.nextToken()), 0);
				break;
			case "check":
				int result = map.get(Integer.parseInt(st.nextToken())) == 1 ? 1 : 0;
				sb.append(result).append("\n");
				break;
			case "toggle":
				int key = Integer.parseInt(st.nextToken());
				if(map.get(key) == 1) {
					map.put(key, 0);
				}else {
					map.put(key, 1);
				}
				break;
			case "all":
				for(int i = 1; i <= 20; i++) {
					map.put(i, 1);
				}
				break;
			case "empty":
				for(int i = 1; i <= 20; i++) {
					map.put(i, 0);
				}
				break;
			
			}
			}
		System.out.println(sb);
		}
	}

