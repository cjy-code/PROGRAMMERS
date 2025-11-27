package src.com.programmers.test;

public class BfsTest {
    static int n;
    static int m;
    static int cnt;
    static int[][] map;
    static boolean[][] visited;

    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};

    public static void main(String[] args) {
        int[][] grid = {
            {0,1,1,1,0},
            {1,1,1,0,1},
            {0,0,0,1,1},
            {1,0,1,0,0}
        };

        solution(grid);

        System.out.printf("섬의 개수는 %d 입니다.%n", cnt);

    }

    private static void solution(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        map = grid;

        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                    ++cnt;
                }
            }
        }

    }

    private static void bfs(int i, int j) {
        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int gx = i + dx[k];
            int gy = j + dy[k];

            if(gx < 0 || gy < 0 || gx >= n || gy >= m) continue;// 영역 채크
            if(visited[gx][gy]) continue;// 방문 채크
            if(map[gx][gy]==0) continue;// 0번 채크

            bfs(gx, gy);
        }
    }



}
