class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;

        // 어떤걸 탐색 조건으로 찾아야할까
        // r = n - 2 * tMax
        // l = 0;
        // 60
        long max = -1;
        for(int i = 0; i < times.length; i++) {
            max = Math.max(max, times[i]);
        }
        long l = 0;
        long r = 100_000_000_000_000L;
        
        while(l <= r) {
            long mid = (r + l) / 2;
            
            //System.out.println(mid);
            long cnt = 0;
            boolean check = false;
            for(int i = 0; i < times.length; i++) {
                cnt += mid / times[i];
                if(cnt >= n) {
                    check = true;
                    break;
                }
            }
            
            if(!check) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return answer = l;
        
    }
}