class Solution {
    private String s = "AABBBBCCDDDLS";
    public String solution(String s) {

        String ans = "";

        for (int i = 0; i + 1 < s.length();) {
            int count = 1;
            int j = i + 1;
            while (j < s.length() && s.charAt(j) == s.charAt(j - 1)) {
                j++;
                count++;
            }
            if (count < 3) {
                ans += s.substring(i, j);
            }
            i = j;
        }
        return ans;
    }
}