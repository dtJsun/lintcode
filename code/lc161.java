class Solution {
    public boolean isOneEditDistance(String s, String t) {
        
        if (s.equals(t)) return false;
        
        int slen = s.length();
        int tlen = t.length();
        if (Math.abs(slen - tlen) >= 2) return false;
        
        if (slen == tlen) {
            int diff = 0;
            for (int i = 0; i < slen; i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    diff++;
                    if (diff == 2) {
                        return false;
                    }
                }
            }
            return true;
        }
        
        String longer = slen < tlen ? t : s;
        String shorter = slen < tlen ? s : t;
        int diff = 0;
        int i = 0, j = 0;
        while (i < longer.length() && j < shorter.length()) {
            if (longer.charAt(i) == shorter.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
            if (i - j > 1) return false;
        }
        
        return true;
        
    }
}