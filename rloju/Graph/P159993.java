package Graph;

import java.util.*;

public class P159993 {
    private static char[][] map;
    private static boolean[][] visited;
    
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    
    static class Node{
        int row;
        int col;
        int dist;
        
        public Node(int row, int col, int dist){
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
    
    private static Deque<Node> q;
    
    public int solution(String[] maps) {
        int r = maps.length;
        int c = maps[0].length();
        
        map = Arrays.stream(maps).map(String::toCharArray).toArray(char[][]::new);
        
        Node start=null, exit = null, lever=null;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(map[i][j] == 'S') start = new Node(i, j, 0);
                else if(map[i][j] == 'E') exit = new Node(i, j, 0);
                else if(map[i][j] == 'L') lever = new Node(i, j, 0);
            }
        }
        
        //bfs 두번 부르기(start->lever, lever->exit)
        int sLength = bfs(start, lever, r, c);
        int eLength = bfs(lever, exit, r, c);
        
        if(sLength == -1 || eLength==-1) return -1;
        else return sLength + eLength;
    }
    
    private static int bfs(Node from, Node to, int n, int m){
        q = new ArrayDeque<>();
        visited = new boolean[n][m];
        
        q.addLast(from);
        visited[from.row][from.col] = true;
        
        while(!q.isEmpty()){
            Node curNode = q.pollFirst();
            int curRow = curNode.row;
            int curCol = curNode.col;
            int curLength = curNode.dist;
            
            for(int i=0; i<4; i++){
                int nextRow = curRow + dx[i];
                int nextCol = curCol + dy[i];
                
                if(nextRow == to.row && nextCol == to.col) return curLength+1;
                
                if((nextRow>=0 && nextRow<n) && (nextCol>=0 && nextCol <m)){
                    if(map[nextRow][nextCol] != 'X' && !visited[nextRow][nextCol]){
                        q.addLast(new Node(nextRow, nextCol, curLength+1));
                        visited[nextRow][nextCol] = true;
                    }
                }
            }
        }
        return -1;
    }
}
