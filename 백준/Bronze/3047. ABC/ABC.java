import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] temp = new int[3];
        HashMap<String, Integer> abcMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < temp.length; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(temp);

        abcMap.put("A", temp[0]);
        abcMap.put("B", temp[1]);
        abcMap.put("C", temp[2]);

        String abc = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(abcMap.get(abc.charAt(i)+"")+" ");
        }
        System.out.println(sb);
    }
}
