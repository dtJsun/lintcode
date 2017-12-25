class Solution {
    public int romanToInt(String s) {

        if (s.length() == 0) return 0;

        int ans = getInt(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = getInt(s.charAt(i));
            ans += num;
            if (num > getInt(s.charAt(i - 1))) {
                ans -= getInt(s.charAt(i - 1)) * 2;
            }
        }
        return ans;
    }

    private int getInt(char ch) {
        switch (ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}