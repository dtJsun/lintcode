public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here

        if (dict == null) return 0;

        if (start == end) return 1;

        dict.add(start);
        dict.add(end);
        int ans = 0;
        HashSet<String, Integer> mark = new HashSet<>();
        Queue<String> que = new LinkedList<>();

        que.offer(start);
        while (!que.isEmpty()) {
            ans++;
            int size = que.size();
            for (int i = 0; i < size; i++) {
                String curr = que.poll();
                ArrayList<String> nextWords = getNextWords(curr, Set<String> dict);
                for (String nextWord : nextWords) {
                    if (mark.containsKey(nextWord)) {
                        continue;
                    }
                    if (nextWord.equals(end)) {
                        return ans + 1;
                    }
                    if (dict.contains(nextWord)) {
                        mark.put(nextWord, 1);
                        que.offer(nextWord);
                    }
                }
            }
        }
        return 0;
    }

    private ArrayList<String> getNextWords(String curr, Set<String> dict) {
        ArrayList<String> nextWords = new ArrayList<>();

        char[] s = curr.toCharArray();
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < 26; j++) {
                char tempChar = s[i];
                s[i] = (char)('a' + j);
                String temp = new String(s);
                if (dict.contains(temp)) {
                    nextWords.add(temp);
                }
                s[i] = tempChar;
            }
        }
        return nextWords;
    }

    

}