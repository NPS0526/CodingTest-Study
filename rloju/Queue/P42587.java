package Queue;

import java.util.ArrayDeque;

public class P42587 {
    
    public record Node(int idx, int prior) { }
    
    public int solution(int[] priorities, int location) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.addLast(new Node(i, priorities[i]
            ));
        }
        int cnt = 0;
        
        while (!queue.isEmpty()) {
            Node front_node = queue.peekFirst();
            if (queue.stream().anyMatch(x -> x.prior() > front_node.prior())) {
                Node n = queue.pollFirst();
                queue.addLast(n);
            } else {
                if (front_node.idx() == location)
                    return ++cnt;
                queue.pollFirst();
                cnt++;
            }
        }
        return cnt;
    }
}

