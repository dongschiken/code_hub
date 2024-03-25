import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws IOException, NumberFormatException {
		// TreeMap을 사용하면 contains()를 사용했을때 엄청 빠른 속도로 검색작업이 이루어진다.
		// 그래서 key를 이용해서 같은값이 있을때 value값을 0으로 바꿔서 출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String s = new String();
		int l_size = Integer.parseInt(st.nextToken());
		int s_size = Integer.parseInt(st.nextToken());
		TreeMap<String, Integer> ls_map = new TreeMap<String, Integer>();
		for (int i = 0; i < l_size; i++) {
			ls_map.put(br.readLine(), 1 );
		}
		// s가  ls_map에 이미 있는 값일경우 value를 0으로 바꾼다. ( 듣과 보가 둘다 입력될 경우 0으로 바꾸는 로직 )
		for (int i = 0; i < s_size; i++) {
		s = br.readLine();
		if(ls_map.containsKey(s)) {
			ls_map.put(s, 0);
		};
		}
		Set<Entry<String,Integer>>  set = ls_map.entrySet();
		Iterator<Entry<String, Integer>> ir = set.iterator();
		StringBuilder sb = new StringBuilder();
		int count = 0;
		while (ir.hasNext()) {
			Entry<String, Integer> entry =  ir.next();
			String key = entry.getKey();
			int value = entry.getValue();
			if( value == 0) {
				count++;
				sb.append(key +"\n");
			}
		}
		System.out.println(count);
		System.out.println(sb);
		
	}
	

}


