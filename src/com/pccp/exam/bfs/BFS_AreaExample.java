package src.com.pccp.exam.bfs;

import java.util.*;

public class BFS_AreaExample {

    int n, m;
    int[][] map;
    boolean[][] visited;

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int[] solution(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        map = grid;
        visited = new boolean[n][m];

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    int size = bfs(i, j);
                    list.add(size);
                }
            }
        }

        // 영역 크기 리스트를 배열로 반환
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        int area = 1; // 시작점 포함

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
                area++;
            }
        }

        return area;
    }

    // 테스트
    public static void main(String[] args) {
        int[][] grid = {
            {1, 0, 1, 1},
            {1, 0, 0, 1},
            {1, 1, 1, 0},
            {0, 0, 1, 0}
        };

        BFS_AreaExample sol = new BFS_AreaExample();
        int[] res = sol.solution(grid);

        System.out.println("영역 개수: " + res.length);
        System.out.println("각 영역 크기: " + Arrays.toString(res));
    }
}
