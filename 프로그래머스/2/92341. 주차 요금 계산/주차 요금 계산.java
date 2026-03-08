import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        Map<String, String> map = new HashMap<>();
        Map<String, Integer> cars = new HashMap<>();
        List<String> carNumbers = new ArrayList<>();
        for(int i = 0; i < records.length; i++) {
            String[] str = records[i].split(" ");
            if(!carNumbers.contains(str[1])) {
                carNumbers.add(str[1]);
            }
            if(records[i].contains("IN")) {
                map.put(str[1], str[0]);
            } else {
                // map에서 찾아서 계산
                String temp = map.get(str[1]);
                String[] time1 = temp.split(":");
                String[] time2 = str[0].split(":");
                int hour1 = Integer.parseInt(time1[0]);
                int minute1 = Integer.parseInt(time1[1]);
                int hour2 = Integer.parseInt(time2[0]);
                int minute2 = Integer.parseInt(time2[1]);
                int total = calculateTime(hour1, minute1, hour2, minute2);
                cars.compute(str[1], (k, v) -> (v == null) ? total : v + total);
                map.remove(str[1]);
            }
        };
        //System.out.println(cars);
        // map에서 남은 IN 23:59와 계산
        map.forEach((k, v) -> {
            String[] time1 = v.split(":");
            int hour1 = Integer.parseInt(time1[0]);
            int minute1 = Integer.parseInt(time1[1]);
            int hour2 = 23;
            int minute2 = 59;
            int total = calculateTime(hour1, minute1, hour2, minute2);
            cars.compute(k, (key, value) -> (value == null) ? total : value + total);
        });
        Collections.sort(carNumbers);
        int count = 0;
        answer = new int[carNumbers.size()];
        for(int i = 0; i < carNumbers.size(); i++) {
            int totalMinute = cars.get(carNumbers.get(i));
            // System.out.println(carNumbers.get(i) + " " + totalMinute);
            if(totalMinute <= fees[0]) {
                answer[count++] = fees[1];
            } else {
                System.out.println();
                int totalFee = fees[1] + (int)(Math.ceil(((double)totalMinute - fees[0]) / fees[2]) * fees[3]);
                answer[count++] = totalFee;
            }
        }
        return answer;
    }
    
    public static int calculateTime(int hour1, int minute1, int hour2, int minute2) {
        int total = 0;
        if(minute1 > minute2) {
            total += 60 + minute2 - minute1;
            total += ((hour2 - 1) - hour1) * 60;
        } else {
            total += (hour2 - hour1) * 60;
            total += minute2 - minute1;
        }
        return total;
    }
}