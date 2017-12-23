public class Solution {

    class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /*
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public List<String> wordSearchII(char[][] board, List<String> words) {
        // write your code here
        
        if (board == null || words == null) return new List<String>();

        List<String> ans = new ArrayList<>();

        for (int i = 0; i < words.size(); i++) {
            String curr = words.get(i);
            if (curr == null || curr.length() == 0) {
                continue;
            }
            if (inDictionary(board, curr)) {
                ans.add(curr);
            }
        }
        return ans;

    }

    private boolean inDictionary(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] mark = new boolean[board.length][board[0].length];
                    if (dfs(board, word, new Node(i, j), 0, mark)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(
        char[][] board,
        String word,
        Node curr,
        int start,
        boolean[][] mark
    ) {

        int[] dx = new int[]{0, -1, 0, 1};
        int[] dy = new int[]{-1, 0, 1, 0};

        for (int i = 0; i < 4; i++) {
            int newX = curr.x + dx[i];
            int newY = curr.y + dy[i];

            if (
                newX >= 0 &&
                newX < board.length && 
                newY >= 0 && 
                newY < board[0].length && 
                !mark[newX][newY]
            ) {

                if (board[newX][newY] == word.charAt(start + 1)) {
                    mark[newX][newY] = true;
                    if (dfs(board, word, new Node(newX, newY), start + 1, mark)) {
                        return true;
                    } else {
                        mark[newX][newY] = false;
                    }
                }
            }

        }
        return false;

    }


}