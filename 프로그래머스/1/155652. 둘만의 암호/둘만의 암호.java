class Solution {
           
    public String solution(String s, String skip, int index) {
            String answer = "";
	        int sLength = s.length();
	        char[] s_char = new char[sLength];
	        
	        for (int i = 0; i < s_char.length; i++) {
				s_char[i] = s.charAt(i);
			}
	        // s의 길이만큼 for문
	        // index만큼 for 문을 ++돌리다가 skip문자가 나오면 skip
	        // z가 나오면 --26
	        for (int i = 0; i < sLength; i++) {
			for (int j = 0; j < index; j++) {
				s_char[i] = (char)(s_char[i]+1);
				if(skip.contains(s_char[i] + "") ) {
					j--;
				}
				if( s_char[i] == '{') {
					s_char[i] = (char) (s_char[i]-26);
					// 만약 skip에 a가 포함되어 있다면 그때도 j를 -- 해야한다.
		                	if(skip.contains(s_char[i] + "")){
		                            j--;
		                        }
				}				
				}
			}
	        
	       for (int i = 0; i < s_char.length; i++) {
			answer += ""+s_char[i];
		}
	        return answer;
	    }
    }
