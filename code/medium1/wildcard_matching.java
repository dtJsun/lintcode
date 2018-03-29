public class Solution {
    public boolean isMatch(String s, String p) {

        boolean[][] f = new boolean[s.length() + 1][p.length() + 1];
        f[0][0] = true;

        for (int i = 0; i < p.length(); i++)
            if (p.charAt(i) == '*') {
                f[0][i + 1] = true;
            } else {
                break;
            }

        for (int i = 0; i < s.length(); i++)
            for (int j = 0; j < p.length(); j++) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
                    f[i + 1][j + 1] = f[i][j];
                }
                if (p.charAt(j) == '*') {
                    f[i + 1][j + 1] = f[i][j] || f[i][j + 1] || f[i + 1][j]; //1, multi, 0
                }
            }
        return f[s.length()][p.length()];
    }
}




