class Solution {
    
    // class PointComparator implements <int[]> {
    //     public int compare(int[] a, int[] b) {
    //         if (a[0] == b[0]) {
    //             retuern a[1] - b[1];
    //         }
    //         return a[0] - b[0];
    //     }
    // }
    
    // 死记：排序数组的时候，把comparator写在sort里面，因为写成单独的class的话 会报错
    public int findMinArrowShots(int[][] points) {
        
        if (points.length == 0) return 0;
        
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                        if (a[0] == b[0]) {
                            return a[1] - b[1];
                        }
                        return a[0] - b[0];
            }
        });
        
        int count = 1;
        int end = points[0][1];
        
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                count++;
                end = points[i][1];
            } else {
                end = Math.min(end, points[i][1]);
            }
        }
        
        return count;
    }
}