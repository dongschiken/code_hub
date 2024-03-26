import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Main{
    public static void main(String[] args) throws IOException, NumberFormatException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int count1 = Integer.parseInt(st.nextToken());
		int count2 = Integer.parseInt(st.nextToken());
		TreeMap<Integer, Integer> cha_treemap1 = new TreeMap<Integer, Integer>();
		TreeMap<Integer, Integer> cha_treemap2 = new TreeMap<Integer, Integer>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < count1; i++) {
			int x = Integer.parseInt(st.nextToken());
			cha_treemap1.put(x, 0);
			cha_treemap2.put(x, 0);
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < count2; i++) {
			int x = Integer.parseInt(st.nextToken());
			cha_treemap1.put(x, 1);
			if(!cha_treemap2.containsKey(x)) {
				cha_treemap2.put(x, 1);
			}
		}
		int count = 0;
		Set<Entry<Integer, Integer>>  cha_set = cha_treemap1.entrySet();
		Iterator<Entry<Integer, Integer>> ir = cha_set.iterator();
		while (ir.hasNext()) {
			Entry<java.lang.Integer, java.lang.Integer> entry =  ir.next();
			if( entry.getValue() == 0) {
				count++;
			}
		}
		
		Set<Entry<Integer, Integer>> cha2_set = cha_treemap2.entrySet();
		Iterator<Entry<Integer, Integer>> ir2 = cha2_set.iterator();
		while (ir2.hasNext()) {
			Entry<java.lang.Integer, java.lang.Integer> entry =  ir2.next();
			
			if( entry.getValue() == 1) {
				count++;
			}
		}
		System.out.println(count);
        
    }
    
}