package BinaryTree;

import java.util.*;

public class P92343 {
    List<Integer>[] children_list;
    int[] info;
    int max_sheep = 0;
    
    public int solution(int[] info, int[][] edges) {
        this.info = info;
        int n = info.length;
        
        // 트리 구성: edges는 [부모, 자식] 쌍이라 자식 리스트로 변환
        children_list = new List[n];
        for (int i = 0; i < n; i++) children_list[i] = new ArrayList<>();
        for (int[] e : edges) children_list[e[0]].add(e[1]);
        
        boolean[] visited = new boolean[n];
        visited[0] = true; // 루트는 항상 양
        
        dfs(visited, 1, 0);
        
        return max_sheep;
    }
    
    private void dfs(boolean[] visited, int sheep_count, int wolf_count) {
        // 매 방문 시점마다 지금까지 모은 양 수로 답 갱신
        // (끝까지 안 가고 중간에 멈춰도 그 시점 양 수가 유효한 답이 될 수 있어서 leaf에서만 갱신하면 안 됨)
        max_sheep = Math.max(max_sheep, sheep_count);
        
        // frontier: 지금까지 방문한 노드들의 자식 중 아직 안 간 노드 = 다음에 갈 수 있는 후보들
        List<Integer> next_candidates = get_frontier(visited);
        
        for (int next : next_candidates) {
            int next_sheep = sheep_count + (info[next] == 0 ? 1 : 0);
            int next_wolf = wolf_count + (info[next] == 1 ? 1 : 0);
            
            // 늑대 수가 양 수 이상이 되면 양이 잡아먹혀서 그 경로는 더 진행 불가
            if (next_wolf < next_sheep) {
                visited[next] = true;
                dfs(visited, next_sheep, next_wolf);
                visited[next] = false; // 백트래킹: 다른 후보 시도 위해 원상복구
            }
        }
    }
    
    // 방문한 노드들의 자식 중 미방문 노드만 모아서 반환
    private List<Integer> get_frontier(boolean[] visited) {
        List<Integer> frontier = new ArrayList<>();
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i])
                continue;
            for (int child : children_list[i]) {
                if (!visited[child])
                    frontier.add(child);
            }
        }
        return frontier;
    }
}
