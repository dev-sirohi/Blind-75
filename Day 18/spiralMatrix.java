class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int n = matrix.length, m = matrix[0].length;
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = m - 1;

        while (res.size() < n * m) {
            for (int i = left; i <= right && res.size() < n * m; i++) {
                res.add(matrix[top][i]);
            }

            for (int i = top + 1; i <= bottom - 1 && res.size() < n * m; i++) {
                res.add(matrix[i][right]);
            }

            for (int i = right; i >= left && res.size() < n * m; i--) {
                res.add(matrix[bottom][i]);
            }

            for (int i = bottom - 1; i >= top + 1 && res.size() < n * m; i--) 
            res.add(matrix[i][left]);

            top++;
            bottom--;
            left++;
            right--;
        }
        
        return res;
    }
}

/*

So what were doing is we take 4 variables for 4 corners of matrix. Then we traverse from left to right and add in res. Then we traverse from top + 1 to bottom - 1 (because the top line is done and the bottom line will be done next by right->left) then we go right->left then down - 1 -> top + 1.
Then we increment top and left and decrement bottom and right, bringing them closer to the center.
To not copy duplicates, we check during each iteration if res length is less than n * m or not.

*/
