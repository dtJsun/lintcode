class Solution {

    class Node {
        int origin;
        int current;
        public Node(int a, int b) {
            origin = a;
            current = b;
        }
    }

    public String minWindow(String s, String t) {
        
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        HashMap<Character, Node> dataMap = new HashMap();
        HashSet<Character> dataSet = new HashSet();
        
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (!dataMap.containsKey(ch)) {
                dataMap.put(ch, new Node(0, 0));
            }
            dataMap.get(ch).origin++;
        }

        String ans = "";
        int minLen = Integer.MAX_VALUE;

        int j = 0;
        for (int i = 0; i < s.length() && j < s.length(); i++) {

            while (j < s.length()) {
                if (dataMap.containsKey(s.charAt(j))) {
                    dataMap.get(s.charAt(j)).current++;
                    if (dataMap.get(s.charAt(j)).origin == dataMap.get(s.charAt(j)).current) {
                        dataSet.add(s.charAt(j));
                    }
                    if (dataSet.size() == dataMap.size()) {
                        break;
                    }
                }
                j++;
            }
            j++;
            

            if (dataSet.size() != dataMap.size()) {
                return ans;
            }

            while (dataSet.size() == dataMap.size()) {
                if (dataMap.containsKey(s.charAt(i))) {
                    dataMap.get(s.charAt(i)).current--;
                    if (dataMap.get(s.charAt(i)).current < dataMap.get(s.charAt(i)).origin) {
                        dataSet.remove(s.charAt(i));
                        break;
                    }
                }
                i++;
            }
            // i--;

            int len = j - i;
            if (len < minLen) {
                ans = s.substring(i, j);
                minLen = len;
            }

        }
        return ans;
    }
}