You are given an array arr[] of positive integers and an integer k. You have to count the number of subarrays that contain exactly k odd numbers.

Examples:

Input: arr[] = [2, 5, 6, 9], k = 2
Output: 2
Explanation: There are 2 subarrays with 2 odds: [2, 5, 6, 9] and [5, 6, 9].
  
Input: arr[] = [2, 2, 5, 6, 9, 2, 11], k = 2
Output: 8
Explanation: There are 8 subarrays with 2 odds: [2, 2, 5, 6, 9], [2, 5, 6, 9], [5, 6, 9], [2, 2, 5, 6, 9, 2], [2, 5, 6, 9, 2], [5, 6, 9, 2], [6, 9, 2, 11] and [9, 2, 11].
  
Constraint:
1 ≤ k ≤ arr.size() ≤ 105
1 ≤ arr[i] ≤ 109

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class Solution {
    public int countSubarrays(int[] arr, int k) {
        return fun(arr,k)-fun(arr,k-1);
    }
    public int fun(int[] arr, int k) {
        int left=0,count=0,odd=0;
        for(int right=0;right<arr.length;right++){
            if(arr[right]%2==1){
                odd++;
            }
            while(odd>k){
                if(arr[left]%2==1){
                    odd--;
                }
                left++;
            }
            count += (right-left+1);
        }
        return count;
    }
}
