package Algorithms;
class Solution {
    public int maxProfit(int[] prices) {
        int size = prices.length,
        profit = 0;

        for(int i = 0; i < size-1; i++){
            if(prices[i] < prices[i+1])
               profit = prices[i+1] - prices[i] > profit ? prices[i+1] - prices[i] : profit;  
        }
        return profit;
    }

    public boolean canJump(int[] nums) {
        int maxRange = 0,
        goal = nums.length - 1;

        for(int i = 0; i < goal; i++){
            if(i >= maxRange)
                return false;

            maxRange = i + nums[i] > maxRange ? i + nums[i] : maxRange ;


        }
        return true;
    }
    

    // IIX
    public int romanToInt(String s) {
        int total = 0;

        char prev = ' ';

        for(int i = s.length()-1; i >= 0 ; i--){
            char actualChar = s.charAt(i);

            if(romanCharToInt(actualChar) < romanCharToInt(prev)){
                total -= romanCharToInt(actualChar);
            }
            else
                total += romanCharToInt(actualChar);

            prev = actualChar;

            
        }
        return total;

        
        
    }

    public static int romanCharToInt(char c){
        return switch(c){
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> -1;
            };
    }


    public static void main(String[] args){
        Solution solution = new Solution();
        int[] prices = {2,1,2,0,1};
        int[] nums = {3,2,1,0,4};
        System.out.println(solution.maxProfit(prices));
        System.out.println(solution.canJump(nums));

        System.out.println("XXXIII in numbers is: " + solution.romanToInt("XXXIII"));
        System.out.println("IX in numbers is: " + solution.romanToInt("IX"));
        System.out.println("LVIII in numbers is: " + solution.romanToInt("LVIII"));
    }
 
}