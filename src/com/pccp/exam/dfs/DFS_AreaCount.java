package src.com.pccp.exam.dfs;

public class DFS_AreaCount {
    int n, m;
    int[][] map;
    boolean[][] visited;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int solution(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        map = grid;
        visited = new boolean[n][m];

        int areaCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j);
                    areaCount++;
                }
            }
        }
        return areaCount;
    }

    void dfs(int x, int y) {
        visited[x][y] = true;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if (visited[nx][ny]) continue;
            if (map[nx][ny] == 0) continue;

            dfs(nx, ny);
        }
    }
}
