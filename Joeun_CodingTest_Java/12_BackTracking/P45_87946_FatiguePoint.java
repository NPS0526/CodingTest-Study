public class P45_87946_FatiguePoint {
    private static boolean[] visited;
    private static int[][] dungeon;
    private static int answer;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dungeon = dungeons;
        answer = 0;
        
        for (int i=0; i<dungeons.length; i++){
            dfs(i,k,0);
        }
        
        return answer;
    }
    
    private void dfs(int now, int FP, int cnt){
        if (FP < dungeon[now][0])
            return;
        
        visited[now] = true;
        FP -= dungeon[now][1];
        cnt++;
        answer = Math.max(answer, cnt);
        
        for (int i=0; i<dungeon.length; i++){
            if (!visited[i]){
                dfs(i, FP, cnt);
            }
        }
        
        visited[now] = false;
    }
    public static void main(String[] args) {
        P45_87946_FatiguePoint p = new P45_87946_FatiguePoint();
        System.out.println(p.solution(80, 
            new int[][]{{80,20},{50,40},{30,10}})); // 3
    }
}