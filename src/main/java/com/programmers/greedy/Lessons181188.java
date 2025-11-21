package main.java.com.programmers.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * TITLE: 요격 시스템
 * URL: https://school.programmers.co.kr/learn/courses/30/lessons/181188?language=java
 * SINCE: 2023-05-03
 * 최진영
 *
 */
public class Lessons181188 {

    static int[][] exampleList = {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};
    static ArrayList<int[][]> example001 = new ArrayList<>();
    static Lessons181188 lesson;
    public static void main(String[] args) {
        // 생성자
        lesson = new Lessons181188();
        example001.add(exampleList);

        // Solution
        lesson.solution(exampleList);
    }

    public int solution(int[][] targets) {
        /*
          1. 최소, 최대 위치 찾기 : minSpot, maxSpot
          2. inSpot ~ maxSpot에 포함되는 개구간 카운팅 : mapSpot
          3. mapSpot 최대 카운팅 위치에 포함되는 개구간 delete
          4. ++answer
          5. List.size != 0 ? GO 2 : End
        */
        HashMap<Integer, int[]> targetMap = new HashMap<Integer, int[]>();
        HashMap<Integer, Integer> spotMap = new HashMap<Integer, Integer>();
        int answer = 0;
        int minSpot = 0, maxSpot = 0;

        // List => Map
        for (int i = 0; i < targets.length; i++) {
            targetMap.put(i, targets[i]);
        }

        // 1. 최소, 최대 위치 찾기 : minSpot, maxSpot
        for (int i = 0; i < targets.length; i++) {
            if(i==0) {
                minSpot = targets[i][0];
                maxSpot = targets[i][1];
            }
            if(targets[i][0] < minSpot) minSpot = targets[i][0];
            if(targets[i][1] > maxSpot) maxSpot = targets[i][1];
        }

        Boolean isCheck = true;
        while(isCheck){
//            System.out.println("mapToString >> " + targetMap.toString());
            // 2. inSpot ~ maxSpot에 포함되는 개구간 카운팅 : mapSpot
            int spot = 0, spotCnt = 0, spotCntTemp = 0;
            StringBuffer spotsTempBf;
            StringBuffer spotsBf = new StringBuffer();
            System.out.println("[Start]");
            for (int i = minSpot; i <= maxSpot; i++) {
                System.out.println(i);
                spotsTempBf  = new StringBuffer();
                spotCntTemp = 0;
                for(Map.Entry<Integer, int[]> elem : targetMap.entrySet()){
                    int[] target = elem.getValue();
                    if(target == null) continue;
                    if((i+0.5) > target[0] && i <= (target[1]-0.5)) {
                        ++spotCntTemp;
                        spotsTempBf.append(elem.getKey());
                    }
                }
                if(spotCntTemp > spotCnt) {
                    spotsBf = new StringBuffer();
                    spotCnt = spotCntTemp;
                    spotsBf.append(spotsTempBf);
                }
            }
            System.out.println("[Finish]");
            // 3. 최대 카운팅 Spot에 포함되는 개구간 delete
            String[] spotSplt = spotsBf.toString().split("");
            for (int i = 0; i < spotSplt.length; i++) {
                targetMap.remove(Integer.parseInt(spotSplt[i]));
            }

            // 4. ++ answer
            ++answer;
            if(targetMap.size() == 0) isCheck = false;
        }
        return answer;
    }

}
