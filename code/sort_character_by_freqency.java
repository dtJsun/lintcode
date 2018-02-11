// bucket sort
class Solution {
    public String frequencySort(String s) {
        
        String[] ary = new String[s.length() + 1];
        Arrays.fill(ary, "");

        HashMap<Character, Integer> dataMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!dataMap.containsKey(s.charAt(i))) {
                dataMap.put(s.charAt(i), 1);
            } else {
                dataMap.put(s.charAt(i), dataMap.get(s.charAt(i)) + 1);
            }
        }

        for (char key : dataMap.keySet()) {
            ary[dataMap.get(key)] += key;
        }
        

        // 这个地方如果用string会超时
        StringBuilder ans = new StringBuilder();
        // String ans = "";
        for (int i = s.length(); i >= 0; i--) {
            if (ary[i].length() > 0) {
                for (int k = 0; k < ary[i].length(); k++) {
                    for (int j = 0; j < i; j++) {
                        // ans += ary[i].charAt(k);
                        ans.append(ary[i].charAt(k));
                    }
                }
                
            }
        }
        return ans.toString();
        // return ans;
    }
}


// TLE 
// class Solution {
    
//     class Node {
//         char c;
//         int frequency;
//         public Node(char c) {
//             this.c = c;
//             this.frequency = 1;
//         }
//     }

//     class NodeComparator implements Comparator<Node> {
//         public int compare(Node a, Node b) {
//             return b.frequency - a.frequency;
//         }
//     }
    
//     public String frequencySort(String s) {
        
//         HashMap<Character, Node> dataMap = new HashMap<>();
//         List<Node> nodeList = new ArrayList<>();

//         for (int i = 0; i < s.length(); i++) {
//             char c = s.charAt(i);
//             if (!dataMap.containsKey(c)) {
//                 Node curr = new Node(c);
//                 dataMap.put(c, curr);
//                 nodeList.add(curr);
//             } else {
//                 dataMap.get(c).frequency++;
//             }
//         }
        
//         Collections.sort(nodeList, new NodeComparator());

//         String ans = "";
//         for (int i = 0; i < nodeList.size(); i++) {
//             int repeat = nodeList.get(i).frequency;
//             for (int j = 0; j < repeat; j++) {
//                 ans += nodeList.get(i).c;
//             }
//         }

//         return ans;
//     }
// }