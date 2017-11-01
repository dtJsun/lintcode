class PartialMatch {

    public int getPartialMatch(String str) {

        int result = 0;

        HashSet<String> prefix = new HashSet<>();

        for (int i = 1; i < str.length(); i++) {
            prefix.add(str.substring(0, i));
        }

        for (int i = 2; i <= str.length(); i++) {
            
        }

        return result;
    }

}