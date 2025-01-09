import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        String originBinary = Integer.toBinaryString(n);
        int originCount = 0;
        for(int i = 0; i < originBinary.length(); i++) {
            if(originBinary.charAt(i) == '1') {
                originCount++;
            }
        }
        while(true) {
            n++;
            String binary = Integer.toBinaryString(n);
            int count = 0;
            for(int i = 0; i < binary.length(); i++) {
                if(binary.charAt(i) == '1') count++;
            }
            if(count == originCount) {
                answer = n;
                break;
        }
    }
         return answer;
    }
}