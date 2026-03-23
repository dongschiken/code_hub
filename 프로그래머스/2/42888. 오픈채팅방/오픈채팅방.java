import java.util.*;

class Solution {
    
    static class Message {
        String uid, message;
        
        public Message(String uid, String message) {
            this.uid = uid;
            this.message = message;
        }
    }
    
    public String[] solution(String[] record) {
        String[] answer = {};
        Map<String, String> map = new HashMap<>();
        List<Message> list = new ArrayList<>();
        for(int i = 0; i < record.length; i++) {
            String str = record[i];
            String[] strs = record[i].split(" ");
            // System.out.println(Arrays.toString(strs));
            if(str.startsWith("Enter")) {
                map.put(strs[1], strs[2]);
                list.add(new Message(strs[1], "님이 들어왔습니다."));
            } else if(str.startsWith("Leave")) {
                list.add(new Message(strs[1], "님이 나갔습니다."));
            } else {
                map.put(strs[1], strs[2]);
            }
        }
        //System.out.println(map);
        //System.out.println(sb.toString());
        answer = new String[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = map.get(list.get(i).uid) + list.get(i).message;
        }
        return answer;
    }
}