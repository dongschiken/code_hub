import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
//		*S *LL* S* S*
//		*LL *LL *LL *S *S *LL* S*
//		*S *LL *LL *S *S *LL *LL*
		String[] cupholder = br.readLine().split("");
		int lCount = 0;
		int sCount = 0;
		
		for (int i = 0; i < cupholder.length; i++) {
			if(cupholder[i].equals("L")) {
				lCount++;
			}else {
				sCount++;
			}
		}
		if(lCount > 0) lCount = (lCount/2)+1;
		int sum = lCount + sCount;
		bw.write(sum+"");
		bw.flush();
	}

}
