import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String zaAlpa = "qwrtypsdfghjklzxcvbnm";
        String moAlpa = "aeiou";
        OUT:
        while(true) {
            String str = br.readLine();
            if(str.equals("end")) break;
            if(check(str)) {
                sb.append("<").append(str).append(">").append(" ").append("is not acceptable.").append("\n");
                continue;
            }
            
            int za = 0;
            int mo = 0;
            
            String prev = "";
            for(int i = 0; i < str.length(); i++) {
                String s = str.charAt(i) + "";
                if(zaAlpa.contains(s)) {
                    za++;
                    mo = 0;
                } else if(moAlpa.contains(s)) {
                    mo++;
                    za = 0;
                }
                if(za >= 3 || mo >= 3) {
                    sb.append("<").append(str).append(">").append(" ").append("is not acceptable.").append("\n");
                    continue OUT;
                }
                
                if(s.equals(prev)) {
                    if(!("ee".contains(s) || "oo".contains(s))) {
                        sb.append("<").append(str).append(">").append(" ").append("is not acceptable.").append("\n");
                        continue OUT;
                    }
                }
                prev = s;   
            }
            sb.append("<").append(str).append(">").append(" ").append("is acceptable.").append("\n");
        }
        System.out.println(sb);
    }
    public static boolean check(String str) {
        if(str.contains("a") || str.contains("e") || str.contains("i") || str.contains("o") || str.contains("u")) {
            return false;
        } else {
            return true;
        }
    }
}