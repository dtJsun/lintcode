// Memory limit exceeded
public class Solution {
    /*
     * @param str: A string
     * @return: all permutations
     */
    public List<String> stringPermutation2(String str) {
        // write your code here
        List<String> ans = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        String curr = "";
        int[] mark = new int[str.length()];
        dfs(set, mark, str, 0, ans, curr);
        Collections.sort(ans);
        return ans;
    }

    private void dfs(
        HashSet<String> set,
        int[] mark,
        String str,
        int level,
        List<String> ans,
        String curr
    ) {

        if (level == str.length()) {
            if (!set.contains(curr)) {
                set.add(curr);
                ans.add(curr);
            }
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            if (mark[i] == 0) {
                curr += Character.toString(str.charAt(i));
                mark[i] = 1;
                dfs(set, mark, str, level + 1, ans, curr);
                curr = curr.substring(0, curr.length() - 1);
                mark[i] = 0;
            }
        }

    }

}