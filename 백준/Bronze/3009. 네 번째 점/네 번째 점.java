import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st;
	    HashMap<Integer,ArrayList> map1 = new HashMap<Integer, ArrayList>();
	    HashMap<Integer,ArrayList> map2 = new HashMap<Integer, ArrayList>();
	    int[] l = new int[3];
	    int[] r = new int[3];
	    
	    
	    
	    for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			l[i] = Integer.parseInt(st.nextToken());
			r[i] = Integer.parseInt(st.nextToken());
		}
	    
	    for (int i = 0; i < 3; i++) {
			map1.putIfAbsent(l[i], new ArrayList());
			map2.putIfAbsent(r[i], new ArrayList());
			map1.get(l[i]).add(1);
			map2.get(r[i]).add(1);
		}
	    
	    Set<Entry<Integer, ArrayList>> set = map1.entrySet();
	    Iterator<Entry<Integer, ArrayList>> ir = set.iterator();
	    int temp = 0;
	    int min = Integer.MAX_VALUE;
	    while (ir.hasNext()) {
			Entry<Integer, ArrayList> entry = (Entry<Integer, ArrayList>) ir.next();

			if(entry.getValue().size() == 1) {
				bw.write(entry.getKey()+" ");
			}
		}
	    
	    Set<Entry<Integer, ArrayList>> set2 = map2.entrySet();
	    Iterator<Entry<Integer, ArrayList>> ir2 = set2.iterator();
	    while (ir2.hasNext()) {
			Entry<Integer, ArrayList> entry = (Entry<Integer, ArrayList>) ir2.next();
			
			if(entry.getValue().size() == 1) {
				bw.write(entry.getKey()+"");
			}
		}
	    bw.flush();
	    bw.close();
	}
}

