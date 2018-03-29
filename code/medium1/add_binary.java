class Solution {
    public String addBinary(String a, String b) {
        
        int indexa = a.length() - 1;
        int indexb = b.length() - 1;
        
        int carry = 0;

        StringBuilder sb = new StringBuilder();

        while (indexa >= 0 && indexb >= 0) {

            int cha = a.charAt(indexa) - '0';
            int chb = b.charAr(indexb) - '0';

            int sum = cha + chb + carry;

            int curr = sum % 2;

            carry = sum / 2;

            sb.append(curr);

            indexa--;
            indexb--;
        }

        if (indexa < 0) {
            while (indexb >= 0) {
                int chb = b.charAt(indexb) - '0';
                int sum = chb + carry;
                int curr = sum % 2;
                carry = sum / 2;
                sb.append(curr);
                indexb--;
            }
        } else {
            while (indexa >= 0) {
                int cha = a.charAt(indexa) - '0';
                int sum = cha + carry;
                int curr = sum % 2;
                carry = sum / 2;
                sb.append(curr);
                indexa--;
            }
        }
        
        sb = sb.reverse();
        
        return sb.toString();
        
    }
}