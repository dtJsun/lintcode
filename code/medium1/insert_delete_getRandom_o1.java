class RandomizedSet {

    List<Integer> dataList = new ArrayList<>();
    Map<Integer, Integer> dataMap = new ArrayList<>();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (dataMap.containsKey(val)) return false;
        dataList.add(val);
        dataMap.put(val, dataList.size() - 1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!dataMap.containsKey(val)) return false;

        int index = dataMap.get(val);
        int lastVal = dataList.get(dataList.size() - 1);

        dataList.set(index, lastVal);
        dataMap.put(lastVal, index);

        dataList.remove(dataList.size() - 1);
        dataMap.remove(val);

        return true;

    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int randomIndex = Random.nextInt(dataList.size());
        return dataList.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */