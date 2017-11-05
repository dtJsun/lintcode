/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
import java.util.Iterator;

public class NestedIterator implements Iterator<Integer> {

    private List<Integer> secList;
    private int index;

    public NestedIterator(List<NestedInteger> nestedList) {
        secList = nextHelper(nestedList);
        index = -1;
    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        // Write your code here
        return secList.get(index);
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        // Write your code here
        index++;
        return index < secList.size();
    }

    private List<Integer> nextHelper(List<NestedInteger> l) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i).isInteger()) {
                result.add(l.get(i).getInteger());
            } else {
                if (l.get(i).getList() != null) {
                    result.addAll(nextHelper(l.get(i).getList()));
                }
            }
        }
        return result;
    }

    @Override
    public void remove() {}
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v.add(i.next());
 */