package src.com.pccp.exam;

import src.com.pccp.exam.bfs.BFS_Template;

public class SolutionRunner {
    public static void main(String[] args) {

        BFS_Template bfs = new BFS_Template();

        int[][] grid = {
                {0, 1, 0, 0, 0},
                {1, 1, 1, 0, 1},
                {0, 1, 0, 1, 1},
                {1, 0, 0, 0, 0}
        };

        int result = bfs.solution(grid);
        System.out.println("연결된 1 영역 개수: " + result);
    }
}
