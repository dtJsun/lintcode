//给一个数组, 重新排序, 每个数二进制中1的个数少的排在前面, 个数相同的, 数的值小的排在前面.

class BitSort {

    class Node {
        int num;
        int countOnes;
        public Node(int n) {
            num = n;
            countOnes = getCountOnes(n);
        }
        private int getCountOnes(int n) {
            int count = 0;
            while (n > 0) {
                n = n & (n - 1);
                count++;
            }
            return count;
        }
    }

    class NumberComparator implements Comparator<Node> {
        public int compare(Node a, Node b) {
            if (a.countOnes == b.countOnes) {
                return a.num - b.num;
            } else {
                return a.countOnes - b.countOnes;
            }
        }
    }

    public int[] sortNumber(int[] nums) {

        Node[] nodes = new Node[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nodes[i] = new Node(nums[i]);
        }

        Arrays.sort(nodes, new NumberComparator());

        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nodes[i].num;
        }
        return ans;
    }

}
