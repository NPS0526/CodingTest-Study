package BinaryTree;

import java.util.*;

public class P42892 {
    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        
        // y 내림차순 정렬 (y가 클수록 트리 위쪽 = 먼저 삽입되어야 루트에 가까운 위치 차지)
        Integer[] idx_by_y = new Integer[n];
        for (int i = 0; i < n; i++) idx_by_y[i] = i;
        Arrays.sort(idx_by_y, (a, b) -> nodeinfo[b][1] - nodeinfo[a][1]);
        
        int[] left = new int[n], right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);
        
        int root = idx_by_y[0];
        // 나머지 노드들을 BST 삽입 규칙(x값 비교)대로 하나씩 끼워넣기
        for (int k = 1; k < n; k++) {
            int cur = idx_by_y[k];
            int node = root;
            while (true) {
                if (nodeinfo[cur][0] < nodeinfo[node][0]) {
                    if (left[node] == -1) { left[node] = cur; break; }
                    node = left[node];
                } else {
                    if (right[node] == -1) { right[node] = cur; break; }
                    node = right[node];
                }
            }
        }
        
        List<Integer> pre = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        preorder(root, left, right, pre);
        postorder(root, left, right, post);
        
        int[][] answer = new int[2][n];
        for (int i = 0; i < n; i++) {
            answer[0][i] = pre.get(i) + 1;  // 0-based 인덱스 -> 1번부터 시작하는 노드 번호로 변환
            answer[1][i] = post.get(i) + 1;
        }
        return answer;
    }
    
    private void preorder(int node, int[] left, int[] right, List<Integer> result) {
        if (node == -1) return;
        result.add(node);
        preorder(left[node], left, right, result);
        preorder(right[node], left, right, result);
    }
    
    private void postorder(int node, int[] left, int[] right, List<Integer> result) {
        if (node == -1) return;
        postorder(left[node], left, right, result);
        postorder(right[node], left, right, result);
        result.add(node);
    }
    
}
