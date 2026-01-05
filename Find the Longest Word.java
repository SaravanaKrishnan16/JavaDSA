You are creating a dictionary analysis tool. One feature is identifying the longest word in a given sentence.

Input Format

A string (sentence)

Constraints

NA

Output Format

The longest word (string)

Sample Input 0

Find the longest word
Sample Output 0

longest
Sample Input 1

The cats sat on the mat
Sample Output 1

cats
----------------------------------------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] words = s.split(" ");
        int max = 0;
        String ans = "";
        for(String c : words){
            if(max<c.length()){
                max = Math.max(max,c.length());
                ans = c;
            }    
        }
        System.out.print(ans);
    }
}
