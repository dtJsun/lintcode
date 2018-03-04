class Solution {
    public String countAndSay(int n) {
        
        String s = "1";
        if (n == 1) return s;
        for (int i = 2; i <= n; i++) {
            StringBuilder temp = new StringBuilder();

            for (int j = 0; j < s.length(); j++) {
                char curr = s.charAt(j);
                int count = 0;
                while (s.charAt(j) == curr && j < s.length()) {
                    count++;
                    j++;
                }
                j--;
                temp.append(count);
                temp.append(curr);
            }
            s = temp.toString();
        }

        return s;
    }
}