Dinesh is fond of video games. Due to the pandemic, he designs a video game called the Corona world. In this game, the player enters the game with a certain energy. The player should defeat all the corona infected zombies to reach the next level. When time increases the zombies will increase double the previous minute. Anyhow the player can manage to fight against all the zombies. In this case, definitely the player can not achieve the promotion. Hence the player gets a superpower to destroy all the zombies in the current level when the current game time is a palindrome. Anyhow the player can manage only if he knows the time taken to get the superpower. Help the player by providing the minimum minutes needed to get the superpower by which he can destroy all the zombies. You will be provided with the starting time of the game.

Input Format

First-line contains a string representing the starting time.

Constraints

Input time will be in 24 hours format

Output Format

A string representing the minimum minutes needed to get the superpower.

Sample Input 0

05:39

Sample Output 0

11

Explanation 0

It takes 11 minutes for minute value to become 50, 05:50 is a palindromic time.

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String time = sc.next();   
        int hour = Integer.parseInt(time.substring(0,2));
        int minute = Integer.parseInt(time.substring(3,5));
        int minutes = 0;
        while (true) {
            String h = String.format("%02d",hour);
            String m = String.format("%02d",minute);
            String t = h + m;
            if(isPalindrome(t)){
                System.out.println(minutes);
                break;
            }
            minute++;
            minutes++;
            if (minute == 60) {
                minute = 0;
                hour++;
            }
            if (hour == 24) {
                hour = 0;
            }
        }
    }

    public static boolean isPalindrome(String s) {
        int l = 0,r = s.length()-1;
        while (l<r) {
            if(s.charAt(l)!=s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
