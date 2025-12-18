package src.com.programmers.main.greedy;

import java.util.ArrayList;

/**
 * title: 택배 상자 꺼내기
 * url: https://school.programmers.co.kr/learn/courses/30/lessons/389478
 * 최진영
 */
public class Lesson389478 {
    public static void main(String[] args) {
        int n = 22;     // 상자 수
        int w = 6;      // 가로 수
        int num = 8;    // 상자 번호

        Lesson389478 lesson = new Lesson389478();
        System.out.println(lesson.solution(n, w, num));

    }

    public int solution(int n, int w, int num) {
        int topFlow = (int) Math.ceil((double) n / w);
        int curFlow = (int) Math.ceil((double) num / w);
        boolean isCheck;
        int seq;

        if(curFlow % 2 == 0) { // 짝수
            isCheck = false;
            seq = (w * curFlow) - num + 1;
        }else {                // 홀수
            isCheck = true;
            seq = num - (w * (curFlow-1)) ;
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(num);
        curFlow ++;

        for(int i = curFlow; i <= topFlow; i++) {
           int boxNum = 0;

           if(isCheck) { // 짝수
               boxNum = (i * w) + 1 - seq;
               isCheck = false;
           }else {       // 홀수
               boxNum = ((i - 1) * w) + seq;
               isCheck = true;
           }

           if(boxNum <= n) result.add(boxNum);
        }

        int answer = result.size();
        System.out.println(result.toString());
        return answer;
    }

    public int solution2(int n, int w, int num) {

        // 높이 측정
        int top = (int) Math.ceil((double) n / w);

        // 결과적으로 오직 꺼내야하는 상자의 수니까
        ArrayList<Integer> result = new ArrayList<>();
        result.add(num);

        // 현재 상자의 층
        int cur = (int) Math.ceil((double) num / w);
        int seq = num % w;

        for (int i = cur; i < top; i++) { // 15 % 3 = 2
            int checkBox;
            if(i%2 == 0) { // 짝수층
                checkBox = seq + (w * (i -1));
            }else {        // 홀수층
                checkBox = seq + (w * (i -1));
            }

        }


        int answer = 0;
        return answer;
    }
}
