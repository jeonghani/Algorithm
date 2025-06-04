import java.util.*;

class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            String bin = Long.toBinaryString(numbers[i]);
            int len = bin.length();
            int treeLen = 1;
            // 포화 이진트리 노드 개수 찾기 (2^h - 1 >= len)
            while (treeLen < len) {
                treeLen = treeLen * 2 + 1;
            }
            // 앞에 더미노드(0) 추가
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < treeLen - len; j++) sb.append('0');
            sb.append(bin);
            String fullBin = sb.toString();

            if (isValid(fullBin, 0, fullBin.length() - 1)) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }

    // [l, r] 구간이 유효한 포화 이진트리 구조인지 재귀적으로 판별
    private boolean isValid(String s, int l, int r) {
        if (l == r) return true; // 리프노드
        int mid = (l + r) / 2;
        char root = s.charAt(mid);
        // 루트가 0이면, 하위 서브트리에 1이 있으면 안됨
        if (root == '0') {
            // 왼쪽 서브트리
            if (hasOne(s, l, mid - 1)) return false;
            // 오른쪽 서브트리
            if (hasOne(s, mid + 1, r)) return false;
        }
        // 양쪽 서브트리도 재귀적으로 확인
        return isValid(s, l, mid - 1) && isValid(s, mid + 1, r);
    }

    // 구간 내 1이 있는지 확인
    private boolean hasOne(String s, int l, int r) {
        for (int i = l; i <= r; i++) {
            if (s.charAt(i) == '1') return true;
        }
        return false;
    }
}
