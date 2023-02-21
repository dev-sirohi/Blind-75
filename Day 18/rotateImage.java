class Solution {
    public void rotate(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = row; col < matrix[0].length; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < (matrix[0].length / 2); col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[row][matrix[0].length - col - 1];
                matrix[row][matrix[0].length - col - 1] = temp;
            }
        }
    }
}

/*

Let's try brute force first
There's no brute force solution, we have to come up with the correct one.

[123] [456] [789]
[741] [852] [963]

n = 3

so every element moves forward by n - 1 = 2 places.

-> HINT

First transpose the matrix, then flip it.
Use swap()

*/
