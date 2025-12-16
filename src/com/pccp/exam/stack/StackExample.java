package src.com.pccp.exam.stack;

import java.util.Stack;
public class StackExample {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        int[] nums = {1, 2, 3, 4, 5};

        // 1. push
        for (int num : nums) {
            stack.push(num);
            System.out.println("push: " + num);
        }

        System.out.println("----- pop 시작 -----");

        // 2. pop (LIFO)
        while (!stack.isEmpty()) {
            int value = stack.pop();
            System.out.println("pop: " + value);
        }
    }
}