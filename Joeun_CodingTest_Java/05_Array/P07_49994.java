import java.util.*;

public class P07_49994 {
    public int solution(String dirs) {
        ArrayList<int[]> movings = new ArrayList<>();
        int x = 0; int y = 0; int[] moving = new int[4];
        for (int i=0; i<dirs.length(); i++){
            switch(dirs.charAt(i)){
                case 'U':
                    moving = new int[]{x, y, x, y+1};
                    break;
                case 'D':
                    moving = new int[]{x, y, x, y-1};
                    break;
                case 'R':
                    moving = new int[]{x, y, x+1, y};
                    break;
                case 'L':
                    moving = new int[]{x, y, x-1, y};
            }
            if (moving[2] < -5 || moving[2] > 5 || moving[3] < -5 || moving[3] > 5){
                continue;
            }
            
            if (movings.size() == 0){
                movings.add(moving);
                movings.add(new int[]{moving[2],moving[3],moving[0],moving[1]});
            } else {
                boolean flag = true;
                for (int j=0; j<movings.size(); j++){
                    if (Arrays.equals(movings.get(j),moving)){
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    movings.add(moving);
                    movings.add(new int[]{moving[2],moving[3],moving[0],moving[1]});
                }
            }
            
            x = moving[2]; y = moving[3];
        }
        
        int result = movings.size()/2;
        return result;
    }

    public void main(String[] args) {
        int result = solution("LULLLLLLU");
        System.out.println(result);
    }
}