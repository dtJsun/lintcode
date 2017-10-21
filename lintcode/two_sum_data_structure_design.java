public class TwoSum {
    
        private HashMap<Integer, Integer> map = new HashMap<>();
    
        /*
         * Add the number to an internal data structure.
         * @param number: An integer
         * @return: nothing
         */
        public void add(int number) {
            // write your code here
            if (!this.map.containsKey(number)) {
                this.map.put(number, 1);
            } else {
                this.map.put(number, this.map.get(number) + 1);
            }
        }
    
        /*
         * @param value: An integer
         * @return: Find if there exists any pair of numbers which sum is equal to the value.
         */
        public boolean find(int value) {
            // write your code here
    
            for (int n : this.map.keySet()) {
                
                if (2 * n == value) {
                    if (this.map.get(n) >= 2)
                    return true;
                } else if (this.map.containsKey(value - n)) {
                    return true;
                }
            }
            return false;
        }
    }
    
    
    // Your TwoSum object will be instantiated and called as such:
    // TwoSum twoSum = new TwoSum();
    // twoSum.add(number);
    // twoSum.find(value);