class Solution {

    HashMap<String, List<String>> graph = new HashMap<>();

    public void createGraph(String destination, String origin) {
        if (!graph.containsKey(origin)) {
            graph.put(origin, new ArrayList<>());
        }
        graph.get(origin).add(destination);
    }

    public List<List<String>> findAllPaths(String origin, String destination) {

        List<List<String>> ans = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        dfs(curr, ans, origin, destination);
        return ans;

    }

    private void dfs(
        List<String> curr,
        List<List<String>> ans,
        String origin,
        String destination
    ) {

        if (origin.equals(destination)) {
            ans.add(curr);
            return;
        }

        List<String> nextStops = graph.get(origin);

        for (int i = 0; i < nextStops.size(); i++) {
            curr.add(nextStops.get(i));
            dfs(curr, ans, nextStops.get(i), destination);
            curr.remove(curr.size() - 1);
        }

    }

}