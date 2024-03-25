class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        // 같으면 count++ 하고 answer에 yes 넣기
        int cards1Length = cards1.length;
        int cards2Length = cards2.length;
        int Count1 = 0;
        int Count2 = 0;
        for(int i = 0; i < goal.length; i++){
            if( Count1 < cards1Length && goal[i].equals(cards1[Count1])){
                Count1++;
            }else if(Count2 < cards2Length && goal[i].equals(cards2[Count2])){
                Count2++;
            }else{
                answer = "No";
                return answer;
            }
        }
        return answer;
    }
}