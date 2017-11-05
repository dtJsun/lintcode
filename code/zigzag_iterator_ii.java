public class ZigzagIterator2 {

    class Element {
        int row;
        int col;
        public Element(int r, int c) {
            row = r;
            col = c;
        }
    }

    private Element element;
    private List<List<Integer>> list;

    /*
    * @param vecs: a list of 1d vectors
    */public ZigzagIterator2(List<List<Integer>> vecs) {
        // do intialization if necessary
        list = new ArrayList<>();
        for (int i = 0; i < vecs.size(); i++) {
            if (vecs.get(i).size() > 0) {
                list.add(new ArrayList<Integer>(vecs.get(i)));
            }
        }
        element = new Element(-1, -1);
    }

    /*
     * @return: An integer
     */
    public int next() {
        // write your code here
        return list.get(element.row).get(element.col);
    }

    /*
     * @return: True if has next
     */
    public boolean hasNext() {
        // write your code here
        int count = 0;
        while (count < list.size()) {
            element.row = (element.row + 1) % list.size();
            if (element.row == 0) {
                element.col += 1;
            }
            if (element.col < list.get(element.row).size()) {
                return true;
            }
            count++;
        }
        return false;
    }
}

/**
 * Your ZigzagIterator2 object will be instantiated and called as such:
 * ZigzagIterator2 solution = new ZigzagIterator2(vecs);
 * while (solution.hasNext()) result.add(solution.next());
 * Output result
 */