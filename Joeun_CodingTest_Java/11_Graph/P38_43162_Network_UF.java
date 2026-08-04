import java.util.*;

public class P38_43162_Network_UF {
    private static int[] parent;
    
    public int solution(int n, int[][] computers) {
        parent = new int[n];
        for (int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (i == j)
                    continue;
                
                if (computers[i][j] == 0)
                    continue;
                
                if (find(i) == find(j))
                    continue;
                
                union(i,j);
            }
        }
        
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++){
            set.add(find(i));
        }
        
        
        return set.size();
    }
    
    private static void union(int x, int y){
        int r1 = find(x);
        int r2 = find(y);
        
        parent[r1] = r2;
    }
    
    private static int find(int x){
        if (parent[x] == x)
            return x;
        
        return parent[x] = find(parent[x]);
    }

    public static void main(String[] args) {
        P38_43162_Network_UF p = new P38_43162_Network_UF();
        System.out.println(p.solution(3, new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}})); // 2
        System.out.println(p.solution(3, new int[][] {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}})); // 1
    }
}