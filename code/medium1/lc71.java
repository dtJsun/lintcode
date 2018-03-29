class Solution {
    public String simplifyPath(String path) {

        String[] pathAry = path.split("/");

        Stack<String> pathStk = new Stack();

        for (int i = 0; i < pathAry.length; i++) {

            String curr = pathAry[i];

            if (curr == ".." && !pathStk.isEmpty()) {
                pathStk.pop();
            } else if (curr == ".") {
                continue;
            } else {
                pathStk.push(curr);
            }

        }

        if (pathStk.isEmpty()) {
            return "/";
        }

        return "/" + pathStk.peek();
    }
}