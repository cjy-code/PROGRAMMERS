package src.com.ct.test;

import java.util.HashMap;
import java.util.Map;

public class CharacterFrequencyAnalyzer {
    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();

        String str = "알라딘 만만세";

        for(char c : str.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        char answer = '만';
        int max = 0;

        for(char key : map.keySet()){
            if(map.get(key) > max){
                max = map.get(key);
                answer = key;
            }
        }
        System.out.println(">>> " + max);
    }
}

