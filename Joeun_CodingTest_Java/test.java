import java.util.*;

class Node {
    int idx;
    int val;
    Node left;
    Node right;
    Node parent;
    
    public Node(int idx, int val){
        this.idx = idx;
        this.val = val;
    }
}

public class test { // 베스트 앨범
    public int solution(int[] info, int[][] edges) {
        HashMap<Integer, Node> tree = new HashMap<>();
        
        // 노드 생성
        for (int i = 0; i < info.length; i++){
            tree.put(i,new Node(i, info[i]));
        }
        
        for (int[] edge : edges){
            Node parentNode = tree.get(edge[0]);
            Node childNode = tree.get(edge[1]);
            
            // 자식,부모 연결
            if (parentNode.left == null){
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }
            
            childNode.parent = parentNode;
        }
        
        // 양인 인덱스 저장
        HashMap<Integer, ArrayList<Integer>> sheep_map = new HashMap<>();
        for (int i = 1; i < info.length; i++){ // 루트 제외
            if (info[i] == 0){
                sheep_map.put(i, new ArrayList<>());
            }
        }
        
        // 양에게 가는 경로에 있는 늑대 인덱스 저장
        for (Map.Entry<Integer, ArrayList<Integer>> entry : sheep_map.entrySet()){
            Node current = tree.get(entry.getKey());
            while (true){
                if (current.parent == null){
                    break;
                }
                if (current.parent.val == 1){
                    entry.getValue().add(current.parent.idx);
                }
                current = current.parent;
            }
        }
        
        int[] sheep_arr = sheep_map.keySet().stream().mapToInt(i -> i).toArray();
        boolean[] visited = new boolean[sheep_arr.length];
        ArrayList<Integer> current = new ArrayList<>();
        ArrayList<ArrayList<Integer>> total = new ArrayList<>();
        //System.out.println(Arrays.toString(sheep_arr));
        permute(sheep_arr, visited, current, total);
        
        int answer = 0;
        for (ArrayList<Integer> list : total){
            HashSet<Integer> sheep = new HashSet<>();
            sheep.add(0);
            HashSet<Integer> wolf = new HashSet<>();
            System.out.println(list);
            for (int i : list){
                sheep.add(i);
                for (int w : sheep_map.get(i)){
                    wolf.add(w);
                }
                if (sheep.size()-1 <= wolf.size()){
                    answer = Math.max(answer, sheep.size()-1);
                    break;
                }
            }
        }
        
        return answer;
    }
    
    public void permute(int[] arr, boolean[] visited, ArrayList<Integer> current, ArrayList<ArrayList<Integer>> total){
        if (current.size() == arr.length){
            total.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = 0; i < arr.length; i++){
            if (visited[i]) continue;
            
            visited[i] = true;
            current.add(arr[i]);
            
            permute(arr, visited, current, total);
            
            current.remove(current.size() - 1);
            visited[i] = false;
        }
        
    }

    public static void main(String[] args) {
        test p = new test();
        System.out.println(p.solution(new int[]{0,0,1,1,1,0,1,0,1,0,1,1}, new int[][]{{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}})); // 5
    }
}