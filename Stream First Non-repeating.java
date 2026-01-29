Given a string s consisting of only lowercase alphabets, for each index i in the string (0 ≤ i < n), find the first non-repeating character in the prefix s[0..i]. If no such character exists, use '#'.

Examples:

Input: s = "aabc"
Output: a#bb
  
Explanation: 
At i=0 ("a"): First non-repeating character is 'a'.
At i=1 ("aa"): No non-repeating character, so '#'.
At i=2 ("aab"): First non-repeating character is 'b'.
At i=3 ("aabc"): Non-repeating characters are 'b' and 'c'; 'b' appeared first, so 'b'. 
  
Input: s = "bb" 
Output: "b#" 
  
Explanation: 
At i=0 ("b"): First non-repeating character is 'b'.
At i=1 ("bb"): No non-repeating character, so '#'.
  
Constraints:
1 ≤ s.size() ≤ 105

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

class Solution {
    public String firstNonRepeating(String s) {
        int[] freq = new int[26];       
        Queue<Character> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            freq[ch-'a']++;
            q.add(ch);
            while(!q.isEmpty() && freq[q.peek()-'a']>1){
                q.poll();
            }
            if(q.isEmpty()){
                res.append('#');
            } 
            else{
                res.append(q.peek());
            }
        }
        return res.toString();
    }
}
