import java.util.*;

public class P36_DepthFirstSearch {
    public String[] solution(String[][] graph, String start, int n){
        // 트리 초기화
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n+1; i++){
            tree.add(new ArrayList<>());
        }
        for (String[] g : graph){
            tree.get(Integer.parseInt(g[0])).add(Integer.parseInt(g[1]));
        }

        int[] visited = new int[n+1];
        ArrayList<Integer> result = new ArrayList<>();
        dfs(tree, visited, Integer.parseInt(start), result);

        String[] answer = result.stream()
                              .map(String::valueOf) // Integer를 String으로 변환
                              .toArray(String[]::new);

        return answer;
    }

    public void dfs(ArrayList<ArrayList<Integer>> tree, int[] visited, int current, ArrayList<Integer> result){
        visited[current] = 1;
        result.add(current);

        for (int adj : tree.get(current)){
            if (visited[adj] == 0){ // 방문하지 않은 인접노드에 대해
                dfs(tree, visited, adj, result);
            }
        }
    }

    public static void main(String[] args) {
        P30_UnionFind p = new P30_UnionFind();
        System.out.println(Arrays.toString(p.solution(new String[][]{{"1","2"},{"2","3"},{"3","4"},{"4","5"}}, "1", 5))); // ["1","2","3","4","5"]
        System.out.println(Arrays.toString(p.solution(new String[][]{{"1","2"},{"1","3"},{"2","4"},{"2","5"},{"3","6"},{"5","6"}}, "1", 6))); // ["1","2","4","5","6","3"]
    }
}