package src.com.pccp.exam.mst;

import java.util.Arrays;

public class KruskalExample {

    static int[] parent;

    // find: 루트 찾기 (경로 압축)
    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    // union: 두 집합을 합치기
    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[b] = a;
    }

    public static void main(String[] args) {
        int n = 4; // 정점 개수 (0,1,2,3)

        // 간선 리스트: {start, end, cost}
        int[][] edges = {
                {0,1,1},
                {0,2,2},
                {1,2,5},
                {1,3,1},
                {2,3,8}
        };

        // 1. 간선 비용 기준 정렬
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);

        // 2. parent 초기화 (0 ~ n-1)
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int totalCost = 0;
        int edgeCount = 0;

        // 3. 가장 작은 간선부터 선택
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            int cost = edge[2];

            // 사이클 여부 체크
            if (find(a) != find(b)) {
                union(a, b);         // 사이클이 아닐 때만 합치기
                totalCost += cost;   // 이때만 비용 합산
                edgeCount++;

                System.out.println("선택된 간선: " + a + " - " + b + " (비용: " + cost + ")");
            }

            // 간선 수 = 정점 - 1 이면 종료
            if (edgeCount == n - 1) break;
        }

        System.out.println("최소 비용: " + totalCost);
    }
}
