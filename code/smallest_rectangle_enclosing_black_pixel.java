public class Solution {
    
        class Element {
            int x;
            int y;
            public Element (int x, int y) { 
                this.x = x;
                this.y = y;
            }
        }
    
        /*
         * @param image: a binary matrix with '0' and '1'
         * @param x: the location of one of the black pixels
         * @param y: the location of one of the black pixels
         * @return: an integer
         */
        public int minArea(char[][] image, int x, int y) {
            // write your code here
            return bfs(image, x, y);
        }
    
        private int bfs(char[][] image, int x, int y) {
            
            Queue<Element> que = new LinkedList<>();
            int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE, up = Integer.MAX_VALUE, down = Integer.MIN_VALUE;
            que.offer(new Element(x, y));
            image[x][y] = 0;
    
            int[] directX = new int[]{0, -1, 0, 1};
            int[] directY = new int[]{-1, 0, 1, 0};
    
            while (!que.isEmpty()) {
                int size = que.size();
                for (int i = 0; i < size; i++) {
                    Element curr = que.poll();
                    left = Math.min(left, curr.y);
                    right = Math.max(right, curr.y);
                    up = Math.min(up, curr.x);
                    down = Math.max(down, curr.x);
                    for (int j = 0; j < 4; j++) {
                        int newX = curr.x + directX[j];
                        int newY = curr.y + directY[j];
                        if (newX >= 0 && newX < image.length && newY >= 0 && newY < image[0].length) {
                            if (image[newX][newY] == '1') {
                                que.offer(new Element(newX, newY));
                                image[newX][newY] = 0;
                            }
                        }
                    }
                }
            }
    
            return (down - up + 1) * (right - left + 1);
    
        }
    
    }