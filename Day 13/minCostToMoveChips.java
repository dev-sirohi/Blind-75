class Solution {
    public int minCostToMoveChips(int[] position) {
        int countEven = 0, countOdd = 0;
        for (int i = 0; i < position.length; i++) {
            if (position[i] % 2 == 0) countEven++;
            else countOdd++;
        }

        return Math.min(countEven, countOdd);
    }
}

/*

This is a great example of
1. THINK BEFORE YOU START WRITING CODE
2. DO CODEFORCES, YOU WONT BE ABLE TO DO ANYTHING OTHERWISE IN THE INTERVIEW

int maxOcc = position[0], currCount = 1, maxCount = 1;

        for (int i = 1; i < position.length; i++) {
            if (position[i] == position[i - 1]) {
                currCount++;
                if (currCount > maxCount) {
                    maxCount = currCount;
                    maxOcc = position[i];
                }
            } else {
                currCount = 1;
            }
        }

        currCount = 0;

        for (int i = 0; i < position.length; i++) {
            if (position[i] == maxOcc) continue;
            if (Math.abs(position[i] - maxOcc) % 2 == 0) continue;

            currCount++;
        }

        return currCount;
        
     

*/
