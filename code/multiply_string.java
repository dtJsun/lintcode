import sun.security.jca.GetInstance;

class Solution {
    public String multiply(String num1, String num2) {
        
        if (num1.equals("0") || num2.equals("0")) return "0";

        int len1 = num1.length();
        int len2 = num2.length();

        int[] num3 = new int[len1 + len2];

        for (int i = len1 - 1; i >= 0; i--) {
            int j = len2 - 1;
            int carry = 0;
            for (; j >= 0; j--) {
                int temp = getInt(num1.charAt(i)) * getInt(num2.charAt(j)) + carry + num3[i + j + 1]; //别忘了num3[i + j + 1]
                num3[i + j + 1] = temp % 10;
                carry = temp / 10;
            }
            num3[i + j + 1] = carry;
        }

        StringBuilder sb = new StringBuilder(0);
        int i = 0;
        while (i < len1 + len2 && num3[i] == 0) {
            i++;
        }

        for (; i < len1 + len2; i++) {
            sb.append(num3[i]);
        }
        return sb.toString();
    }

    private int getInt(char ch) {
        return ch - '0';
    }

}