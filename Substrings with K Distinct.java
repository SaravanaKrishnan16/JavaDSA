You are given a string s consisting of lowercase characters and an integer k, You have to count all possible substrings that have exactly k distinct characters.

Examples :

Input: s = "abc", k = 2
Output: 2
Explanation: Possible substrings are ["ab", "bc"]

Input: s = "aba", k = 2
Output: 3
Explanation: Possible substrings are ["ab", "ba", "aba"]

Input: s = "aa", k = 1
Output: 3
Explanation: Possible substrings are ["a", "a", "aa"]

Constraints:
1 ≤ s.size() ≤ 106
1 ≤ k ≤ 26

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class Solution {
    public int countSubstr(String s, int k) {
        if (k == 0) return 0;
        return fun(s,k)-fun(s,k-1);
    }
    public int fun(String s,int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0;
        int count = 0;
        for(int right=0;right<s.length();right++){
            char r = s.charAt(right);
            map.put(r,map.getOrDefault(r,0)+1);
            while(map.size()>k){
                char l = s.charAt(left);
                map.put(l,map.get(l)-1);
                if(map.get(l)==0){
                    map.remove(l);
                }
                left++;
            }
            count += (right-left+1);
        }
        return count;
    }
}
