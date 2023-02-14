class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 0;
        for (int i = 1; i <= n; i++) {
            arr[i] = count(i);
        }

        return arr;
    }

    int count(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n = n >> 1;
        }

        return count;
    }
}


/*

This is a slower solution

public int[] countBits(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 0;
        for (int i = 1; i <= n; i++) {
            arr[i] = count(i);
        }

        return arr;
    }

    int count(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n = n >> 1;
        }

        return count;
    }

*/
