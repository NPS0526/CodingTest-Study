import java.util.*;

public class P30_UnionFind {
    private static int[] set;
    public boolean[] solution(int k, int[][] operations){
        set = new int[k+1];
        for (int i = 1; i < k+1; i++){
            set[i] = i;
        }
        ArrayList<Boolean> answer_list = new ArrayList<>();
        
        for (int[] op : operations){
            switch(op[0]){
                case 0 :
                    union(op[1], op[2]);
                    break;
                case 1 :
                    if (find(op[1]) == find(op[2])){
                        answer_list.add(true);
                    } else {
                        answer_list.add(false);
                    }
                    break;
            }
        }

        boolean[] answer = new boolean[answer_list.size()];
        for (int i = 0; i < answer_list.size(); i++){
            answer[i] = answer_list.get(i);
        }
        return answer;
    }

    public int find(int now){
        if (now == set[now]){
            return now;
        }

        return set[now] = find(set[now]);
    }

    public void union(int a, int b){
        a = find(a);
        b = find(b);

        set[a] = b;
    }

    public static void main(String[] args) {
        P30_UnionFind p = new P30_UnionFind();
        System.out.println(Arrays.toString(p.solution(3, new int[][] {{0,0,1},{0,1,2},{1,1,2}}))); // [true]
        System.out.println(Arrays.toString(p.solution(4, new int[][] {{0,0,1},{1,1,2},{0,1,2},{1,0,2}}))); // [false, true]
    }
}