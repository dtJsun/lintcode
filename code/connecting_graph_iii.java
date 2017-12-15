public class ConnectingGraph3 {
    
        private HashMap<Integer, ArrayList<Integer>> listMap = new HashMap<>();
        private HashMap<Integer, Integer> nodeMap = new HashMap<>();
    
        /*
        * @param n: An integer
        */public ConnectingGraph3(int n) {
            // do intialization if necessary
    
            for (int i = 1; i <= n; i++) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                listMap.put(i, list);
                nodeMap.put(i, i);
            }
    
        }
    
        /*
         * @param a: An integer
         * @param b: An integer
         * @return: nothing
         */
        public void connect(int a, int b) {
            // write your code here
            int listIDA = nodeMap.get(a);
            int listIDB = nodeMap.get(b);
            
            if (listIDA == listIDB) return;
    
            listMap.get(listIDA).addAll(listMap.get(listIDB));
            for (int node : listMap.get(listIDB)) {
                nodeMap.put(node, listIDA);
            }
            listMap.remove(listIDB);
        }
    
        /*
         * @return: An integer
         */
        public int query() {
            // write your code here
            return listMap.size();
        }
    
        // private void mergeList(int a, int b) {
        //     int listIDA = nodeMap.get(a);
        //     int listIDB = nodeMap.get(b);
    
        //     listMap.get(listIDA).addAll(listMap.get(listIDB));
        //     for (int node : listMap.get(listIDB)) {
        //         nodeMap.put(node, listIDA);
        //     }
        // }
    }