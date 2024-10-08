import java.io.*;
import java.util.*;

public class Main {
    static int N, M, D;
    static long[] bitMap;
    static int maxKill;
    static List<Integer> archers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        
        bitMap = new long[N];
        archers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    bitMap[i] |= (1L << j);
                }
            }
        }

        dfs(0, 0);
        System.out.println(maxKill);
    }

    private static void dfs(int start, int count) {
        if (count == 3) {
            simulation();
            return;
        }

        for (int i = start; i < M; i++) {
            archers.add(i);
            dfs(i + 1, count + 1);
            archers.remove(archers.size() - 1);
        }
    }

    private static void simulation() {
        long[] copyBitMap = bitMap.clone();
        int kill = 0;

        for (int turn = 0; turn < N; turn++) {
            Set<Integer> targets = new HashSet<>();
            for (int archer : archers) {
                int target = findNearestEnemy(copyBitMap, archer);
                if (target != -1) {
                    targets.add(target);
                }
            }
            
            for (int target : targets) {
                int r = target / M;
                int c = target % M;
                if ((copyBitMap[r] & (1L << c)) != 0) {
                    copyBitMap[r] &= ~(1L << c);
                    kill++;
                }
            }

            // Move enemies
            for (int i = N - 1; i > 0; i--) {
                copyBitMap[i] = copyBitMap[i - 1];
            }
            copyBitMap[0] = 0;
        }
        maxKill = Math.max(maxKill, kill);
    }

    private static int findNearestEnemy(long[] map, int archerCol) {
        for (int d = 1; d <= D; d++) {
            for (int dc = -d; dc <= d; dc++) {
                int r = N - (d - Math.abs(dc));
                int c = archerCol + dc;
                if (r >= 0 && r < N && c >= 0 && c < M) {
                    if ((map[r] & (1L << c)) != 0) {
                        return r * M + c;
                    }
                }
            }
        }
        return -1;
    }
}