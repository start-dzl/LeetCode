package com.code.arraysn;

public class n5 {

    public static void main(String[] args) {
        String str = "fsdf";
        System.out.printf(str.substring(0, 4));
    }


    public String longestPalindrome(String s) {
        int length = s.length();
        String max = "";
        for (int i = 0; i < length; i++) {
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i+1);
            if(s1.length() >= s2.length()&& s1.length() > max.length()) {
                max = s1;
            }else if(s1.length() < s2.length()&& s2.length() > max.length()) {
                max = s2;
            }
        }
        return max;
    }

    String  palindrome(String s, int l, int r){
        int length = s.length();

        while (l>=0 &&
                r< length &&
                s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l+1,r);
    }
}
