class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        // numer1/denom1 + numer2/denom2 = (numer1*denom2 + numer2*denom1)/(denom1*denom2)
        // 분수 덧셈
        int numer = numer1*denom2 + numer2*denom1;
        int denom = denom1*denom2;
        
        // 기약분수 만들기 위해 최대공약수 구함
        int a = numer;
        int b = denom;
        
        while(b!=0) {
            int tmp = b;
            b = a%b;
            a = tmp;
        }
        int gcd = a;
        
        int[] answer = {numer/gcd, denom/gcd};
        return answer;
    }
}