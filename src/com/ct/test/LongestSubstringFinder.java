package src.com.ct.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringFinder {
    public static String longestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLen = 0;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // 이미 나온 문자면 left를 바로 점프
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }

            map.put(c, right);

            if (right - left + 1 > maxLen) {
                maxLen = right - left + 1;
                start = left;
            }
        }

        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        System.out.println(longestSubstring("abcabc")); // abc
        System.out.println(longestSubstring("bbbbb"));  // b
        System.out.println(longestSubstring("pwwkew")); // wke
    }
}

