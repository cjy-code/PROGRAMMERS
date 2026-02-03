package src.com.pccp.exam.dp;

/**
 * 문제 설명
 * - 정수 배열이 주어질 때, 연속된 부분 배열의 합 중 가장 큰 값을 구하세요.
 */
public class MaxSubArray {

    private int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};   // 6
//    private int[] nums = {-1, -2, -3}; // -1


    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
