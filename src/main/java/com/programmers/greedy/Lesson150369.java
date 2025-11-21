package main.java.com.programmers.greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * TITLE 2023 KAKAO BLIND RECRUITMENT_택배 배달과 수거하기
 * URL https://school.programmers.co.kr/learn/courses/30/lessons/150369
 * SINCE 2023-01-12
 * SCORE 75
 * 최진영
 */
public class Lesson150369 {

    /* 1 */
//    static int cap = 4;
//    static int n   = 5;
//    static int[] deliceries = {1, 0, 3, 1, 2};
//    static int[] pickups    = {0, 3, 0, 4, 0};
    static Lesson150369 lesson;

    /* 2 */
    static int cap = 2;
    static int n   = 7;
    static int[] deliceries = {1, 0, 2, 0, 1, 0, 2};
    static int[] pickups    = {0, 2, 0, 1, 0, 2, 0};

    public static void main(String[] args) {
        lesson = new Lesson150369();
        System.out.println(lesson.solution(cap, n, deliceries, pickups));
    }

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        Map<Integer, Integer> delMap  = new HashMap<>();
        Map<Integer, Integer> pickMap = new HashMap<>();
        delMap  = setMapping(deliveries);
        pickMap = setMapping(pickups);

        // 거리
        int distanceTotal = 0;
        int distanceLast  = 0;
        boolean isCheck = true;

        //쿠팡맨 출발!!
        while(isCheck){
            int temp = cap;
            distanceLast  = 0;

            //배달 반복문
            for(int l = n; l > 0; l--){
                if(delMap.get(l) != 0){
                    // 가장 먼 거리 저장
                    if(distanceLast < l){
                        distanceLast = l;
                    }
                    // 연산
                    if(temp > delMap.get(l)){
                        temp -= delMap.get(l);
                        delMap.put(l, 0);
                    }else{
                        temp = delMap.get(l) - temp;
                        delMap.put(l, temp);
                        break;
                    }
                }
            }//배달 반복문
            temp = cap;

            //픽업 반복문
            for(int l = n; l > 0; l--){
                if(pickMap.get(l) != 0){
                    // 가장 먼 거리 저장
                    if(distanceLast < l){
                        distanceLast = l;
                    }
                    // 연산
                    if(temp > pickMap.get(l)){
                        temp -= pickMap.get(l);
                        pickMap.put(l, 0);
                    }else {
                        temp = pickMap.get(l) - temp;
                        pickMap.put(l, temp);
                        break;
                    }
                }
            }//픽업 반복문

            distanceTotal += distanceLast*2;

            // 테스트 Flag
            int testEnd = 0;
            testEnd  = delMap.values().stream().mapToInt(Integer::intValue).sum();
            testEnd += pickMap.values().stream().mapToInt(Integer::intValue).sum();

            if(testEnd == 0 ) isCheck =false;
        }

        return distanceTotal;
    }

    public Map<Integer, Integer> setMapping(int[] list){
        Map<Integer, Integer> tempMap = new HashMap<>();
        int i = 0;
        for(int l : list){
            i++;
            tempMap.put(i, l);
        }
        return tempMap;
    }



}
