import java.util.*;
import java.io.*;

class Solution {
    public int solution(String t, String p) throws NumberFormatException, IndexOutOfBoundsException {
		int answer = 0;
		String[] check_arr = new String[ t.length()-(p.length()-1)];
		for (int i = 0; i < t.length()-(p.length()-1); i++) {
			check_arr[i] = "";
			for (int j = 0; j < p.length(); j++) {
				check_arr[i] += ""+t.charAt(i+j);
			}
		}
		for (int i = 0; i < check_arr.length; i++) {
			if(Long.parseLong(p) >= Long.parseLong(check_arr[i])) {
				answer++;
			}
		}
        return answer;
    }
}