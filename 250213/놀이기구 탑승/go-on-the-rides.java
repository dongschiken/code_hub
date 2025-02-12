import java.io.*;
import java.util.*;

public class Main {

  static int[] dr = {-1, 1, 0, 0};
  static int[] dc = {0, 0, 1, -1};
  static int[][] map;
  static int N, M;
  static int[][] friends;
  static int[][] visited;
  static List<int[]> list = new ArrayList<>();
  static PriorityQueue<Node> pq;

  static class Node {

    int friendCnt, emptyCnt, r, c;

    public Node(int friendCnt, int emptyCnt, int r, int c) {
      this.friendCnt = friendCnt;
      this.emptyCnt = emptyCnt;
      this.r = r;
      this.c = c;
    }

    @Override
    public String toString() {
      return "Node{" +
          "friendCnt=" + friendCnt +
          ", emptyCnt=" + emptyCnt +
          ", r=" + r +
          ", c=" + c +
          '}';
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;
    // 우선순위 큐
    // 1번조건 친구찾기
    // 400개
    // 3초
    // 400 * 400 * 400 = 64,000,000
    // 현재 값이 있는곳에는 못감
    // 값이 있으면 cont, 없으면 4방탐색
    // [친구의 값][비어있는 개수]
    // 우선순위 큐<Node>
    // Node {친구의 값, 비어있는 갯수, r, c}
    // 친구의 값 -> 비어있는 개수 -> 행 -> 열
    // map[r][c] = ?
    N = Integer.parseInt(br.readLine());
    M = N * N;
    friends = new int[M][5];
    map = new int[N][N];
    visited = new int[N][N];
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      friends[i][0] = a;
      int[] arr = new int[5];
      for (int j = 1; j < 5; j++) {
        int b = Integer.parseInt(st.nextToken());
        friends[i][j] = b;
        arr[j] = b;
      }
    }
    for (int i = 0; i < M; i++) {
      bfs(i);
    }
    int score = 0;
    int[] values = {0, 1, 10, 100, 1000};
    for(int r = 0; r < N; r++) {
      for(int c = 0; c < N; c++) {
        int fCount = 0;
        for(int i = 0; i < 4; i++) {
          int nr = r + dr[i];
          int nc = c + dc[i];
          if (check(nr, nc)) {
            continue;
          }
          for (int j = 1; j < 5; j++) {
            if(friends[visited[r][c]][j] == map[nr][nc]) {
              fCount++;
            }
          }
        }
        score += values[fCount];
      }
    }
    System.out.println(score);
  }

  public static void bfs(int curr) {
    pq = new PriorityQueue<>(
        new Comparator<Node>() {
          @Override
          public int compare(Node o1, Node o2) {
            if (o1.friendCnt != o2.friendCnt) {
              return  o2.friendCnt - o1.friendCnt;
            } else if (o1.emptyCnt != o2.emptyCnt) {
              return o2.emptyCnt - o1.emptyCnt;
            } else if (o1.r != o2.r) {
              return o1.r - o2.r;
            }
            return o1.c - o2.c;
          }
        }
    );
    for (int r = 0; r < N; r++) {
      for (int c = 0; c < N; c++) {
        if (map[r][c] == 0) {
          int friendCnt = 0;
          int emptyCnt = 0;
          for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (check(nr, nc)) {
              continue;
            }
            if (map[nr][nc] != 0) {
              for (int k = 1; k < 5; k++) {
                if (friends[curr][k] == map[nr][nc]) {
                  friendCnt++;
                }
              }
            } else {
              emptyCnt++;
            }
          }
          pq.offer(new Node(friendCnt, emptyCnt, r, c));
        }
      }
    }
    Node n = pq.poll();
    map[n.r][n.c] = friends[curr][0];
    visited[n.r][n.c] = curr;
  }

  public static boolean check(int r, int c) {
    return 0 > r || N <= r || 0 > c || N <= c;
  }
}