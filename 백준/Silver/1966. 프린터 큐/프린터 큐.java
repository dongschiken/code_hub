import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int count = 0;
		while(count < n) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			int document_count = Integer.parseInt(st.nextToken());
			int doc_idx = Integer.parseInt(st.nextToken());
			
			int[] document = new int[document_count];
			List<Print> print_list = new ArrayList<Print>();
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int found_idx = 0;
			for (int i = 0; i < document.length; i++) {
				document[i] = Integer.parseInt(st2.nextToken());
				print_list.add(new Print(document[i], i));
			}
			while (!print_list.isEmpty()) {
				
				Print print = print_list.remove(0);
				if(print_list.stream().anyMatch(other_list -> print.priority < other_list.priority)) {
					print_list.add(print);
				}else {		
					found_idx++;
					if(doc_idx == print.idx) 
						break;
				}
			}		
			System.out.println(found_idx);
			print_list.removeAll(print_list);
			count++;
		}
	}
}
class Print {
	int priority;
	int idx;

	Print(){}
	Print(int priority, int idx){
		this.priority = priority;
		this.idx = idx;
	}
}	
