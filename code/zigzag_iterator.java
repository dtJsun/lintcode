public class ZigzagIterator {
    
        private int row;
        private int col;
        private List<Integer> v1;
        private List<Integer> v2;
    
        /*
        * @param v1: A 1d vector
        * @param v2: A 1d vector
        */public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            // do intialization if necessary
            row = -1;
            col = -1;
            this.v1 = new ArrayList<>(v1);
            this.v2 = new ArrayList<>(v2);
        }
    
        /*
         * @return: An integer
         */
        public int next() {
            // write your code here
            if (row == 0) {
                return v1.get(col);
            } else {
                return v2.get(col);
            }
        }
    
        /*
         * @return: True if has next
         */
        public boolean hasNext() {
            // write your code here
            int count = 0;
            while (count < 2) {
                row = (row + 1) % 2;
                if (row == 0) {
                    col++;
                }
                if (row == 0) {
                    if (col >= v1.size()) {
                        count++;
                    } else {
                        return true;
                    }
                } else {
                    if (col >= v2.size()) {
                        count++;
                    } else {
                        return true;
                    }
                }
            }
            return false;
        }
    }
    
    /**
     * Your ZigzagIterator object will be instantiated and called as such:
     * ZigzagIterator solution = new ZigzagIterator(v1, v2);
     * while (solution.hasNext()) result.add(solution.next());
     * Output result
     */