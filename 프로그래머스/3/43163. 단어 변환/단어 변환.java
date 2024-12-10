import java.util.*;

class Solution {
    static List<String> list = new ArrayList<>();
    static class Node {
        String curr;
        int count;
        
        public Node(String curr, int count) {
            this.curr = curr;
            this.count = count;
        }
    }
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        for(String w : words) {
            list.add(w);
        }
        // bfs
        // 알파벳 전부 변환시켰을 때 words에 포함되어 있어야한다.
        // 26 * begin의 길이만큼 반복
        answer = bfs(begin, target);
        return answer;
    }
    
    public static int bfs(String begin, String target) {
		boolean[] visited = new boolean[list.size()];
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(begin, 0));
		
		next:
		while (!q.isEmpty()) {
			Node node = q.poll();
			if (node.curr.equals(target)) {
				return node.count;
			}

			for (int i = 0; i < begin.length(); i++) {
				// 한단어 선택해서 26번 변환해봐 -> words에 포함이 된다면 ok
				// 만약 포함이 안된다면 넘어가
				char[] curr = node.curr.toCharArray();
				char origin = curr[i];
				for (int j = 0; j < 26; j++) {
					char tmp = (char) (97 + j);
					curr[i] = tmp;
					String checkWord = String.valueOf(curr);
					for (int k = 0; k < list.size(); k++) {
						if (!visited[k] && list.get(k).equals(checkWord)) {							
							visited[k] = true;
							q.offer(new Node(checkWord, node.count + 1));
						}
					}
				}
				curr[i] = origin;
			}
		}
		return 0;
	}
}