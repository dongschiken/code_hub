import java.io.*;
import java.util.*;

public class Main{

    static int[] dx = {1, -1, 2, 2, 1, -1, -2, -2};
    static int[] dy = {-2, -2, -1, 1, 2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testcase; i++) {
            int l = Integer.parseInt(br.readLine());
            boolean[][] visited = new boolean[l][l];
            int[][] value = new int[l][l];
            for (int[] row : value) {
                Arrays.fill(row, -1);
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int targetX = Integer.parseInt(st.nextToken());
            int targetY = Integer.parseInt(st.nextToken());

            int result = bfs(startX, startY, visited, value, targetX, targetY, l);
            bw.write(result + "\n");
        }
        bw.flush();
    }

    private static int bfs(int startX, int startY, boolean[][] visited, int[][] value, int targetX, int targetY, int l) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        visited[startY][startX] = true;
        value[startY][startX] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curX = current[0];
            int curY = current[1];

            if (curX == targetX && curY == targetY) {
                return value[curY][curX];
            }

            for (int i = 0; i < 8; i++) {
                int newX = curX + dx[i];
                int newY = curY + dy[i];

                if (newX >= 0 && newX < l && newY >= 0 && newY < l && !visited[newY][newX]) {
                    queue.offer(new int[]{newX, newY});
                    visited[newY][newX] = true;
                    value[newY][newX] = value[curY][curX] + 1;
                }
            }
        }
        return -1;  // 도달할 수 없는 경우, 문제에서 명시하지 않았지만 기본적으로 이렇게 처리합니다.
    }
}
