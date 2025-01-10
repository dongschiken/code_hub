class Solution {
    public long solution(int n) {
        long answer = 0;
        long[] arr = new long[2001];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
        for(int i = 4; i < 2001; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1234567;
        }
        //System.out.println(arr[2000]); // 2 3 4 5 6
        // 1 3 5 8 13
        return arr[n];
    }
}