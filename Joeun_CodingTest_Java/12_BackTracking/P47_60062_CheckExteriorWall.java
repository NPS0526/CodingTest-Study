public class P47_60062_CheckExteriorWall {
    private static int answer;
    private static int[] Weak;
    private static int[] Dist;
    private static boolean[] visited;
    private static int start;
    
    public int solution(int n, int[] weak, int[] dist) {
        answer = Integer.MAX_VALUE;
        Weak = new int[weak.length*2];
        for (int i = 0; i < weak.length; i++){
            Weak[i] = weak[i];
            Weak[i+weak.length] = weak[i]+n;
        }
        Dist = dist;
        visited = new boolean[dist.length];
        
        for (int i = 0; i < weak.length; i++){
            start = i;
            checkOut(i, 1);
        }
        
        return answer == Integer.MAX_VALUE? -1 : answer;
    }
    
    private static void checkOut(int now, int cntDist){
        if (cntDist >= answer) return; // 가지치기
        
        for (int i = 0; i < Dist.length; i++){
            if (!visited[i]){
                visited[i] = true;
                
                // 커버할 수 있는 구간 구하기
                int next = now;
                while (next < start + Weak.length/2 &&
                      Weak[next] - Weak[now] <= Dist[i])
                    next++;
                
                // 종료 조건: 취약점 모두 방문했을때
                if (next - start >= Weak.length/2){
                    answer = Math.min(answer, cntDist);
                    visited[i] = false;
                    return;
                }
                
                checkOut(next, cntDist+1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        P47_60062_CheckExteriorWall p = new P47_60062_CheckExteriorWall();
        System.out.println(p.solution(12, new int[]{1, 5, 6, 10}, new int[]{1, 2, 3, 4})); // 2
    }
}