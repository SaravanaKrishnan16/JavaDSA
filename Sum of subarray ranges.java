Given an integer array arr[], the range of a subarray is defined as the difference between the largest and smallest elements within that subarray. Your task is to return the sum of the ranges of all possible subarrays in the array.

Note: It is guaranteed that the result will fit within a 32-bit integer.

Examples:

Input: arr[] = [1, 2, 3]
Output: 4
Explanation: The 6 subarray of arr are the following :
[1], range = largest - smallest = 1 - 1 = 0
[2], range = largest - smallest = 2 - 2 = 0
[3], range = largest - smallest = 3 - 3 = 0
[1, 2], range = largest - smallest = 2 - 1 = 1
[2, 3], range = largest - smallest = 3 - 2 = 1
[1, 2, 3], range = largest - smallest = 3 - 1 = 2
Sum of all ranges is 0 + 0 + 0 + 1 + 1 + 2 = 4
  
Input: arr[] = [-32, 0, -2, 72]
Output: 318
Explanation: 
[-32], range = largest - smallest = -32 - (-32) = 0
[-32, 0], range = largest - smallest = 0 - (-32) = 32
[-32, 0, -2], range = largest - smallest = 0 - (-32) = 32
[-32, 0, -2, 72], range= largest - smallest = 72 - (-32) = 104
[0], range = largest - smallest = 0 - 0 = 0
[0, -2], range = largest - smallest = 0 - (-2) = 2
[0, -2, 72], range = largest - smallest = 72 - (-2) = 74
[-2], range = largest - smallest = -2 - (-2) = 0
[-2, 72], range = largest - smallest = 72 - (-2) = 74
[72], range = largest - smallest = 72 - 72 = 0
Sum of all ranges is 0 + 32 + 32 + 104 + 0 + 2 + 74 + 0 + 74 + 0 = 318
  
Constraints:
1 ≤ arr.size() ≤ 106
10-9 ≤ arr[i]  ≤ 109

---

class Solution {
    private long min(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        long sum = 0;
        for(int i=0;i<=n;i++){
            int cur = (i==n) ? Integer.MIN_VALUE:arr[i];
            while(!st.isEmpty() && arr[st.peek()]>cur){
                int mid = st.pop();
                int left = st.isEmpty() ? -1:st.peek();
                int right = i;
                long count = (long)(mid-left)*(right-mid);
                sum += count*arr[mid];
            }
            st.push(i);
        }
        return sum;
    }

    private long max(int[] arr){
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        long sum = 0;
        for(int i=0;i<=n;i++){
            int cur = (i==n) ? Integer.MAX_VALUE:arr[i];
            while(!st.isEmpty() && arr[st.peek()]<cur){
                int mid = st.pop();
                int left = st.isEmpty() ? -1:st.peek();
                int right = i;
                long count = (long)(mid-left)*(right-mid);
                sum += count*arr[mid];
            }
            st.push(i);
        }
        return sum;
    }
    
    public int subarrayRanges(int[] arr) {
        long maxsum = max(arr);
        long minsum = min(arr);
        return (int)(maxsum-minsum);
    }
}
