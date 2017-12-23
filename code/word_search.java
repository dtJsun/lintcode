public class Solution {

    class Coordinate {
        int x;
        int y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // private HashMap<Character, List<Coordinate>> map = new HashMap<>();
    // private boolean[][] mark;

    /*
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        // write your code here
        // mark = new boolean[board.length][board[0].length];

        // for (int i = 0; i < board.length; i++) {
        //     for (int j = 0; j < board[i].length; j++) {
        //         mark[i][j] = true;
        //         if (!map.containsKey(board[i][j])) {
        //             List<Coordinate> list = new ArrayList<>();
        //             map.put(board[i][j], list);
        //         }
        //         map.get(board[i][j]).add(new Coordinate(i, j));
        //     }
        // }

        // for (int i = 0; i < board.length; i++) {
        //     for (int j = 0; j < board[0].length; j++) {
        //         mark[i][j] = true;
        //     }
        // }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (bfs(board, word, 0, new Coordinate(i, j))) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean bfs(char[][] board, String word, int curr, Coordinate coordinate){
        
        if (curr == word.length() - 1) return true;

        // if (!mark[coordinate.x][coordinate.y]) {
        //     return false;
        // }

        // List<Coordinate> list = map.get(word.charAt(start));
        int[] dx = new int[]{0, -1, 0, 1};
        int[] dy = new int[]{-1, 0, 1, 0};

        for (int i = 0; i < 4; i++) {
            int newX = coordinate.x + dx[i];
            int newY = coordinate.y + dy[i];
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length) {
                if (board[newX][newY] == word.charAt(curr + 1)) {
                    if (!bfs(board, word, curr + 1, new Coordinate(newX, newY))) {
                        // mark[newX][newY] = false;
                    } else {
                        return true;
                    }
                }
            }
        }
        
        // mark[coordinate.x][coordinate.y] = false;
        return false;
    }

}