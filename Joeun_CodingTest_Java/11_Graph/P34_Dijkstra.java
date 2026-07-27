import java.util.*;

class Node {
    int value;
    int weight;

    public Node(int value, int weight){
        this.value = value;
        this.weight = weight;
    }
}
public class P34_Dijkstra {
    public int[] solution(int[][] graph, int start, int n){
        // 그래프 초기화
        ArrayList<Node>[] graph_list = new ArrayList[n];
        for (int i = 0; i < n; i++){
            graph_list[i] = new ArrayList<>();
        }
        for (int[] edge : graph){
            graph_list[edge[0]].add(new Node(edge[1], edge[2]));
        }

        // 거리, 직전 노드 초기화
        int[] dist = new int[n];
        int[] past = new int[n];
        for (int i = 0; i < n; i++){
            dist[i] = Integer.MAX_VALUE;
            past[i] = Integer.MAX_VALUE;
        }
        boolean[] visited = new boolean[n];

        dist[start] = 0;
        past[start] = start;

        // 다익스트라
        while (true) { // 이거 어떻게 멈춤 조건 설정??
            // 방문하지 않은 노드 중 최솟 값 찾기
            boolean flag = true;
            int now = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++){
                if (!visited[i]){
                    if (dist[i] < min){
                        now = i;
                        min = dist[i];
                        flag = false;
                    }
                }
            }

            if (flag){
                break;
            }

            visited[now] = true;

            for (Node adj : graph_list[now]){
                if (dist[now] + adj.weight < dist[adj.value]){
                    dist[adj.value] = dist[now] + adj.weight;
                    past[adj.value] = now;
                }
            }

        }

        return dist;
    }

    public static void main(String[] args) {
        P34_Dijkstra p = new P34_Dijkstra();
        System.out.println(Arrays.toString(p.solution(new int[][]{{0,1,9},{0,2,3},{1,0,5},{2,1,1}}, 0, 3))); // [0,4,3]
        System.out.println(Arrays.toString(p.solution(new int[][]{{0,1,1,},{1,2,5},{2,3,1}}, 0, 4))); // [0,1,6,7]
    }
}