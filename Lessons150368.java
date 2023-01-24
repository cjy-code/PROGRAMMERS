package com.programmers.coding.test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * TITLE 2023 KAKAO BLIND RECRUITMENT 이모티콘 할인행사
 * URL https://school.programmers.co.kr/learn/courses/30/lessons/150368
 * SINCE 2023-01-16
 * SCORE
 * 최진영
 */
public class Lessons150368 {

    // Question 1
    static int[][] users = {{40,10000}, {25,10000}};
    static int[] emoticons = {7000, 9000};  //4900 5400 , 4200 6300
    // Question 2
//    static int[][] users = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}}
//    static int[] emoticons = {1300, 1500, 1600, 4900};



    public static void main(String[] args) {
        Lessons150368 lessons = new Lessons150368();
        lessons.solution(users, emoticons);
    }

    public int[] solution(int[][] users, int[] emoticons) {
        System.out.println(users.length);
        // 유저 환산
        for(int[] l : users){


        }
        // 이모티콘 환산
        ArrayList<Integer> list = new ArrayList<>();
            
        // 할인율 계산
        for(int i=1; i<5; i++){
            System.out.println(calcEmoticons(i*10, emoticons));
        }
        int[] answer = {};
        return answer;
    }

    public int calcEmoticons(int sale, int[] price){
        int result = 0;
        int totalPrice = Arrays.stream(price).sum();
        totalPrice = totalPrice - ((totalPrice / 100) * sale);
        return totalPrice;
    }
}
