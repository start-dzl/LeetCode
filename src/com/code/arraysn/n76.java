package com.code.arraysn;

import java.util.HashMap;
import java.util.Map;

public class n76 {

    public static void main(String[] args) {

        String window = minWindow("ADOBECODEBANC", "ABC");
        System.out.printf(window);

    }

   static Map<Character, Integer> need;

  static   Map<Character, Integer> windows;

    public static String minWindow(String s, String t) {

        need = new HashMap<>();
        windows  = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0; int right = 0;
        String mins = "";
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            windows.put(sChar, windows.getOrDefault(sChar,0) + 1);
            right++;

            for (int j = left; j < right; j++) {
                char jChar = s.charAt(j);
                if(need.containsKey(jChar)) {
                    Integer countNeed = need.get(jChar);

                    Integer countWindows = windows.get(jChar);
                    if(countNeed < countWindows) {
                        windows.put(jChar, countWindows -1);
                        left ++;
                    }else {
                        break;
                    }

                }else {
                    left ++;
                    Integer count = windows.get(jChar);
                    if(count > 1) {
                        windows.put(jChar, count -1);
                    }else {
                        windows.remove(jChar);
                    }
                }

            }

            Boolean bl  = true;
            for (Map.Entry<Character, Integer> entry : need.entrySet()) {
                if(!windows.containsKey(entry.getKey())|| windows.get(entry.getKey()) < entry.getValue()) {
                    bl = false;
                    break;
                }

            }

            if (bl){
                String substring = s.substring(left, right);
                if(substring.length()< mins.length() || mins.length() ==0) {
                    mins = substring;
                }
            }

        }

        return mins;


    }


}
