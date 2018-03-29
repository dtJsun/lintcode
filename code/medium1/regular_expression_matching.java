// class Solution {
//     public boolean isMatch(String s, String p) {
        
//         Stack<Character> stks = new Stack();
//         Stack<Character> stkp = new Stack();

//         for (int i = 0; i < s.length(); i++) {
//             stks.push(s.charAt(i));
//         }

//         for (int i = 0; i < p.length(); i++) {
//             stkp.push(p.charAt(i));
//         }

//         while (!stks.isEmpty() && !stkp.isEmpty()) {
//            char pattern = stkp.pop();

//             if (Character.isLetter(pattern)) {
//                 char ch = stks.pop();
//                 if (ch != parttern) {
//                     return false;
//                 }
//             } else if (pattern == '.') {
//                 stks.pop();
//                 continue;
//             } else {
//                 pattern = stkp.pop();
//                 if (pattern == '.') {
//                     char ch = stks.pop();
//                     while (!stks.isEmpty() && stks.top() == ch) {
//                         stks.pop();
//                     }
//                     if (stks.isEmpty()) {
//                         return false;
//                     }
//                     stks.pop();
//                 } else if (Character.isLetter(pattern)) {
//                     while (stks.top() == pattern) {
//                         stks.pop();
//                     }
//                 }
//             }


//         }

//         if (!stks.isEmpty()) {
//             return false;
//         }

//         while (!stkp.isEmpty()) {
//             while (stkp.top() == '*') {
//                 stkp.pop();
//             }
//             if (!stkp.isEmpty()) {
//                 stkp.pop();
//             } else {
//                 return true;
//             }
//         }

//         return stkp.isEmpty();

//     }
// }

//答案

class Solution {
    public boolean isMatch(String s, String p) {

        if (s.length() == 0) {
            return checkEmpty(p);
        } 

        if (p.length() == 0) {
            return false;
        }

        char ch = s.charAt(0);
        char pattern1 = p.charAt(0), pattern2 = '0';

        if (p.length() > 1) {
            pattern2 = p.charAt(1);
        }

        if (pattern2 == '*') {
            if (compare(ch, pattern1)) {
                return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
            } else {
                return isMatch(s, p.substring(2));
            }
        } else {
            if (compare(ch, pattern1)) {
                return isMatch(s.substring(1), p.substring(1));
            } else {
                return false;
            }
        }
        
    }

    private boolean compare(char s, char p) {
        return (p == '.') || (s == p);
    }

    private boolean checkEmpty(String p) {

        if (p.length() % 2 != 0) {
            return false;
        }

        for (int i = 1; i < p.length; i += 2) {
            if (p.charAt(i) != '*') {
                return false;
            }
        } 

        return true;

    }

}


