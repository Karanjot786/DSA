import java.util.*;

public class StringMultiplication{
    public static String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];
    
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }  
        
        StringBuilder sb = new StringBuilder();
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        String num1="123";
        String num2="456";
        System.out.println(multiply(num1,num2));
    }
}

// Intuition
// Start from right to left, perform multiplication on every pair of digits, and add them together.



// Approach

// m and n store the lengths of num1 and num2, respectively.
// An integer array pos of size m + n is initialized to store the intermediate results of the multiplication. The maximum possible length of the product of two numbers is the sum of their lengths.
// The outer loop iterates over each digit of num1 from the least significant digit to the most significant digit (right to left).
// The inner loop does the same for num2.
// For each pair of digits, it calculates the product (mul) of the two digits (converted from characters to integers).
// p1 and p2 are calculated to determine the positions in the pos array where the results will be stored.
// p1 corresponds to the position for carrying over (if any) and p2 corresponds to the position for the current digit.
// The sum of the current product and any existing value in pos[p2] is computed.
// The carry (if any) is added to pos[p1], and the current digit (mod 10) is stored in pos[p2].

// A StringBuilder is used to build the final result string.
// The loop iterates over the pos array to append non-zero digits to sb. It skips leading zeros by checking if sb is empty and the current digit is zero.
// Finally, if sb is still empty (which means the product is zero), it returns "0". Otherwise, it converts the StringBuilder to a string and returns it.
