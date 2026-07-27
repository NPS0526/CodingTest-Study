package BinaryTree;

import java.util.*;

public class P68937 {
    private List<Integer>[] graph;
    
    public int solution(int n, int[][] edges) {
        graph = new ArrayList[n + 1];
        
        for (int node = 1; node <= n; node++) {
            graph[node] = new ArrayList<>();
        }
        
        for (int[] edge : edges) {
            int first_node = edge[0];
            int second_node = edge[1];
            
            graph[first_node].add(second_node);
            graph[second_node].add(first_node);
        }
        
        // 아무 정점에서 가장 먼 정점을 찾기
        int[] first_distance = bfs(1, n);
        int diameter_start = find_farthest_node(first_distance);
        
        // 지름의 한쪽 끝점에서 다시 BFS
        int[] start_distance = bfs(diameter_start, n);
        
        // 가장 먼 정점이 지름의 반대쪽 끝점
        int diameter_end = find_farthest_node(start_distance);
        
        // 두 끝점 사이의 거리가 트리의 지름
        int diameter = start_distance[diameter_end];
        
        // 지름 시작점에서 가장 먼 정점이 여러 개 -> 지름 길이가 중간값
        if (count_max_distance(start_distance, diameter) >= 2) {
            return diameter;
        }
        
        // 반대쪽 끝점에서도 같은 조건인지 확인
        int[] end_distance = bfs(diameter_end, n);
        
        if (count_max_distance(end_distance, diameter) >= 2) {
            return diameter;
        }
        
        // 지름을 이루는 끝점 쌍이 하나뿐인 경우
        return diameter - 1;
    }
    
    private int[] bfs(int start_node, int n) {
        int[] distance = new int[n + 1];
        
        Arrays.fill(distance, -1);
        
        Queue<Integer> queue = new ArrayDeque<>();
        
        queue.offer(start_node);
        distance[start_node] = 0;
        
        while (!queue.isEmpty()) {
            int current_node = queue.poll();
            
            for (int next_node : graph[current_node]) {
                
                if (distance[next_node] != -1) {
                    continue;
                }
                
                distance[next_node] = distance[current_node] + 1;
                queue.offer(next_node);
            }
        }
        
        return distance;
    }
    
    private int find_farthest_node(int[] distance) {
        int farthest_node = 1;
        
        // 거리값이 가장 큰 정점을 찾기
        for (int node = 2; node < distance.length; node++) {
            if (distance[node] > distance[farthest_node]) {
                farthest_node = node;
            }
        }
        
        return farthest_node;
    }
    
    private int count_max_distance(
        int[] distance,
        int max_distance
    ) {
        int count = 0;
        
        // 최대 거리와 같은 정점의 개수를 세기
        for (int node = 1; node < distance.length; node++) {
            if (distance[node] == max_distance) {
                count++;
            }
        }
        
        return count;
    }
}
