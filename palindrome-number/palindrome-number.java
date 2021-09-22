class Solution {
    public boolean isPalindrome(int x) {
        
        /* Edge cases: 
        1. x is negative
        2. x is a multiple of 10 except for 0
        **/
        
        if (x < 0 || ((x % 10 == 0) && x != 0)) return false;

        // Initialize the reverse integer
        int reverse = 0; 
        
        // Loop through the digits and stop when we reach half of them
        while (x > reverse){ 
            reverse = reverse * 10 + x % 10; // Update reverse by adding the digits
            x = x / 10; // Trim the last digit of the original x in each loop
        }
        
        // If the number of digits of x is even, we are done when x = reverse
        // If the number of digits of x is odd, we are done when x = reverse / 10
        return (x == reverse) || (x == reverse / 10); 
    }
}
