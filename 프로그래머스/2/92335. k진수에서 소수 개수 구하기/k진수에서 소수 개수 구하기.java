import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = -1;
        // boolean[] temp = new boolean[5000001];
        // Arrays.fill(temp, true);
        // temp[0] = false;
        // temp[1] = false;
        // boolean[] isPrime = init(temp, 5000001);
        String str = change(n, k);
        StringBuilder sb2 = new StringBuilder();
        int count = 0;
        // System.out.println(str.length());
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != '0') {
                // System.out.println(str.charAt(i));
                sb2.append(str.charAt(i) + "");
            } else {
                if(sb2.toString().equals("")) continue;
                long x = Long.parseLong(sb2.toString());
                sb2 = new StringBuilder();
                // System.out.println(x);
                count += isPrime(x) ? 1 : 0;
            }
        }
        if(!sb2.toString().equals("")) {
            count += isPrime(Long.parseLong(sb2.toString())) ? 1 : 0;
        }
        // System.out.println(count);
        return answer = count;
    }
    
    public static boolean isPrime(long n) {
        if(n < 2) return false;
        int count = 0;
        for(int i = 1; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                count++;
            }
            if(count >= 2) {
                break;
            }
        }
        return count >= 2 ? false : true;
    }
    // public static boolean[] init(boolean[] temp, int n) {
    //     for(int i = 2; i <= n; i++) {
    //         for(int j = i + i; j < n; j += i) {
    //             if(!temp[j]) {
    //                 continue;
    //             } else {
    //                 if(j % i == 0) {
    //                     temp[j] = false; 
    //                 }
    //             }
    //         }
    //     }
    //     return temp;
    // }
    
    public static String change(int n, int k) {
        StringBuilder sb = new StringBuilder();
        // 나머지를 쌓고
        // 나누기
        while(n > 0) {
            int v = n % k;
            sb.append(v + "");
            n = n / k;
        }
        //System.out.println(sb.reverse().toString());
        return sb.reverse().toString();
    }
}