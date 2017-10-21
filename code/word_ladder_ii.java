public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: a list of lists of string
     */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here
        List<List<String>> ans = new ArrayList<>();
        // if (dict.size() == 0) return ans;
        // if (start == end) return 1;

        HashMap<String, ArrayList<String>> neighbors = new HashMap<>();
        HashMap<String, Integer> distance = new HashMap<>();
        // Set<String> mark = new HashSet<>();
        dict.add(start);
        dict.add(end);
        for (String s : dict) {
            neighbors.put(s, new ArrayList<>());
        }

        bfs(start, neighbors, distance, dict);

        ArrayList<String> path = new ArrayList<>();
        dfs(ans, path, end, start, distance, neighbors);

        return ans;
    }

    private void bfs(
        String start,
        HashMap<String, ArrayList<String>> neighbors,
        HashMap<String, Integer> distance,
        Set<String> dict
    ) {

        Queue<String> que = new LinkedList<>();
        que.offer(start);
        distance.put(start, 0);
        while (!que.isEmpty()) {
                String curr = que.poll();
                ArrayList<String> nextWords = getNextWords(curr, dict);
                for (String nextWord : nextWords) {
                    neighbors.get(nextWord).add(curr);
                    if (!distance.containsKey(nextWord)) {
                        // System.out.println(nextWord);
                        // mark.add(nextWord);
                        distance.put(nextWord, distance.get(curr) + 1);
                        que.offer(nextWord);
                    }
                }
        }
    }

    private ArrayList<String> getNextWords(String curr, Set<String> dict) {

        char[] currAry = curr.toCharArray();
        ArrayList<String> nextWords = new ArrayList<>();
        for (int i = 0; i < curr.length(); i++) {
            char temp = currAry[i];
            for (int j = 0; j < 26; j++) {
                currAry[i] = (char)('a' + j);
                String tempStr = new String(currAry);
                if (tempStr != curr && dict.contains(tempStr)) {
                    nextWords.add(tempStr);
                }
            }
            currAry[i] = temp;
        }
        return nextWords;
    }

    private void dfs(
        List<List<String>> ans,
        ArrayList<String> path,
        String curr,
        String end,
        HashMap<String, Integer> distance,
        HashMap<String, ArrayList<String>> neighbors
    ) {
        path.add(curr);
        if (curr == end) {
            // System.out.println(curr);
            Collections.reverse(path);
            ans.add(new ArrayList<>(path));
            Collections.reverse(path);
        } else {
            for (String nextWord : neighbors.get(curr)) {
                if (distance.containsKey(nextWord) && distance.get(curr) == distance.get(nextWord) + 1) {
                    dfs(ans, path, nextWord, end, distance, neighbors);
                }
            }
        }
        path.remove(path.size() - 1);
    }
}