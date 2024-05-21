import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testcase = Integer.parseInt(br.readLine());
		
		LinkedHashMap<Long, ArrayList<Integer>> cardMap = new LinkedHashMap<Long, ArrayList<Integer>>();
		
		ArrayList<Long> tempList = new ArrayList();
		
		for (int i = 0; i < testcase; i++) {
			long temp = Long.parseLong(br.readLine());
			
			tempList.add(temp);
			
		}
		
		Collections.sort(tempList);
		
		for (int i = 0; i < testcase; i++) {
			cardMap.putIfAbsent(tempList.get(i), new ArrayList() );
			
			cardMap.get(tempList.get(i)).add(1);
		}
		
		int temp = 0;
		for (Entry<Long, ArrayList<Integer>> entry : cardMap.entrySet()) {
			Long key = entry.getKey();
			ArrayList<Integer> val = entry.getValue();
			
			if( val.size() >= temp ) {
				temp = val.size();
			}
		}
		
		for (Entry<Long, ArrayList<Integer>> entry : cardMap.entrySet()) {
			Long key = entry.getKey();
			ArrayList<Integer> val = entry.getValue();
			
			if( val.size() == temp ) {
				bw.write(key + "");
				break;
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
