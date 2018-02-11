// go through map
class CustomComparator {

    class Stock {
        int id;
        double value;
        public Stock(int i, int v) {
            id = i;
            value = v;
        }
    }

    class stockComparator implements Comparator<Stock> {
        public int compare(Stock a, Stock b) {
            return b.value - a.value;
        }
    }

    public List<Stock> solution(List<Stock> list, int num) {

        HashMap<Integer, Double> map = new HashMap<>();

        //.....

        PriorityQueue<Stock> que = new ArrayList<>(0, new StockComparator());

        for (Entry<Integer, Double> entry : map.entrySet()) {
            int id = entry.getKey();
            double value = entry.getValue();
        }


    }

}