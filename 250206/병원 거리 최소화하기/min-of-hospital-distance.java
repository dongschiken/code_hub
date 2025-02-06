import java.io.*;
import java.util.*;

public class Main {

  static int N, M;
  static List<Node> hospitals = new ArrayList<>();
  static List<Node> people = new ArrayList<>();
  static boolean[] visited;
  static int[][] map;
  static int min = Integer.MAX_VALUE;

  static class Node {
    int r, c;
    public Node(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());
    // 치킨게임??
    // m개만큼 남았을 때 bfs 돌면서 거리 측정해서 sum
    // 전부다 돌았을 때 min값
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][N];

    for(int r = 0; r < N; r++) {
      st = new StringTokenizer(br.readLine());
      for(int c = 0; c < N; c++) {
        map[r][c] = Integer.parseInt(st.nextToken());
        if(map[r][c] == 1) {
          people.add(new Node(r, c));
        }
        if(map[r][c] == 2) {
          hospitals.add(new Node(r, c));
        }
      }
    }
    visited = new boolean[hospitals.size()];
    dfs(0, 0);
    System.out.println(min);

  }
  public static void dfs(int stage, int start) {
    if(stage == M) {
        min = Math.min(min, bfs());
      return;
    }
    if(stage > M) return;
    for(int i = start; i < hospitals.size(); i++) {
      visited[i] = true;
      dfs(stage + 1, i + 1);
      visited[i] = false;
    }
  }

  public static int bfs() {
    int sum = 0;
    for(int i = 0; i < people.size(); i++) {
      int min = Integer.MAX_VALUE;
      for(int j = 0; j < hospitals.size(); j++) {
        int temp = 0;
        if(visited[j]) {
          temp += Math.abs(people.get(i).r - hospitals.get(j).r)
                  + Math.abs(people.get(i).c - hospitals.get(j).c);
          min = Math.min(min, temp);
        }
      }
      if(min != Integer.MAX_VALUE) {
        sum += min;
      }
    }
    return sum;
  }
}