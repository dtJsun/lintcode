public class Solution {
    /*
     * @param str: A string
     * @return: all permutations
     */
    public List<String> stringPermutation2(String str) {
        // write your code here

        char[] s = str.toCharArray();
        Arrays.sort(s);
        List<String> ans = new ArrayList<>();
        ans.add(new String(s));
        str = getNextPermutation(s);
        while (str != null) {
            ans.add(str);
            s = str.toCharArray();
            str = getNextPermutation(s);
        }
        return ans;

    }

    private String getNextPermutation(char[] s) {

        int index = -1;
        for (int i = s.length - 1; i > 0; i--) {
            if (s[i] > s[i - 1]) {
                index = i - 1;
                break;
            }
        }

        if (index == -1) {
            return null;
        }

        for (int i = s.length - 1; i > index; i--) {
            if (s[i] > s[index]) {
                swapSingle(s, i, index);
                break;
            }
        }

        swapMultiple(s, index + 1, s.length - 1);

        return new String(s);

    }

    private void swapSingle(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    // reverse this part in char[]
    private void swapMultiple(char[] s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            swapSingle(s, i, j);
        }
    }

}