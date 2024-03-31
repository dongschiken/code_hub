import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<int[]> balloons = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            balloons.add(new int[]{i, Integer.parseInt(st.nextToken())});
        }

        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < N; i++) {
            int[] current = balloons.get(index);
            sb.append(current[0]).append(" ");
            int move = current[1];
            balloons.remove(index);

            if (balloons.isEmpty()) break;

            
            if (move > 0) {
                index = (index + move - 1) % balloons.size();
            } else {
                index = (index + move) % balloons.size();
                if (index < 0) {
                    index += balloons.size();
                }
            }
        }
        System.out.println(sb.toString().trim());
    }
}
//10
//3 2 1 -3 -1 4 -2 -5 5 6