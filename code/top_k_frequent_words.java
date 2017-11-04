public class Solution {
    
        class Element {
            String word;
            int frequency;
            public Element(String w, int f) {
                word = w;
                frequency = f;
            }
        }
    
        private Comparator<Element> ElementComparator = new Comparator<Element>() {
            public int compare(Element a, Element b) {
                if (a.frequency == b.frequency) {
                    return a.word.compareTo(b.word);
                } else {
                    return b.frequency - a.frequency;
                }
            }
        };
    
        /*
         * @param words: an array of string
         * @param k: An integer
         * @return: an array of string
         */
        public String[] topKFrequentWords(String[] words, int k) {
            // write your code here
    
            HashMap<String, Integer> map = new HashMap<>();
    
            for (int i = 0; i < words.length; i++) {
                if (map.containsKey(words[i])) {
                    map.put(words[i], map.get(words[i]) + 1);
                } else {
                    map.put(words[i], 1);
                }
            }
    
            ArrayList<Element> list = new ArrayList<>();
            for (String word : map.keySet()) {
                list.add(new Element(word, map.get(word).intValue()));
            }
    
            Collections.sort(list, ElementComparator);
    
            String[] ans = new String[k];
            for (int i = 0; i < k; i++) {
                ans[i] = list.get(i).word;
            }
            return ans;
        }
    }
    