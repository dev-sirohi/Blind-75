class Solution{

    // arr: input array
    // n: size of array
    //Function to find the sum of contiguous subarray with maximum sum.
    long maxSubarraySum(int arr[], int n){
        if (n == 0) return 0;
        if (n == 1) return arr[0];
        
        int maxSum = arr[0], currSum = arr[0];
        for (int i = 1; i < n; i++) {
            if (currSum + arr[i] < arr[i]) currSum = arr[i];
            else currSum += arr[i];
            maxSum = Math.max(currSum, maxSum);
        }
        
        return maxSum;
    }
    
}

/*

So, what i did is i placed the 0th element as initial maxsum and currsum
then start with 1st element
then, check if currsum + the currelem is less than the currelem, then obviously its better to just start anew
so we do that
otherwise we add
then place the max of currsum and maxsum in maxsum
then return it

*/
