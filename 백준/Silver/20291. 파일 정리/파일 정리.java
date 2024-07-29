import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Map<String, Integer> hm = new LinkedHashMap<>();
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String[] temp = br.readLine().split("\\.");
			if(hm.containsKey(temp[1])) {
				int n = hm.get(temp[1]);
				hm.put(temp[1], ++n);
			}else {
				hm.put(temp[1], 1);
			}	
		}
		
		List<String> list = new ArrayList<>();
		Set<Entry<String, Integer>> se = hm.entrySet();
		Iterator<Entry<String, Integer>> ir =se.iterator();
		while (ir.hasNext()) {
			Entry<String, Integer> entry = ir.next();
			
			list.add(entry.getKey() +" "+ entry.getValue());
		}
		Collections.sort(list);
		for (String str: list) {
			bw.write(str+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
}
