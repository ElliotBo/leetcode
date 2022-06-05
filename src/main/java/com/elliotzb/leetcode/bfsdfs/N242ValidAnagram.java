package com.elliotzb.leetcode.bfsdfs;

public class N242ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] res = new int[26];
        for (int i = 0; i < s.length(); i++) {
            res[s.charAt(i)-'a']++;
            res[t.charAt(i)-'a']--;
        }
        for (int re : res) {
            if (re != 0)
                return false;
        }
        return true;
    }
}
