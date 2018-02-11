class Solution {
    public String convert(String s, int numRows) {
        
        if (numRows == 1) return s;

        StringBuilder ans = new StringBuilder();
        
        for (int i = 0; i < numRows; i++) {
            int curr = i;
            boolean down = true;
            while (curr < s.length()) {
                ans.append(s.charAt(curr));
                if (i == 0 || i == numRows - 1) {
                    curr = curr + (numRows - 1) * 2;
                } else {
                    if (down) {
                        curr = curr + (numRows - 1 - i) * 2;
                    } else {
                        curr = curr + i * 2;
                    }
                    down = !down;
                }
            }
        }

        return ans.toString();

    }
}