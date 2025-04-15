import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        // 이전 알파벳에 누적
        // 0번째 알파벳과 비교해서 1이상인친구들 count해서 target보다 작거나 같으면 고
        String str = br.readLine();
        list.add(new int[26]);
        for(int i = 1; i < str.length() + 1; i++) {
            int alpa = str.charAt(i - 1) - 97;
            list.add(new int[26]);
            list.get(i)[alpa] = list.get(i - 1)[alpa] + 1;
            for(int j = 0; j < 26; j++) {
                if(j == alpa) continue;
                list.get(i)[j] = list.get(i - 1)[j];
            }
        }
        int l = 0;
        int r = 1;
        int max = -1;
        while(l <= str.length() && r <= str.length()) {
            int count = 0;
            for(int i = 0 ; i < 26; i++) {
                int minus = list.get(r)[i] - list.get(l)[i];
                if(minus > 0) {
                    ++count;
                }
            }
            if(count <= target) {
                r++;
                max = Math.max(max, Math.abs(r - l - 1));
            } else {
                l++;
            }
        }
        System.out.println(max);
    }
}