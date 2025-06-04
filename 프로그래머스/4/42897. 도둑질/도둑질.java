class Solution {
    public int solution(int[] money) {
        int n = money.length;
        if (n == 1) return money[0];
        
        int case1 = linearRob(money, 0, n-2);  // 첫 집 포함, 마지막 제외
        int case2 = linearRob(money, 1, n-1);  // 첫 집 제외, 마지막 포함
        
        return Math.max(case1, case2);
    }
    
    private int linearRob(int[] money, int start, int end) {
        if (start == end) return money[start];
        
        int prevPrev = money[start];
        int prev = Math.max(money[start], money[start+1]);
        
        for (int i = start+2; i <= end; i++) {
            int current = Math.max(prev, prevPrev + money[i]);
            prevPrev = prev;
            prev = current;
        }
        return prev;
    }
}
