class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        StringBuilder sb;
        for(int i = 0; i < n; i++) {
            String line1 = toBinary(arr1[i], n);
            String line2 = toBinary(arr2[i], n);
            sb = new StringBuilder();
            for(int j = 0; j < n; j++) {
                if(line1.charAt(j) == '0' && line2.charAt(j) == '0') {
                    sb.append(" ");
                } else {
                    sb.append("#");
                }
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
    public static String toBinary(int a, int n) {
        int tmp1 = 0;
        StringBuilder sb = new StringBuilder();
        while(a > 0) {
            tmp1 = a % 2;
            a = a / 2;
            sb.append(tmp1 + "");
        }
        // 길이가 부족한 만큼 앞에 추가
        // sb넣을 때 뒤에 추가하거나, sb reverse중에 reverse방식 선택
        sb.reverse();
        String str = sb.toString();
        int v = n - str.length();
        String tmpStr = "";
        for(int i = 0; i < v; i++) {
            tmpStr += "0";
        }
        //System.out.println(tmpStr + str);
        return tmpStr =  tmpStr + str; 
    }
}