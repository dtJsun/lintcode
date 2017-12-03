class Solution {

    public List<String> continuousSubstring(String s) {
        List<String> ans = new ArrayList<>();
        Set<String> mark = new HashSet<>();
        dfs(ans, mark, s, 1);
        return ans;
    }

    private dfs(
        List<String> ans,
        Set<String> mark,
        String s,
        int pointer,
        String subString
    ) {
        if (pointer < s.length && s.charAt(pointer) == s.charAt(pointer - 1)) {
            res.add(new String(subString));
        }

        if (pointer >= s.length()) {
            return;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            String curr = s.substring(start, i);
            if (curr.length() > 1 && 
            (int)(curr.charAt(curr.length() - 1) - curr.charAt(curr.length() - 2)) == 1 &&
            !mark.contains(curr)) {
                ans.add(curr);
                mark.add(curr);
                dfs(ans, mark, s, i);
            }
        }
        
    }


}