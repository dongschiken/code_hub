import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		LinkedHashSet<Character> set = new LinkedHashSet<>();
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine());
			char[] ch = new char[N];
			for (int j = 0; j < ch.length; j++) {
				ch[j] = br.readLine().charAt(0);
				set.add(ch[j]);
			}
			
			List<Character> list = new ArrayList<>();
			Iterator ir = set.iterator();
			while (ir.hasNext()) {
				char c = (char) ir.next();
				list.add(c);
			}
			char a = 'A';
			int count = 0;
			for (int j = 0; j < 26; j++) {
				for (int j2 = 0; j2 < list.size(); j2++) {
					if(list.get(j2) == a) {
						list.remove(j2);
						count++;
						a++;
					}
				}
			}
			bw.write("#"+i+" "+count+"\n");
			set.clear();
			list.clear();
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
