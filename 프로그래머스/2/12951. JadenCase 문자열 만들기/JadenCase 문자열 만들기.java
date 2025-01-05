import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        // 현재 문자가 첫번째 문자라면 조건식 체크
    	// 현재 문자가 첫번째 문자가 아니면 toLowerCase()
    	// 공백이면 넘어감
    	String[] strArr = s.split("");
    	boolean check = false;
    	for (int i = 0; i < s.length(); i++) {
			if(strArr[i].equals(" ")) {
				check = false;
				continue;
			}
			if(check == true) {
				strArr[i] = strArr[i].toLowerCase();
			}else {
				strArr[i] = strArr[i].toUpperCase();
				check = true;
			}
		}
    	for (String string : strArr) {
			answer += string;
		}
        return answer; 
    }
}