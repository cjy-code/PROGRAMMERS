package main.java.com.programmers.greedy;
import java.util.HashMap;
import java.util.Map;

/**
 * title 성격 유형 검사하기
 * url https://school.programmers.co.kr/learn/courses/30/lessons/118666?language=java
 * 최진영
 */
public class Lessons118666 {

    private static Lessons118666 less;

    private static final String[] inputSurvey = {"AN", "CF", "MJ", "RT", "NA"};
    //    private static final String[] inputSurvey = {"TR", "RT", "TR"};
    private static final int[] inputChoice = {5, 3, 2, 7, 5};
    //    private static final int[] inputChoice = {7, 1, 3};
    static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {

        less = new Lessons118666();
        System.out.println("[RESULT] : " + less.solution(inputSurvey, inputChoice));
        System.out.println("[CHOICE] : " + resultMap);
    }

    public String solution(String[] survey, int[] choices) {

        SetdefaultMap();

        int i = 0;
        for(String s : survey){
            putChoice(s, choices[i]);
            i++;
        }

        String answer = getAnswer();
        return answer;
    }

    private String getAnswer() {
        StringBuffer answer = new StringBuffer();

        if(resultMap.get("R") >= resultMap.get("T")){
            answer.append("R");
        }else{
            answer.append("T");
        }

        if(resultMap.get("C") >= resultMap.get("F")){
            answer.append("C");
        }else{
            answer.append("F");
        }

        if(resultMap.get("J") >= resultMap.get("M")){
            answer.append("J");
        }else{
            answer.append("M");
        }

        if(resultMap.get("A") >= resultMap.get("N")){
            answer.append("A");
        }else{
            answer.append("N");
        }


        return answer.toString();
    }

    private void putChoice(String survey, int choice){
        String[] surveySplt = survey.split("");

        int score = 0;
        if(choice <4){
            score = resultMap.get(surveySplt[0]) + getChoiceScore(choice);
            resultMap.put(surveySplt[0], score);
        }else if(choice > 4){
            score = resultMap.get(surveySplt[1]) + getChoiceScore(choice);
            resultMap.put(surveySplt[1], score);
        }
    }

    private int getChoiceScore(int num){
        int score = 0;
        if(num==1 || num==7){
            score = 3;
        } else if (num==2 || num ==6) {
            score = 2;
        } else if (num==3 || num ==5) {
            score = 1;
        } else {
            score = 0;
        }

        return score;
    }

    private void SetdefaultMap(){
        resultMap.put("R", 0);
        resultMap.put("T", 0);
        resultMap.put("C", 0);
        resultMap.put("F", 0);
        resultMap.put("J", 0);
        resultMap.put("M", 0);
        resultMap.put("A", 0);
        resultMap.put("N", 0);
    }

}