class Solution {
    public int reverse(int x) {
        // Initialize the reverse integer
        int result = 0;
        
        // Loop through all the digits
        while (x != 0){     
            int last = x % 10;
            x = x / 10; 
            
            // Deal with overflow
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && last > Integer.MAX_VALUE % 10)) return 0; // x exceeds max
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && last < Integer.MIN_VALUE % 10)) return 0; // x less than min
            
            result = result * 10 + last; // Update the returned integer
        }
        return result;
    }
}