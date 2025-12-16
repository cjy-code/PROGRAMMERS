package src.com.pccp.exam.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        // 1. offer (enqueue)
        queue.offer("A 고객");
        queue.offer("B 고객");
        queue.offer("C 고객");

        System.out.println("----- 처리 시작 -----");

        // 2. poll (dequeue)
        while (!queue.isEmpty()) {
            String customer = queue.poll();
            System.out.println("처리 중: " + customer);
        }
    }
}
