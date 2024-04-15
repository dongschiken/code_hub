
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        LinkedHashMap<String, String> poketmon_map_num = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> poketmon_map_str = new LinkedHashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int poketmon_count = Integer.parseInt(st.nextToken());
        int output_count = Integer.parseInt(st.nextToken());

        for (int i = 0; i < poketmon_count; i++) {
            String s = br.readLine();
            poketmon_map_num.put(i+1+"", s);
            poketmon_map_str.put( s, i+1);
        }

        for (int i = 0; i < output_count; i++) {
            String s = br.readLine();
            if( poketmon_map_str.containsKey(s)){
                sb.append(poketmon_map_str.get(s)+"\n");
            }else if( poketmon_map_num.containsKey(s)){
                sb.append(poketmon_map_num.get(s)+"\n");
            }
        }
        System.out.println(sb);

    }
}
