import java.util.*;

public class P42_86971_SplittingNetwork_UF {
    private static int[] parent;
    public int solution(int n, int[][] wires) {
        // parent 생성
        parent = new int[n+1];
        
        // 완전 탐색
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < wires.length; i++){
            // 집합 초기화 후 union
            initParent();
            for (int j = 0; j < wires.length; j++){
                if (j == i)
                    continue;
                union(wires[j][0], wires[j][1]);
            }
            // find 후 개수 세기
            for (int j = 0; j < n+1; j++)
                find(j);
            
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = 1; j < n+1; j++)
                map.merge(parent[j], 1, Integer::sum);
            ArrayList<Integer> cnt = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet())
                cnt.add(entry.getValue());
            answer = Math.min(answer, Math.abs(cnt.get(0)-cnt.get(1)));
        }
        
        return answer;
    }
    
    private void initParent(){
        for (int i = 0; i < parent.length; i++){
            parent[i] = i;
        }
    }
    
    private int find(int x){
        if (parent[x] == x)
            return x;
        
        return parent[x] = find(parent[x]);
    }
    
    private void union(int x, int y){
        int rx = find(x);
        int ry = find(y);
        
        parent[rx] = ry;
    }
    public static void main(String[] args) {
        P42_86971_SplittingNetwork_UF p = new P42_86971_SplittingNetwork_UF();
        System.out.println(p.solution(9, 
            new int[][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}})); // 3
    }
}