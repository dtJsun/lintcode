public class Vector2D implements Iterator<Integer> {
    
    private int row;
    private int col;
    private List<List<Integer>> vec;

    public Vector2D(List<List<Integer>> vec2d) {
        // Initialize your data structure here
        vec = new ArrayList<>();
        for (int i = 0; i < vec2d.size(); i++) {
            vec.add(new ArrayList<>(vec2d.get(i)));
        }
        row = 0;
        col = 0;
    }
    
        @Override
    public Integer next() {
        // Write your code here
        // if (col < vec.get(row).size()) {
            Integer ans = new Integer(vec.get(row).get(col));
            if (++col == vec.get(row).size()) {
                col = 0;
                row++;
            }
            return ans;
        // }

    }
    
    @Override
    public boolean hasNext() {
        // Write your code here
        if (row < vec.size() && vec.get(row).size() > 0) {
            return true;
        }
        // if (col < vec.get(row).size()) {
        //     return true;
        // } else if (row + 1 < vec.size() && vec.get(row + 1).size() > 0) {
        //     return true;
        // }
        return false;
    }
    
        @Override
        public void remove() {}
}
    
    /**
     * Your Vector2D object will be instantiated and called as such:
     * Vector2D i = new Vector2D(vec2d);
     * while (i.hasNext()) v[f()] = i.next();
     */