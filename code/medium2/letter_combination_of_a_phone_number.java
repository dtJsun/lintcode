class Solution {
    public List<String> letterCombinations(String digits) {

        String[] src == new String[digits.length()];

        for (int i = 0; i < digits.length(); i++) {
            src[i] = getStr(digits.chartAt(i));
        }

        List<String> ans = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        dfs(src, 0, result, ans);

        return ans;
    }

    private dfs(
        String[] strs,
        int curr,
        StringBuilder result,
        List<String> ans
    ) {

        if (curr == strs.length) {
            ans.add(result.toString());
            return;
        }

        for (int i = 0; i < strs[curr].length(); i++) {
            result.append(strs[curr].charAt(i));
            dfs(strs, curr + 1, result, ans);
            result.deleteCharAt(result.length() - 1);
        }

    }

    private String getStr(char n) {

        switch (n) {
            case '1':
                return "";
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            case '0':
                return "";
        }

    }

}