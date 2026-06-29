package Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class P49994 {
    public record Point(int x, int y) {}
    public record Edge(Point from, Point to) {}
    
    public int solution(String dirs) {
        HashMap<Character, int[]> dir = new HashMap<>();
        dir.put('U', new int[]{1, 0});
        dir.put('D', new int[]{-1, 0});
        dir.put('R', new int[]{0, 1});
        dir.put('L', new int[]{0, -1});
        
        int x = 0, y = 0;
        int count = 0;
        HashSet<Edge> visited = new HashSet<>();
        
        for (char d : dirs.toCharArray()) {
            int nx = x + dir.get(d)[0];
            int ny = y + dir.get(d)[1];
            
            if (nx > 5 || nx < -5 || ny > 5 || ny < -5) continue;
            
            Point from = new Point(x, y);
            Point to   = new Point(nx, ny);
            
            boolean a = visited.add(new Edge(from, to));
            boolean b = visited.add(new Edge(to, from));
            if (a && b) count++;
            
            x = nx;
            y = ny;
        }
        return count;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(new P49994().solution(input));
    }
}