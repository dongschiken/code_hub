import java.util.*;

class Solution {
    
    public static class User implements Comparable<User>{
        double failure;
        int stage;
        
        public User(double failure, int stage) {
            this.failure = failure;
            this.stage = stage;
        }
        
        @Override
        public int compareTo(User o) {
            if(this.failure == o.failure) {
                return Integer.compare(this.stage, o.stage);
            } else {
                return Double.compare(o.failure, this.failure); 
            }
        }
        
        @Override
        public String toString() {
            return stage + " " + failure;
        }
    }
    
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        List<User> users = new ArrayList<>();
        int[] counts = new int[N + 2];
        // 각 스테이지 도전자 수 계산을 위한 배열
        int[] arr = new int[N + 2];
        // 전체 유저 수
        int userTotal = stages.length;
        for(int i = 0; i < stages.length; i++) {
            counts[stages[i]]++;
        }
        for(int i = 1; i < counts.length; i++) {
            arr[i] = arr[i - 1] + counts[i];
        }
        // System.out.println(Arrays.toString(counts));
        // System.out.println(Arrays.toString(arr));
        for(int i = 1; i <= N; i++) {
            // 전체 도전자
            int value = userTotal - arr[i - 1];
            if(value == 0) {
                users.add(new User(0, i));
                continue;
            }
            double d = counts[i] / (double)value;
            System.out.println(d);
            users.add(new User(d, i));
        }
        // System.out.println(users);
        Collections.sort(users);
        // System.out.println(users);
        return answer = users.stream().mapToInt(u -> u.stage).toArray();
    }
}