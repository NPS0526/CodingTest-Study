class Solution {
    public int solution(int n, int a, int b) {
        int round = 0;
        
        // 두 사람의 번호가 같아질 때까지(만날 때까지) 반복
        while (a != b) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            round++;
        }
        
        return round;
    }
}