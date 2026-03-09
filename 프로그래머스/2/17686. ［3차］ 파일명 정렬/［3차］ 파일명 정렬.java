import java.util.*;

class Solution {
    
    public static class File implements Comparable<File> {
        String fileName, head;
        int number;
        public File(String fileName, String head, int number) {
            this.fileName = fileName;
            this.head = head;
            this.number = number;
        }
        
        @Override
        public int compareTo(File f) {
            // head 먼저 비교
            if(!this.head.equals(f.head)) {
                return this.head.compareTo(f.head);
            } else {
                return Integer.compare(this.number, f.number);
            }
        }
        
        @Override
        public String toString() {
            return this.fileName; //+ ", " + this.head + ", " + this.number;
        }
    }
    public String[] solution(String[] files) {
        String[] answer = {};
        String numberStr = "0123456789";
        List<File> list = new ArrayList<>();
        for(int i = 0; i < files.length; i++) {
            String[] str = split(files[i].toUpperCase(), files[i], numberStr);
            list.add(new File(str[0], str[1], Integer.parseInt(str[2])));
        }
        Collections.sort(list);
        answer = new String[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).fileName;
        }
        return answer;
    }
    public static String[] split(String str, String originStr, String numberStr) {
        String[] strs = new String[4];
        strs[0] = originStr;
        String temp = "";
        int remain = 0;
        out:
        for(int i = 0; i < str.length(); i++) {
            // 숫자아닐때
            if(!numberStr.contains(str.substring(i, i + 1))) {
                temp += str.substring(i, i + 1);
            } else {
                // 숫자나오면 문자열 or 최대 5개 만날 때 까지 반복
                strs[1] = temp;
                temp = "";
                int count = 1;
                while(true) {
                    if(i >= str.length()) {
                        strs[2] = temp;
                        remain = i;
                        temp = "";
                        break out;
                    }
                    if(!numberStr.contains(str.substring(i, i + 1)) || count > 5) {
                        strs[2] = temp;
                        remain = i;
                        temp = "";
                        break out;
                    }
                    temp += str.substring(i, i + 1);
                    count++;
                    i++;
                }
            }
        }
        for(int i = remain; i < str.length(); i++) {
            temp += str.substring(i, i + 1);
        }
        strs[3] = temp;
        return strs;
    }
}