class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix[0].length, m = matrix.length, col0 = 1, row0 = 1;

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                col0 = 0;
                break;
            }
        }

        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                row0 = 0;
                break;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (row0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }

        if (col0 == 0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}

/*

The problem was not starting at 1 instead of 0
because starting at 0 means if 0,0 is 0 then entire row0 and col0 will be 0 resulting in the entire matrix being 0 which is wrong.

*/
