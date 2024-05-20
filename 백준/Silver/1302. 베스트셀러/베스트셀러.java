import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int testcase = Integer.parseInt(br.readLine());
		
		
		LinkedHashMap<String, ArrayList> bookMap = new LinkedHashMap<String, ArrayList>();
		
		for (int i = 0; i < testcase; i++) {
			String temp = br.readLine();
			bookMap.putIfAbsent(temp, new ArrayList());
			
			bookMap.get(temp).add(1);
			
		}
		int temp = 0;
		for (Entry<String, ArrayList> entry : bookMap.entrySet()) {
			String key = entry.getKey();
			ArrayList val = entry.getValue();
			
			if( val.size() > temp ) {
				temp = val.size();
			}
			
		}
		
		
		ArrayList<String> blist = new ArrayList<String>(); 
		Set<Entry<String, ArrayList>> bs = bookMap.entrySet();
		Iterator<Entry<String, ArrayList>> ir = bs.iterator();
		while (ir.hasNext()) {
			Entry<String, ArrayList> entry =  ir.next();
			
			String bookName = entry.getKey();
			ArrayList bookCount = entry.getValue();
			
			if( temp <= bookCount.size() ) {
				blist.add(bookName);
				temp = bookCount.size();
			}
		}
		Collections.sort(blist);
		System.out.println(blist.get(0));

		
	}

}
