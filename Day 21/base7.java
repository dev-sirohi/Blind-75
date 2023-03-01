class Solution {
    public String convertToBase7(int num) {
        StringBuilder res = new StringBuilder();
        Boolean flag = false;
        if (num < 0) flag = true;
        num = Math.abs(num);

        while (num >= 7) {
            res.append(Integer.toString(num % 7));
            num /= 7;
        }

        res.append(num);

        if (flag) {
            res.append("-");
        }

        return res.reverse().toString();
    }
}
