class Solution {
    public String solution(String X, String Y) {
        int[] xCount = new int[10]; // 0~9 숫자 카운트
        int[] yCount = new int[10];

        // X에서 각 숫자의 개수 세기
        for (char c : X.toCharArray()) {
            xCount[c - '0']++;
        }

        // Y에서 각 숫자의 개수 세기
        for (char c : Y.toCharArray()) {
            yCount[c - '0']++;
        }

        StringBuilder sb = new StringBuilder();

        // 9부터 0까지 큰 수부터 확인
        for (int i = 9; i >= 0; i--) {
            int common = Math.min(xCount[i], yCount[i]);
            for (int j = 0; j < common; j++) {
                sb.append(i);
            }
        }

        // 아무 숫자도 없다면
        if (sb.length() == 0) return "-1";

        // 0으로만 구성되어 있다면 (예: "000")
        if (sb.charAt(0) == '0') return "0";

        return sb.toString();
    }
}
