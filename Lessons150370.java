package com.programmers.coding.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * TITLE 2023 KAKAO BLIND RECRUITMENT 개인정보 수집 유효기간
 * URL https://school.programmers.co.kr/learn/courses/30/lessons/150370
 * SINCE 2023-01-16
 * SCORE 30
 * 최진영
 */
public class Lessons150370 {

    static Lessons150370 lessons = null;

    // Question 1
//    static String today = "2022.05.19";
//    static String[] terms = {"A 6", "B 12", "C 3"};
//    static String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

    // Question 2
    static String today = "2020.01.01";
    static String[] terms = {"Z 3", "D 5"};
    static String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};

    public static void main(String[] args) {
        lessons = new Lessons150370();
        lessons.solution(today, terms, privacies);
    }
    public int[] solution(String today, String[] terms, String[] privacies) {
        // 1.today데이터 형 변환
        Date date1 = new Date();
        date1 = castDate(today);

        // 2.맵핑하기
        Map<String, String> termsMap = null;
        termsMap = setMapping(terms);

        // 3.날짜 계산하기
        List<Date> addPrivacy = new ArrayList<>();
        addPrivacy = calcDate(privacies, termsMap);

        // 4.날짜 비교하기
        List<Integer> arrayList = new ArrayList<>();
        arrayList = compareDate(date1, addPrivacy);

        int[] answer = arrayList.stream().mapToInt(x -> x).toArray();

        return answer;
    }
    private Map<String, String> setMapping(String[] list){
        Map<String, String> returnMap = new HashMap<>();
        int i = 0 ;
        for(String l : list){
            String[] splitList = list[i].split(" ");
            returnMap.put(splitList[0], splitList[1]);
            i++;
        }
        return returnMap;
    }
    private List<Date> calcDate(String[] list, Map termsMap){
        List<Date> returnList = new ArrayList<>();
        Date privacyDate = new Date();
        int i = 0;
        for(String l : list){
            String[] privacyList = list[i].split(" ");
            int terms = Integer.parseInt((String) termsMap.get(privacyList[1]));
            if(privacyList[0] != null){
                privacyDate = castDate(calcDate2(privacyList[0], terms));
            }
            returnList.add(privacyDate);
            i++;
        }
        return returnList;
    }
    private List<Integer> compareDate(Date today, List<Date> privacy){
        List<Integer> returnList = new ArrayList<>();
        int result = 0;
        int i = 0;
        for(Date date : privacy){
            result = privacy.get(i).compareTo(today);
//            System.out.println("Date >> " + privacy.get(i) + " | result >> " + result);
            if(result < 0){
                returnList.add(i+1);
            }
            i++;
        }
//        System.out.println("결과 >>> " + returnList);
        return returnList;
    }
    private Date castDate(String date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        Date returnDate = new Date();
        try {
            returnDate = dateFormat.parse(date);
        } catch (ParseException e) {
            System.out.println("Date paresing error"+ e);
        }
        return returnDate;
    }

    private String calcDate2(String date, int terms){
        String[] dateSplit = date.trim().split("\\.");
        String result = null;
        int year = 0; int month = 0; int day = 0;
        year = Integer.parseInt(dateSplit[0]);
        month = Integer.parseInt(dateSplit[1]);
        day = Integer.parseInt(dateSplit[2]);
        month = month + terms;
        if(month > 12){
           month = month % 12;
           year = year + 1;
        }
        day = day - 1;
        if(day <= 0){
            day = 28;
            month = month -1;
            if(month <= 0){
                month = 12;
                year = year -1;
            }
        }
        result = String.valueOf(year)+"."+String.valueOf(month)+"."+String.valueOf(day);
        return result;
    }
}
