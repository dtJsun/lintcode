class Solution {

    class Node {
        int level;
        String name;
        public Node(int l, String n) {
            level = l;
            name = n;
        }
    }

    public int lengthLongestPath(String input) {

        String dirs[] = input.split("\n");

        Stack<Node> stk = new Stack();

        int maxLen = 0;
        String currDir = "";

        for (int i = 0; i < dirs.length; i++) {

            String[] temp = dirs[i].split("\t");
            String name = temp[temp.length - 1];

            

        }

        
    }
}