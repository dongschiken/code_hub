import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tree_count = (int)Long.parseLong(st.nextToken());
        long my_tree = Long.parseLong(st.nextToken());

        long[] tree_arr = new long[tree_count];
        long max = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < tree_count; i++){
            tree_arr[i] = Long.parseLong(st.nextToken());
            if( max < tree_arr[i] ){
                max = tree_arr[i];
            }
        }

        max++;
        long min = 0;
        long mid = 0;

        while ( max > min ){

            mid = (max+min) / 2;
            long number = 0;
            long temp = 0 ;
            for (int i = 0; i < tree_count; i++){
                if( (temp = tree_arr[i] - mid) > 0){
                    number += temp;
                }
            }


            if( number >= my_tree ){
                min = mid+1;
            }else{
                max = mid;
            }
        }
        System.out.println(max-1);

    }
}
