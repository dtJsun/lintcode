/**
 * priority queue AC
 * 必须要修改curr 的 col值 和val 值， 新建一个Element 会超时 wft？
 */
public class Solution {
    
        class Element {
            int row;
            int col;
            int val;
            public Element(int r, int c, int v) {
                row = r;
                col = c;
                val = v;
            }
        }
    
        class ElementComparator implements Comparator<Element> {
            public int compare(Element a, Element b) {
                return a.val - b.val;
            }
        }
    
        /*
         * @param arrays: k sorted integer arrays
         * @return: a sorted array
         */
        public int[] mergekSortedArrays(int[][] arrays) {
            // write your code here
    
            Queue<Element> que = new PriorityQueue<Element>(arrays.length, new ElementComparator());
            int maxCount = 0;
            for (int i = 0; i < arrays.length; i++) {
                if (arrays[i].length > 0) {
                    que.add(new Element(i, 0, arrays[i][0]));    
                    maxCount += arrays[i].length;
                }
            }
    
            int[] ans = new int[maxCount];
            int index = 0;
            while (!que.isEmpty()) {
                Element curr = que.poll();
                ans[index] = curr.val;
                index++;
                if (curr.col < arrays[curr.row].length - 1) {
                    curr.col += 1;
                    curr.val = arrays[curr.row][curr.col];
                    // que.add(new Element(curr.row, curr.col + 1, arrays[curr.row][curr.col + 1]));
                    que.add(curr);
                }
            }
            return ans;
        }
    }