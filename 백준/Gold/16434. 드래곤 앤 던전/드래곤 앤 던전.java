import java.io.*;
import java.util.*;

public class Main {
    
    public static class Room {
        long c, a, h;
        
        public Room(long c, long a, long h) {
            this.c = c;
            this.a = a;
            this.h = h;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long attack = Integer.parseInt(st.nextToken());
        long originAttack = attack;
        
        List<Room> rooms = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long c = Integer.parseInt(st.nextToken());
            long a = Integer.parseInt(st.nextToken());
            long h = Integer.parseInt(st.nextToken());
            rooms.add(new Room(c, a, h));
        }
        
        long l = 0;
        long r = Long.MAX_VALUE;
        long maxHp = Long.MAX_VALUE;
        while(l <= r) {
            long mid = (l + r) / 2;
            long currHp = mid;
            attack = originAttack;
            
            boolean check = true;
            for(int i = 0; i < N; i++) {
                Room room = rooms.get(i);
                if(room.c == 1) {
                    long ac = (long)(Math.ceil((double)room.h / attack)) - 1;
                    if(ac * room.a > currHp) {
                        check = false;
                        break;
                    }else{
                        currHp -= ac * room.a;
                    }
                } else {
                    attack += room.a;
                    currHp += room.h;
                    if(currHp >= mid) {
                        currHp = mid;
                    }
                }
            }
            
            if(!check) {
                l = mid + 1;
            }else {
                r = mid - 1;
                maxHp = Math.min(maxHp, mid);
            }
        }
        System.out.println(l + 1);
    }
}