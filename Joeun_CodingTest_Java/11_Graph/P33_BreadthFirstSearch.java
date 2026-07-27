import java.util.*;

public class P33_BreadthFirstSearch {
    public int[] solution(int[][] graph, int start, int n){
        // 그래프 초기화
        ArrayList<Integer>[] graph_list = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++){
            graph_list[i] = new ArrayList<>();
        }
        for (int[] edge : graph){
            graph_list[edge[0]].add(edge[1]);
        }

        boolean[] visited = new boolean[n+1];
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addLast(start);
        
        while (true){
            if (queue.isEmpty()){
                break;
            }

            int now = queue.pollFirst();
            answer.add(now);
            for (int adj : graph_list[now]){
                if (!visited[adj]){
                    queue.addLast(adj);
                    visited[adj] = true;
                }
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        P33_BreadthFirstSearch p = new P33_BreadthFirstSearch();
        System.out.println(Arrays.toString(p.solution(new int[][]{{1,2},{1,3},{2,4},{2,5},{3,6},{3,7},{4,8},{5,8},{6,9},{7,9}}, 1, 9))); // [1,2,3,4,5,6,7,8,9]
        System.out.println(Arrays.toString(p.solution(new int[][]{{1,3},{3,4},{3,5},{5,2}}, 1, 5))); // [1,3,4,5,2]
    }
}