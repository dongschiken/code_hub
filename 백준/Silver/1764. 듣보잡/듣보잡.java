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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String s = new String();
		int l_size = Integer.parseInt(st.nextToken());
		int s_size = Integer.parseInt(st.nextToken());
		TreeMap<String, Integer> ls_map = new TreeMap<String, Integer>();
		for (int i = 0; i < l_size; i++) {
			ls_map.put(br.readLine(), 1 );
		}
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


